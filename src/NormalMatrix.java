import java.util.Arrays;
import java.util.Random;

public class NormalMatrix {
    public static void main(String[] args) {
        int n = 5;  // Größe der Matrix
        int[][] matrixA = generateRandomMatrix(3, n);
        int[][] matrixB = generateRandomMatrix(3, n);

        // Matrix ausgeben
        System.out.println("Ursprüngliche Matrix A:");
        printMatrix(matrixA);

        // Matrix rotieren
        matrixA = rotate90Degrees(matrixA);
        matrixB = rotate90Degrees(matrixB);

        // Rotierte Matrix ausgeben
        System.out.println("\nRotierte Matrix A:");
        printMatrix(matrixA);

        // Summe
        int sum = sumDiagonal(matrixA);
        System.out.println("\nSumme der Diagonalelemente von A: " + sum);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        // Hadamard Produkt
        int[][] hadamardMatrix = hadamardProduct(matrixA, matrixB);
        System.out.println("\nHadamard A & B:");
        printMatrix(hadamardMatrix);

        // Sortieren
        sortMatrix(hadamardMatrix);
        System.out.println("\nsortierte Hadamard A & B:");
        printMatrix(hadamardMatrix);

        // Faltung
        matrixA = foldMatrix(matrixA, "horizontal");
        System.out.println("\nHorizontal gefaltete Matrix A:");
        printMatrix(matrixA);

        matrixB = foldMatrix(matrixB, "vertical");
        System.out.println("\nVertikal gefaltete Matrix B:");
        printMatrix(matrixB);
    }

    public static boolean isSquareMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return false;  // Eine Matrix ohne Zeilen kann nicht als quadratisch betrachtet werden.
        }

        return matrix.length == matrix[0].length;
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

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.println();
        }
    }


    public static int[][] rotate90Degrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Erzeuge eine neue Matrix für das Ergebnis
        int[][] rotatedMatrix = new int[m][n];

        // Transponieren der Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }


    public static int sumDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int sum = 0;
        if (rows == 0 || rows != matrix[0].length) {
            //throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");
            System.out.println("\nDie Matrix ist nicht quadratisch -> es gibt keine Diagonale");
        } else {

            for (int i = 0; i < rows; i++) {
                sum += matrix[i][i];
            }

        }
        return sum;
    }


    public static int[][] hadamardProduct(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        // Überprüfen, ob die Matrizen die gleiche Größe haben
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

        // Konvertiere die Matrix in ein eindimensionales Array
        int[] arr = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        // Sortiere das Array
        Arrays.sort(arr);

        // Schreibe die sortierten Werte zurück in die Matrix
        index = 0;
        for (int i = 0; i < rows; i++) {
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
            foldedMatrix = new int[rows % 2 == 0 ? rows / 2 : rows / 2 + 1][cols];
            for (int i = 0; i < foldedMatrix.length; i++) {
                for (int j = 0; j < cols; j++) {
                    if (2 * i + 1 < rows) {  // Prüfen, ob es ein Pendant am unteren Rand gibt
                        foldedMatrix[i][j] = matrix[i][j] * matrix[rows - 1 - i][j];
                    } else {
                        foldedMatrix[i][j] = matrix[i][j];
                    }
                }
            }
        } else if ("vertical".equals(direction)) {
            foldedMatrix = new int[rows][cols % 2 == 0 ? cols / 2 : cols / 2 + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < foldedMatrix[i].length; j++) {
                    if (2 * j + 1 < cols) {  // Prüfen, ob es ein Pendant am rechten Rand gibt
                        foldedMatrix[i][j] = matrix[i][j] * matrix[i][cols - 1 - j];
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
