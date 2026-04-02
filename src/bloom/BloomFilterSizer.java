package bloom;

public class BloomFilterSizer {

    public static int computeM(int n, double p) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        if (p <= 0.0 || p >= 1.0) {
            throw new IllegalArgumentException("p must be between 0 and 1");
        }

        double numerator = -n * Math.log(p);
        double denominator = Math.pow(Math.log(2), 2);

        return (int) Math.ceil(numerator / denominator);
    }

    public static int computeK(int n, double p) {
        int m = computeM(n, p);
        return Math.max(1, (int) Math.round((m / (double) n) * Math.log(2)));
    }

    public static double bitsToMegabytes(int bits) {
        return bits / 8.0 / 1024.0 / 1024.0;
    }

    public static void printSizingReport(int n, double p) {
        int m = computeM(n, p);
        int k = computeK(n, p);

        System.out.println("Bloom Filter Sizing");
        System.out.println("-------------------");
        System.out.println("n (items)              = " + n);
        System.out.println("p (false positive rate)= " + p);
        System.out.println("m (bits)               = " + m);
        System.out.println("k (hash functions)     = " + k);
        System.out.printf("Approx memory          = %.2f MB%n", bitsToMegabytes(m));
    }
}