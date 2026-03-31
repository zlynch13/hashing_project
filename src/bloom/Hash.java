package bloom;

public class Hash {
     boolean[] bitArray;
    int m; // size of the bit array
    int k; // number of indices per key

    public Hash(int m, int k) {
        this.m = m;
        this.k = k;
        this.bitArray = new boolean[m];
    }

    // First base hash
    public int bloomHash(String x) {
        int hash = 0;
        for (int i = 0; i < x.length(); i++) {
            hash += x.charAt(i);
        }
        return hash;
    }

    // Second base hash with different mixing
    public int bloomHash2(String x) {
        int hash = 5381;
        for (int i = 0; i < x.length(); i++) {
            hash = hash * 33 + x.charAt(i);
        }
        return hash;
    }

    // Double hashing: produces k indices from the two base hashes
    public int[] getIndices(String key) {
        int h1 = bloomHash(key);
        int h2 = bloomHash2(key);
        int[] indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = Math.floorMod(h1 + i * h2, m);
        }
        return indices;
    }

    public void insert(String key) {
        for (int idx : getIndices(key)) {
            bitArray[idx] = true;
        }
    }

    public boolean query(String key) {
        for (int idx : getIndices(key)) {
            if (!bitArray[idx]) return false;
        }
        return true;
    }


}