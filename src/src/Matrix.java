package src;
import java.util.Arrays;
import java.util.Random;

public class Matrix {
    public static boolean isSquareMatrix(int[][] matrix) {
        if (matrix.length == matrix[0].length) {
            return true;
        }
        return matrix.length != matrix[0].length;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

    public static int[][] mirrorMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] mirroredMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                mirroredMatrix[i][cols - 1 - j] = matrix[i][j];
            }
        }

        return mirroredMatrix;
    }

    public static int[][] rotate90Degrees(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] rotatedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[j][rows-1-i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    public static int sumDiagonal(int[][] matrix) {
        if (!isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Die src.Matrix muss quadratisch sein.");
        }

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }


    public static int[][] hadamardProduct(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        if (rows != matrixB.length || cols != matrixB[0].length) {
            throw new IllegalArgumentException("Die Matrizen müssen die gleiche Größe haben.");
        }

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] * matrixB[i][j];
            }
        }

        return result;
    }

    public static void sortMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //create an array with the values
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }

        //order the array from small to big
        Arrays.sort(array);
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length - i - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }

        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index++];
            }
        }
    }

    public static int[][] generateRandomMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }
}

