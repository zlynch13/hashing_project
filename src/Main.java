import bloom.Hash;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int m = 10000000;
        int k = 7;
        Hash filter = new Hash(m, k);

        String filePath = "pwnedpasswords.txt";
        int totalToLoad = 1000000; // 1 million samples
        int trainSize   = 800000;  // 80% train 20% negative

        List<String> trainSet    = new ArrayList<>();
        List<String> negativeSet = new ArrayList<>();

        System.out.println("Loading dataset...\n"); // adding hashes to train and negative lists
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null && count < totalToLoad) {
            String hash = line.split(":")[0].trim(); // ignore the count after colon
            if (count < trainSize) {
                trainSet.add(hash);
            } else {
                negativeSet.add(hash);
            }
            count++;
        }
        reader.close();
        System.out.println("Loaded " + count + " hashes total");
        System.out.println("Train set:    " + trainSet.size());
        System.out.println("Negative set: " + negativeSet.size() + "\n");

        // Inserting training set into bit array
        System.out.println("Inserting training set...");
        for (String hash : trainSet) {
            filter.insert(hash);
        }
        System.out.println("Insertion complete\n");

        // Negative test
        System.out.println("Running negative test...");
        int falsePositives = 0;
        for (String hash : negativeSet) {
            if (filter.query(hash)) falsePositives++;
        }

        double fpRate   = (double) falsePositives / negativeSet.size() * 100;

        System.out.println("Negative test results:");
        System.out.println("  Queried:           " + negativeSet.size());
        System.out.println("  False positives:   " + falsePositives);
        System.out.printf( "  FP rate:  %.4f%%%n\n", fpRate);

        // Speed test
        int trials = 1000;
        long start = System.nanoTime();
        for (int i = 0; i < trials; i++) {
            filter.query(trainSet.get(i));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("%nSpeed: avg query time = %.2f ns%n", (double) elapsed / trials);
    }
}