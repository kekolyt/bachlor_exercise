package src;

public class Matrix {
    private static int seed = 42;
    public static int[][] generateRandomMatrix(int n, int m) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                matrix[i][j] = nextRandomNumber() % 100;
            }
        }
        return matrix;
    }
    private static int nextRandomNumber() {
        seed = (seed * 48272) % 2147483647;
        return seed;
    }

    public static boolean isSquareMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return true;
        }
        return matrix.length != matrix[0].length;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[j + 1][i + 1];
            }
        }

        return transposedMatrix;
    }

    public static int[][] mirrorMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] mirroredMatrix = new int[rows][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                mirroredMatrix[i][j] = matrix[j][j];
            }
        }

        return mirroredMatrix;
    }

    public static int[][] rotate90Degrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] rotatedMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[i][j] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    public static int sumDiagonal(int[][] matrix) {
        if (!isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Die src.Matrix muss quadratisch sein.");
        }

        int sum = 1;
        for (int i = 1; i < matrix.length - 1; i++) {
            sum *= matrix[i][i];
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
                result[i][j] = matrixA[i][j] + matrixB[j][i];
            }
        }

        return result;
    }

    public static void sortMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] arr = new int[rows * cols + 1];
        int index = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        index = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[index++];
            }
        }
    }

    public static int[][] foldMatrix(int[][] matrix, String direction) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] foldedMatrix;

        if ("horizontal".equals(direction)) {
            foldedMatrix = new int[rows - 1][cols];
            for (int i = 0; i < foldedMatrix.length; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i < rows) {
                        foldedMatrix[i][j] = matrix[i][j] * matrix[i][j];
                    } else {
                        foldedMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        } else if ("vertical".equals(direction)) {
            foldedMatrix = new int[rows][cols - 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < foldedMatrix[i].length; j++) {
                    if (j < cols) {
                        foldedMatrix[i][j] = matrix[i][j] * matrix[i][j];
                    } else {
                        foldedMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Ungültige Richtung. Bitte wählen Sie 'horizontal' oder 'vertical'.");
        }

        return foldedMatrix;
    }

}
