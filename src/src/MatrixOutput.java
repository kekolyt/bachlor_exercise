package src;

public class MatrixOutput {

    private static int[][] matrixA = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static int[][] matrixB = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static int[][] matrixC = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static int[][] hadamardMatrix = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static void main(String[] args) {
        System.out.println("_______________________AUFGABE 1 - generateRandomMatrix_____________________________");

        int n = 5;
        int m = 3;
        try {
            matrixA = Matrix.generateRandomMatrix(m, n);
            matrixB = Matrix.generateRandomMatrix(m, n);
            matrixC = Matrix.generateRandomMatrix(n, n);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nEs kam bei der Erstellung zu einem Index-Fehler.");
        }

        System.out.println("\nErstellte Matrix A");
        printMatrix(matrixA);
        System.out.println("\nErstellte Matrix B");
        printMatrix(matrixB);
        System.out.println("\nErstellte Matrix C");
        printMatrix(matrixC);

        System.out.println("_______________________AUFGABE 2 - isSquareMatrix______________________________");

        System.out.println("\nUrsprüngliche Matrix C");
        printMatrix(matrixC);

        System.out.println("\nErgebnis: ");

        try {
            if (Matrix.isSquareMatrix(matrixC)) {
                System.out.println("Matrix C ist quadratisch");
            } else {
                System.out.println("Matrix C ist nicht quadratisch");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Input-Fehler");
        }

        System.out.println("_______________________AUFGABE 3 - transpose______________________________");

        System.out.println("\nUrsprüngliche Matrix B");
        printMatrix(matrixB);
        System.out.println("\nTransponierte Matrix B");
        try {
            int[][] transposedMatrixB = Matrix.transpose(matrixB);
            printMatrix(transposedMatrixB);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("_______________________AUFGABE 4 - mirrorMatrix______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);

        int[][] mirroredMatrixA = Matrix.mirrorMatrix(matrixA);
        System.out.println("\nGespiegelte Matrix A");
        printMatrix(mirroredMatrixA);

        System.out.println("_______________________AUFGABE 5 - rotate90Degrees______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);

        int[][] rotatedMatrixA = Matrix.rotate90Degrees(matrixA);
        System.out.println("\nRotierte Matrix A");
        printMatrix(rotatedMatrixA);

        System.out.println("_______________________AUFGABE 6 - sumDiagonal______________________________");

        System.out.println("\nUrsprüngliche Matrix C");
        printMatrix(matrixC);
        System.out.println("\nErgebnis: ");
        try {
            if (Matrix.isSquareMatrix(matrixC)) {
                int sumDiag = Matrix.sumDiagonal(matrixC);
                System.out.println("Summe der Diagonalelemente von C " + sumDiag);
            } else {
                System.out.println("Matrix C ist nicht quadratisch");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("_______________________AUFGABE 7 - adamardProduct______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);
        System.out.println("\nUrsprüngliche Matrix B");
        printMatrix(matrixB);
        System.out.println("\nHadamard A & B");
        try {
            hadamardMatrix = Matrix.hadamardProduct(matrixA, matrixB);
            printMatrix(hadamardMatrix);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("_______________________AUFGABE 8 - sortMatrix______________________________");

        System.out.println("\nUrsprüngliche Hadamard");
        printMatrix(hadamardMatrix);
        System.out.println("\nsortierte Hadamard A & B");
        try {
            Matrix.sortMatrix(hadamardMatrix);
            printMatrix(hadamardMatrix);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("_______________________AUFGABE 9 - foldMatrix______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);
        System.out.println("\nUrsprüngliche Matrix B");
        printMatrix(matrixB);

        try {
            int[][] foldedMatrixA = Matrix.foldMatrix(matrixA, "horizontal");
            System.out.println("\nHorizontal gefaltete Matrix A");
            printMatrix(foldedMatrixA);

            int[][] foldedMatrixB = Matrix.foldMatrix(matrixB, "vertical");
            System.out.println("\nVertikal gefaltete Matrix B");
            printMatrix(foldedMatrixB);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nIndex-Fehler");
        }
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
