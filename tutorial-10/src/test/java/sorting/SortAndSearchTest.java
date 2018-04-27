package sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SortAndSearchTest {
    //TODO Implement, apply your test cases here

    private static long oneSecondInNano = 100000000;

    private int[] testArr1;
    private int[] testArr2;
    private int searchedValue = 40738;
    private int randomElement = -11111;

    @Before
    public void setUp() throws IOException {
        testArr1 = Main.convertInputFileToArray();
        testArr2 = testArr1.clone();
    }

    @Test
    public void testEachFinderFindCorrectly() {
        assertEquals(searchedValue, Finder.slowSearch(testArr1, searchedValue));
        assertEquals(searchedValue, Finder.quickSearch(testArr1, searchedValue));
        int[] sortedArray = Sorter.quickSort(testArr1);
        assertEquals(searchedValue, Finder.binarySearch(sortedArray, searchedValue));
    }

    @Test
    public void testEachFinderNotFoundCase() {
        assertEquals(-1, Finder.slowSearch(testArr1, randomElement));
        assertEquals(-1, Finder.quickSearch(testArr1, randomElement));
        int[] sortedArray = Sorter.quickSort(testArr1);
        assertEquals(-1, Finder.binarySearch(sortedArray, randomElement));
    }

    @Test
    public void testEachSorterSortCorrectly() {
        assertTrue(isSorted(Sorter.slowSort(testArr1)));
        assertTrue(isSorted(Sorter.quickSort(testArr2)));
    }

    private static boolean isSorted(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}