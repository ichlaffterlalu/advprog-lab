package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String pathFile = "plainTextDirectory/input/sortingProblem.txt";
    private static int numberOfItemToBeSorted = 50000;

    public static void main(String[] args) throws IOException {

        int[] sequenceInput = convertInputFileToArray();
        int[] backupArray = sequenceInput.clone();

        // Warmup iteration for search
        for (int i = 0; i < 1000; i++) {
            //Searching Input Before Sorting using Slow Search
            Finder.slowSearch(sequenceInput, 40738);
            //Searching Input Before Sorting using Quick Search (not too quick)
            Finder.quickSearch(sequenceInput, 40738);
        }

        // Test iteration for search
        long totalAllNanosSlow = 0;
        long totalAllNanosQuick = 0;
        for (int i = 0; i < 10000; i++) {
            //Searching Input Before Sorting using Slow Search
            long initialNanosSlow = System.nanoTime();
            Finder.slowSearch(sequenceInput, 40738);
            totalAllNanosSlow += System.nanoTime() - initialNanosSlow;

            //Searching Input Before Sorting using Quick Search (not too quick)
            long initialNanosQuick = System.nanoTime();
            Finder.quickSearch(sequenceInput, 40738);
            totalAllNanosQuick += System.nanoTime() - initialNanosQuick;
        }

        System.out.println("Average Slow Search: " + (totalAllNanosSlow/10000));
        System.out.println("Average Quick Search: " + (totalAllNanosQuick/10000));

        // Warmup iterations for sorting
        for (int i = 0; i < 10; i++) {
            //Sorting using Slow Sort
            Sorter.slowSort(sequenceInput);
            //Sorting using Quick Sort
            Sorter.quickSort(sequenceInput);
        }

        totalAllNanosQuick = 0;
        totalAllNanosSlow = 0;
        // Test iterations for sorting
        for (int i = 0; i < 100; i++) {
            //Searching Input Before Sorting using Slow Search
            long initialNanosSlow = System.nanoTime();
            Sorter.slowSort(sequenceInput);
            sequenceInput = backupArray.clone();
            totalAllNanosSlow += System.nanoTime() - initialNanosSlow;

            //Searching Input Before Sorting using Quick Search (not too quick)
            long initialNanosQuick = System.nanoTime();
            Sorter.quickSort(sequenceInput);
            sequenceInput = backupArray.clone();
            totalAllNanosQuick += System.nanoTime() - initialNanosQuick;
        }

        System.out.println("Average Slow Sort: " + (totalAllNanosSlow/100));
        System.out.println("Average Quick Sort: " + (totalAllNanosQuick/100));

        //Searching Input After Sorting
        sequenceInput = Sorter.quickSort(sequenceInput);

        // Warmup iteration for search
        for (int i = 0; i < 1000; i++) {
            //Searching Input After Sorting using Binary Search
            Finder.binarySearch(sequenceInput, 40738);
        }

        // Test iteration for searchgit
        long totalAllNanosBinary = 0;
        for (int i = 0; i < 10000; i++) {
            //Searching Input After Sorting using Binary Search
            long initialNanosBinary = System.nanoTime();
            Finder.binarySearch(sequenceInput, 40738);
            totalAllNanosSlow += System.nanoTime() - initialNanosBinary;
        }

        System.out.println("Average Binary Search: " + (totalAllNanosBinary/10000));
    }

    /**
     * Converting a file input into an array of integer.
     * @return an array of integer that represent an integer sequence.
     * @throws IOException in the case of the file is not found because of the wrong path of file.
     */
    public static int[] convertInputFileToArray() throws IOException {
        File sortingProblemFile = new File(pathFile);
        FileReader fileReader = new FileReader(sortingProblemFile);
        int[] sequenceInput = new int[numberOfItemToBeSorted];

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        int indexOfSequence = 0;
        while ((currentLine = bufferedReader.readLine()) != null) {
            sequenceInput[indexOfSequence] = Integer.parseInt(currentLine);
            indexOfSequence++;
        }
        return sequenceInput;
    }
}
