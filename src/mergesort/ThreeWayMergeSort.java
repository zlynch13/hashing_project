package mergesort;
import java.util.Random;

public class ThreeWayMergeSort {
    private static void threeWaySort(int[] arr, int leftSide, int rightSide) {
//     if (rightSide <= leftSide) return;
        if (leftSide >= rightSide) return;
        if (rightSide - leftSide == 1) {
            int temp = arr[leftSide];
            if (arr[leftSide] > arr[rightSide]) {
                arr[leftSide] = arr[rightSide];
                arr[rightSide] = temp;
            }
            return;
        }
        int oneThird = (rightSide - leftSide+1)/3;
        int leftMid = leftSide + oneThird;
        int rightMid = leftSide + 2*oneThird;
        if (rightMid >= rightSide) {
            rightMid = rightSide -1;
        }

        threeWaySort(arr, leftSide, leftMid);
        threeWaySort(arr, leftMid+1, rightMid);
        threeWaySort(arr, rightMid+1, rightSide);
        merge(arr, leftSide, rightSide, leftMid, rightMid);

    }
    private static void merge(int[] arr, int leftSide, int rightSide, int leftMid, int rightMid) {
        int llength = leftMid - leftSide + 1;
        int mlength = rightMid - leftMid;
        int rlength = rightSide - rightMid;

        int[] l =  new int[llength];
        int[] m = new int[mlength];
        int[] r = new int[rlength];
        int i;
        int j;
        int k;
        for (i = 0; i < llength; i++) l[i] = arr[leftSide+i];
        for (j = 0; j < mlength; j++) m[j] = arr[leftMid+j+1];
        for (k = 0; k < rlength; k++) r[k] = arr[rightMid+k+1];

        i = 0;
        j = 0;
        k = 0;
        int arrIndex = leftSide;

        while (i < llength && j < mlength && k < rlength) {
            if (l[i] <= m[j] && l[i] <= r[k]) {
                arr[arrIndex] = l[i];
                i++;
            }
            else if (m[j] < r[k]) {
                arr[arrIndex] = m[j];
                j++;
            }
            else {
                arr[arrIndex] = r[k];
                k++;
            }
            arrIndex++;
        }

        while (i < llength && j < mlength) {
            if (l[i] <= m[j]) {
                arr[arrIndex] = l[i];
                i++;
            }
            else {
                arr[arrIndex] = m[j];
                j++;
            }
            arrIndex++;
        }
        while (i < llength && k < rlength) {
            if (l[i] <= r[k]) {
                arr[arrIndex] = l[i];
                i++;
            }
            else {
                arr[arrIndex] = r[k];
                k++;
            }
            arrIndex++;
        }
        while (j < mlength && k < rlength) {
            if (m[j] <= r[k]) {
                arr[arrIndex] = m[j];
                j++;
            }
            else {
                arr[arrIndex] = r[k];
                k++;
            }
            arrIndex++;
        }

        while (i < llength) {
            arr[arrIndex] = l[i];
            arrIndex++;
            i++;
        }
        while (j < mlength) {
            arr[arrIndex] = m[j];
            arrIndex++;
            j++;
        }
        while (k < rlength) {
            arr[arrIndex] = r[k];
            arrIndex++;
            k++;
        }
    }

    private static void threeWaySort(double[] arr, int leftSide, int rightSide) {
//     if (rightSide <= leftSide) return;
        if (leftSide >= rightSide) return;
        if (rightSide - leftSide == 1) {
            double temp = arr[leftSide];
            if (arr[leftSide] > arr[rightSide]) {
                arr[leftSide] = arr[rightSide];
                arr[rightSide] = temp;
            }
            return;
        }

        int oneThird = (rightSide - leftSide+1)/3;
        int leftMid = leftSide + oneThird;
        int rightMid = leftSide + 2*oneThird;

        if (rightMid >= rightSide) {
            rightMid = rightSide -1;
        }

        threeWaySort(arr, leftSide, leftMid);
        threeWaySort(arr, leftMid+1, rightMid);
        threeWaySort(arr, rightMid+1, rightSide);
        merge(arr, leftSide, rightSide, leftMid, rightMid);

    }
    private static void merge(double[] arr, int leftSide, int rightSide, int leftMid, int rightMid) {
        int llength = leftMid - leftSide + 1;
        int mlength = rightMid - leftMid;
        int rlength = rightSide - rightMid;

        double[] l =  new double[llength];
        double[] m = new double[mlength];
        double[] r = new double[rlength];
        int i;
        int j;
        int k;
        for (i = 0; i < llength; i++) l[i] = arr[leftSide+i];
        for (j = 0; j < mlength; j++) m[j] = arr[leftMid+j+1];
        for (k = 0; k < rlength; k++) r[k] = arr[rightMid+k+1];

        i = 0;
        j = 0;
        k = 0;
        int arrIndex = leftSide;

        while (i < llength && j < mlength && k < rlength) {
            if (l[i] <= m[j] && l[i] <= r[k]) {
                arr[arrIndex] = l[i];
                i++;
            }
            else if (m[j] < r[k]) {
                arr[arrIndex] = m[j];
                j++;
            }
            else {
                arr[arrIndex] = r[k];
                k++;
            }
            arrIndex++;
        }

        while (i < llength && j < mlength) {
            if (l[i] <= m[j]) {
                arr[arrIndex] = l[i];
                i++;
            }
            else {
                arr[arrIndex] = m[j];
                j++;
            }
            arrIndex++;
        }
        while (i < llength && k < rlength) {
            if (l[i] <= r[k]) {
                arr[arrIndex] = l[i];
                i++;
            }
            else {
                arr[arrIndex] = r[k];
                k++;
            }
            arrIndex++;
        }
        while (j < mlength && k < rlength) {
            if (m[j] <= r[k]) {
                arr[arrIndex] = m[j];
                j++;
            }
            else {
                arr[arrIndex] = r[k];
                k++;
            }
            arrIndex++;
        }

        while (i < llength) {
            arr[arrIndex] = l[i];
            arrIndex++;
            i++;
        }
        while (j < mlength) {
            arr[arrIndex] = m[j];
            arrIndex++;
            j++;
        }
        while (k < rlength) {
            arr[arrIndex] = r[k];
            arrIndex++;
            k++;
        }
    }

    public static int[] mainMerge(int[] arr){
        if (arr.length < 2) return arr;
        threeWaySort(arr, 0, arr.length-1);
        return arr;
    }
    public static double[] mainMerge(double[] arr){
        if (arr.length < 2) return arr;
        threeWaySort(arr, 0, arr.length-1);
        return arr;
    }
    public static double runIntTest(int size, Random rand) {
//        Random rand = new Random();
        int[] intTest = new int[size];
        for (int i = 0; i < size; i++) {
            intTest[i] = rand.nextInt();
        }
        long start = System.nanoTime();
        threeWaySort(intTest, 0, size - 1);
        long finish = System.nanoTime();
//        System.out.println(size + " Integer Array time in ms: " + (finish - start) / 1000000.0 );
        for (int i = 0; i < size-1; i++) {
            if (intTest[i] > intTest[i+1]) {
                System.out.println("Failure");
                break;
            }
        }
        return (finish-start)/ 1000000.0;
    }
    public static double runDoubleTest(int size, Random rand) {
//        Random rand = new Random();
        double[] doubleTest = new double[size];
        for (int i = 0; i < size; i++) {
            doubleTest[i] = rand.nextDouble();
        }
        long start = System.nanoTime();
        threeWaySort(doubleTest, 0, size - 1);
        long finish = System.nanoTime();
//        System.out.println(size + " Double Array time in ms: " + (finish - start) / 1000000.0 );
        for (int i = 0; i < size-1; i++) {
            if (doubleTest[i] > doubleTest[i+1]) {
                System.out.println("Failure");
                break;
            }
        }
        return (finish - start) / 1000000.0;
    }
    public static void main(String[] args) {
        testTime();
    }
    public static void testTime() {
        Random rand = new Random();

        //I added this because it seems to struggle with the first run
        int sizeWarmup = 1 << (20);
        int[] warmup = new int[sizeWarmup];
        for (int i = 0; i < sizeWarmup; i++) {
            warmup[i] = rand.nextInt();
        }

        warmup = mainMerge(warmup);
        for (int exp = 0; exp < 7; exp++) {
            int size = 1 << (20+exp);
            double intTime = 0.0;
            double doubleTime = 0.0;
            int runs = 10;
            for (int j = 0; j < runs; j++)
            {
                intTime += runIntTest(size, rand);
                doubleTime += runDoubleTest(size, rand);
            }
            System.out.println("2^" + (20+exp) + " Integer average Array time in ms: " + intTime/ runs);
            System.out.println("2^" + (20+exp) + " Double average Array time in ms: " + doubleTime/ runs);
            System.out.println();
        }
    }
}