package sorting;


public class Sorter {

    /**
     * Some sorting algorithm that possibly the slowest algorithm.
     *
     * @param inputArr array of integer that need to be sorted.
     * @return a sorted array of integer.
     */

    public static int[] slowSort(int[] inputArr) {
        int temp;
        for (int i = 1; i < inputArr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (inputArr[j] < inputArr[j - 1]) {
                    temp = inputArr[j];
                    inputArr[j] = inputArr[j - 1];
                    inputArr[j - 1] = temp;
                }
            }
        }
        return inputArr;
    }

    /**
     * Quick sort algorithm is a sorting algorithm with partitioning.
     * This is the helper method.
     * @param inputArr array of integer that need to be sorted.
     * @return a sorted array of integer
     */
    public static int[] quickSort(int[] inputArr) {
        quickSortTail(inputArr, 0, inputArr.length - 1);
        return inputArr;
    }

    /**
     * Quick sort main method.
     * @param inputArr array of integer that need to be sorted.
     * @param start partition start index.
     * @param end partition ending index.
     */
    private static void quickSortTail(int[] inputArr, int start, int end) {
        int i = start;
        int j = end;
        int pivot = inputArr[start + (end - start) / 2];

        while (i <= j) {
            while (i < end && inputArr[i] < pivot) {
                i++;
            }
            while (j > start && inputArr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(inputArr, i, j);
                i++;
                j--;
            }
        }
        swap(inputArr, i, end);
        if (start < j) {
            quickSortTail(inputArr, start, j);
        }
        if (i < end) {
            quickSortTail(inputArr, i, end);
        }
    }

    /**
     * Method that wraps swapping in array.
     * @param inputArr array that needs to be operated.
     * @param idx1 first object's index.
     * @param idx2 second object's index.
     */
    private static void swap(int[] inputArr, int idx1, int idx2) {
        int temp = inputArr[idx1];
        inputArr[idx1] = inputArr[idx2];
        inputArr[idx2] = temp;
    }

}
