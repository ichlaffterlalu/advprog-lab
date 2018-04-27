package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class NonSquareMatrixTest {

    private static int row = 38;
    private static int column = 47;
    private static String genericMatrixPath = "plainTextDirectory/input/matrixProblem";
    private static String pathFileMatrix1 = genericMatrixPath + "A/matrixProblemSet1.txt";

    private static double[][] sample;

    @Before
    public void setUp() throws IOException {
        sample = Main.convertInputFileToMatrix(pathFileMatrix1, row, column);
    }

    @Test
    public void checkMatrixIsNonSquare() {
        assertTrue(sample.length != sample[0].length);
    }

    @Test
    public void checkMatrixOrdoIsCorrect() {
        assertEquals(row, sample.length);
        assertEquals(column, sample[0].length);
    }
}