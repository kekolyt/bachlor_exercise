package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import src.Matrix;

public class MatrixTest {
    @Test
    @DisplayName("Test if random matrix has correct size")
    public void testGenerateRandomMatrixSize_1P() {
        int rows = 5;
        int cols = 4;

        int[][] matrix = Matrix.generateRandomMatrix(rows, cols);

        assertEquals(rows, matrix.length, "Wrong number of rows.");
        for (int[] row : matrix) {
            assertEquals(cols, row.length, "Wrong number of columns.");
        }
    }

    @Test
    @DisplayName("Test if random matrix has just digits (0-9)")
    public void testGenerateRandomMatrixValues_1P() {
        int rows = 5;
        int cols = 4;

        int[][] matrix = Matrix.generateRandomMatrix(rows, cols);

        for (int[] row : matrix) {
            for (int value : row) {
                assertTrue(value >= 0 && value <= 9, "Value is not a digit.");
            }
        }
    }

    @Test
    @DisplayName("Test if 3x3 matrix is square")
    public void isSquareMatrixTest_3x3_1P() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertTrue(Matrix.isSquareMatrix(matrix), "3x3 matrix should be square.");
    }

    @Test
    @DisplayName("Test if 3x2 matrix is not square")
    public void isSquareMatrixTest_3x2_1P() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        assertFalse(Matrix.isSquareMatrix(matrix), "3x2 matrix should not be square.");
    }

    @Test
    @DisplayName("Test transposition for 2x3 matrix")
    public void transposeTest_2x3_1P() {
        System.out.println("\nTransponieren:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        printMatrix(matrix);
        int[][] expected = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        matrix = Matrix.transpose(matrix);
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test mirroring for 2x3 matrix")
    public void mirrorTest_2x3_1P() {
        System.out.println("\nSpiegeln:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        printMatrix(matrix);
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4}
        };
        matrix = Matrix.mirrorMatrix(matrix);
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test 90-degree rotation for 2x3 matrix")
    public void rotate90DegreesTest_2x3_1P() {
        System.out.println("\nRotation:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        printMatrix(matrix);
        int[][] expected = {
                {4, 1},
                {5, 2},
                {6, 3}
        };
        matrix = Matrix.rotate90Degrees(matrix);
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test diagonal sum of 3x3 matrix")
    public void sumDiagonalTest_3x3_1P() {
        System.out.println("\nDiagonalsumme:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(matrix);
        int expected = 1 + 5 + 9;
        int ergebnis = Matrix.sumDiagonal(matrix);
        System.out.println("\nErgebnis: "+ergebnis);
        assertEquals(expected, ergebnis);
    }

    @Test
    @DisplayName("Test Hadamard product of 2x2 matrices")
    public void hadamardProductTest_2x2_1P() {
        System.out.println("\nHadamard-Produkt:");
        int[][] matrixA = {
                {1, 2},
                {3, 4}
        };
        System.out.println("src.Matrix A:");
        printMatrix(matrixA);
        int[][] matrixB = {
                {5, 6},
                {7, 8}
        };
        System.out.println("\nsrc.Matrix B:");
        printMatrix(matrixB);
        int[][] expected = {
                {1*5, 2*6},
                {3*7, 4*8}
        };
        int[][] ergebnis = Matrix.hadamardProduct(matrixA, matrixB);
        System.out.println("\nErgebnis:");
        printMatrix(ergebnis);
        assertArrayEquals(expected, ergebnis);
    }

    @Test
    @DisplayName("Test sorting of 2x3 matrix")
    public void sortMatrixTest_2x3_1P() {
        System.out.println("\nSortierung:");
        int[][] matrix = {
                {9, 7, 5},
                {1, 3, 8}
        };
        printMatrix(matrix);
        int[][] expected = {
                {1, 3, 5},
                {7, 8, 9}
        };
        Matrix.sortMatrix(matrix);
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test horizontal folding of 4x3 matrix")
    public void foldMatrixHorizontalTest_4x3_1P() {
        System.out.println("\nFaltung horizontal/gerade:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        printMatrix(matrix);
        int[][] expected = {
                {10, 22, 36},
                {28, 40, 54}
        };
        matrix = Matrix.foldMatrix(matrix, "horizontal");
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test horizontal folding of 5x3 matrix")
    public void foldMatrixHorizontalTest_5x3_1P() {
        System.out.println("\nFaltung horizontal/ungerade:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };
        printMatrix(matrix);
        int[][] expected = {
                {13, 28, 45},
                {40, 55, 72},
                {7, 8, 9}
        };
        matrix = Matrix.foldMatrix(matrix, "horizontal");
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test vertical folding of 3x4 matrix")
    public void foldMatrixVerticalTest_3x4_1P() {
        System.out.println("\nFaltung vertikal/gerade:");
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        printMatrix(matrix);
        int[][] expected = {
                {4, 6},
                {40, 42},
                {108, 110}
        };
        matrix = Matrix.foldMatrix(matrix, "vertical");
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Test vertical folding of 3x5 matrix")
    public void foldMatrixVerticalTest_3x5_1P() {
        System.out.println("\nFaltung vertikal/ungerade:");
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        printMatrix(matrix);
        int[][] expected = {
                {5, 8, 3},
                {60, 63, 8},
                {165, 168, 13}
        };
        matrix = Matrix.foldMatrix(matrix, "vertical");
        System.out.println("\nErgebnis:");
        printMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    /**
     * Gibt eine gegebene src.Matrix aus.
     *
     * @param matrix Die auszugebende src.Matrix.
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
