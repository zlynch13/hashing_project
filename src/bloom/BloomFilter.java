package bloom;

public class BloomFilter {
    private boolean[] bitArray;
    private int m;
    private int k;

    public BloomFilter(int n, double p) {
        this.m = BloomFilterSizer.computeM(n, p);
        this.k = BloomFilterSizer.computeK(n, p);
        this.bitArray = new boolean[m];
    }

    public int getM() {
        return m;
    }

    public int getK() {
        return k;
    }
}