package sorting;

public class Finder {


    /**
     * Some searching algorithm that possibly the slowest algorithm.
     * This algorithm can search a value irregardless of whether the sequence already sorted or not.
     * @param arrOfInt is a sequence of integer.
     * @param searchedValue value that need to be searched inside the sequence.
     * @return -1 if there are no such value inside the sequence, else return searchedValue.
     */
    public static int slowSearch(int[] arrOfInt, int searchedValue) {
        int returnValue = -1;

        for (int element : arrOfInt) {
            if (element == searchedValue) {
                returnValue = element;
            }
        }

        return returnValue;
    }

    /**
     * This is still a standard linear sort, but it returns immediately after found a result
     * instead of having it looping until the end of array.
     * @param arrOfInt is a sequence of integer.
     * @param searchedValue is the value that need to be searched .
     * @return -1 if there are no such value inside the sequence, else return searchedValue.
     */
    public static int quickSearch(int[] arrOfInt, int searchedValue) {
        for (int element : arrOfInt) {
            if (element == searchedValue) {
                return element;
            }
        }

        return -1;
    }

    /**
     * Helper method for Binary Search.
     * @param arrOfInt is a sorted array of integer.
     * @param searchedValue is the value that need to be searched.
     * @return -1 if there are no such value inside the sequence, else return searchedValue.
     */
    public static int binarySearch(int[] arrOfInt, int searchedValue) {
        return binarySearch(arrOfInt, searchedValue, 0, arrOfInt.length-1);

    }

    /**
     * Main method for Binary Search, it's only applicable for sorted arrays.
     * @param arrOfInt is a sorted array of integer.
     * @param searchedValue is the value that need to be searched.
     * @param start is the start index of the partition.
     * @param end is the ending index of the partition.
     * @return -1 if there are no such value inside the sequence, else return searchedValue.
     */
    private static int binarySearch(int[] arrOfInt, int searchedValue, int start, int end) {
        if(end >= 1) {
            int mid = start + (end - start) / 2;

            if(arrOfInt[mid] == searchedValue) {
                return searchedValue;
            }

            if (arrOfInt[mid] > searchedValue) {
                return binarySearch(arrOfInt, searchedValue, start, mid-1);
            }gi

            return binarySearch(arrOfInt, searchedValue, mid+1, end);
        }
        return -1;
    }
}
