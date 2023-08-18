package src;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    public static boolean isSquareMatrix(int[][] matrix) {
        return matrix.length > 0 && matrix.length == matrix[0].length;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
    
        int[][] transposedMatrix = new int[cols][rows];
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
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
                mirroredMatrix[i][j] = matrix[i][cols - j - 1]; // Spiegelung an der Vertikalen
            }
        }
    
        return mirroredMatrix;
    }
    

    public static int[][] rotate90Degrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
    
        int[][] rotatedMatrix = new int[m][n]; // Vertausche Zeilen und Spalten
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][n - i - 1] = matrix[i][j]; // Drehe um 90 Grad
            }
        }
    
        return rotatedMatrix;
    }
    

    public static int sumDiagonal(int[][] matrix) {
        if (!isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");
        }
    
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i]; // Hauptdiagonalelemente addieren
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
                result[i][j] = matrixA[i][j] * matrixB[i][j]; // Element-für-Element-Multiplikation
            }
        }
    
        return result;
    }
    

    public static void sortMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] flattenedArray = new int[rows * cols];
        int index = 0;

        // Flattening the matrix into a 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flattenedArray[index++] = matrix[i][j];
            }
        }

        // Sorting the flattened array
        Arrays.sort(flattenedArray);

        // Filling the sorted values back into the matrix
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = flattenedArray[index++];
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
