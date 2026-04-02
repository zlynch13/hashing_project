package bitarray;

public class BitArray {
    private static long[] bitArray;

    public static void allocate(int size) {
        bitArray = new long[(size+63)/64];
    }

    public static void set_bit(int loc) {
        int arrayPosition = loc/64;
        long bitPosition = (long)1 << (loc%64);
        bitArray[arrayPosition] =  bitArray[arrayPosition] | bitPosition;
    }

    public static boolean check_bit(int loc) {
        int arrayPosition = loc/64;
        long bitPosition = (long)1 << (loc%64);
        return ((bitArray[arrayPosition] & bitPosition) != 0);
    }

    public static void main (String[] args) {
    }
}
