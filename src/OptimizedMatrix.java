import java.util.Arrays;
import java.util.Random;

public class OptimizedMatrix {

    public static void main(String[] args) {
        int n = 5;  // Anzahl der Zeilen
        int m = 3;  // Anzahl der Spalten
        int[][] matrixA = generateRandomMatrix(m, n);
        int[][] matrixB = generateRandomMatrix(m, n);

        // Matrix A ausgeben
        System.out.println("Ursprüngliche Matrix A:");
        printMatrix(matrixA);

        // Matrix A rotieren
        matrixA = rotate90Degrees(matrixA);
        System.out.println("\nRotierte Matrix A:");
        printMatrix(matrixA);

        // Diagonalelemente der Matrix A summieren (nur wenn sie quadratisch ist)
        if (isSquareMatrix(matrixA)) {
            int sum = sumDiagonal(matrixA);
            System.out.println("\nSumme der Diagonalelemente von A: " + sum);
        }

        // Matrix B ausgeben
        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        // Matrix B rotieren
        matrixB = rotate90Degrees(matrixB);
        System.out.println("\nRotierte Matrix B:");
        printMatrix(matrixB);

        // Hadamard Produkt von Matrix A und B berechnen und ausgeben
        int[][] hadamardMatrix = hadamardProduct(matrixA, matrixB);
        System.out.println("\nHadamard A & B:");
        printMatrix(hadamardMatrix);

        // Hadamard Produkt sortieren und ausgeben
        sortMatrix(hadamardMatrix);
        System.out.println("\nsortierte Hadamard A & B:");
        printMatrix(hadamardMatrix);

        // Matrix A horizontal falten und ausgeben
        matrixA = foldMatrix(matrixA, "horizontal");
        System.out.println("\nHorizontal gefaltete Matrix A:");
        printMatrix(matrixA);

        // Matrix B vertikal falten und ausgeben
        matrixB = foldMatrix(matrixB, "vertical");
        System.out.println("\nVertikal gefaltete Matrix B:");
        printMatrix(matrixB);
    }

    /**
     * Überprüft, ob eine gegebene Matrix quadratisch ist.
     *
     * @param matrix Die zu überprüfende Matrix.
     * @return true, wenn die Matrix quadratisch ist, sonst false.
     */
    public static boolean isSquareMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return false;
        }
        return matrix.length == matrix[0].length;
    }

    /**
     * Generiert eine zufällige n x m Matrix.
     *
     * @param n Anzahl der Zeilen.
     * @param m Anzahl der Spalten.
     * @return Die generierte Matrix.
     */
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

    /**
     * Gibt eine gegebene Matrix aus.
     *
     * @param matrix Die auszugebende Matrix.
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Dreht eine gegebene Matrix um 90 Grad im Uhrzeigersinn.
     *
     * @param matrix Die zu drehende Matrix.
     * @return Die gedrehte Matrix.
     */
    public static int[][] rotate90Degrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] rotatedMatrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    /**
     * Summiert die Diagonalelemente einer quadratischen Matrix.
     *
     * @param matrix Die Matrix, deren Diagonalelemente summiert werden sollen.
     * @return Die Summe der Diagonalelemente.
     */
    public static int sumDiagonal(int[][] matrix) {
        if (!isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");
        }

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    /**
     * Berechnet das Hadamard-Produkt von zwei Matrizen.
     *
     * @param matrixA Die erste Matrix.
     * @param matrixB Die zweite Matrix.
     * @return Das Hadamard-Produkt der beiden Matrizen.
     */
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

    /**
     * Sortiert die Elemente einer Matrix.
     *
     * @param matrix Die zu sortierende Matrix.
     */
    public static void sortMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] arr = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);

        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[index++];
            }
        }
    }

    /**
     * Faltet eine Matrix entweder horizontal oder vertikal.
     *
     * @param matrix Die zu faltende Matrix.
     * @param direction Die Richtung der Faltung: "horizontal" oder "vertical".
     * @return Die gefaltete Matrix.
     */
    public static int[][] foldMatrix(int[][] matrix, String direction) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] foldedMatrix;

        if ("horizontal".equals(direction)) {
            foldedMatrix = new int[rows % 2 == 0 ? rows / 2 : rows / 2 + 1][cols];
            for (int i = 0; i < foldedMatrix.length; i++) {
                for (int j = 0; j < cols; j++) {
                    if (2 * i + 1 < rows) {
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
                    if (2 * j + 1 < cols) {
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
