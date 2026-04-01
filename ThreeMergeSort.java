public class ThreeMergeSort {
    private static void threeWaySort(int[] arr, int leftSide, int rightSide) {
//     if (rightSide <= leftSide) return;
       if (rightSide - leftSide < 2) return;

        int oneThird = (rightSide - leftSide)/3;
        int leftMid = leftSide + oneThird;
        int rightMid = leftSide + 2*oneThird;

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
        int i = 0;
        int j = 0;
        int k = 0;
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
        if (rightSide - leftSide < 2) return;

        int oneThird = (rightSide - leftSide)/3;
        int leftMid = leftSide + oneThird;
        int rightMid = leftSide + 2*oneThird;

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
        int i = 0;
        int j = 0;
        int k = 0;
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
    public static void main(String[] args) {

    }
}
