package src;

public class MatrixOutput {

    private static int[][] matrixA = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static int[][] matrixB = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static int[][] matrixC = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private static int[][] hadamardMatrix = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        try {
            matrixA = Matrix.generateRandomMatrix(m, n);
            matrixB = Matrix.generateRandomMatrix(m, n);
            matrixC = Matrix.generateRandomMatrix(m, m);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam bei der Erstellung zu einem Index-Fehler.");
        }

        System.out.println("Erstellte Matrix A");
        printMatrix(matrixA);
        System.out.println("\nErstellte Matrix B");
        printMatrix(matrixB);
        System.out.println("\nErstellte Matrix C");
        printMatrix(matrixC);

        System.out.println("\n_______________________AUFGABE 1 - isSquareMatrix______________________________");

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

        System.out.println("\n_______________________AUFGABE 2 - transpose______________________________");

        System.out.println("\nUrsprüngliche Matrix B");
        printMatrix(matrixB);
        System.out.println("\nTransponierte Matrix B");
        try {
            int[][] transposedMatrixB = Matrix.transpose(matrixB);
            printMatrix(transposedMatrixB);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("\n_______________________AUFGABE 3 - mirrorMatrix______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);
        System.out.println("\nGespiegelte Matrix A");

        try {
            int[][] mirroredMatrixA = Matrix.mirrorMatrix(matrixA);
            printMatrix(mirroredMatrixA);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("\n_______________________AUFGABE 4 - rotate90Degrees______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);
        System.out.println("\nRotierte Matrix A");

        try {
            int[][] rotatedMatrixA = Matrix.rotate90Degrees(matrixA);
            printMatrix(rotatedMatrixA);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("\n_______________________AUFGABE 5 - sumDiagonal______________________________");

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

        System.out.println("\n_______________________AUFGABE 6 - hadamardProduct______________________________");

        System.out.println("\nUrsprüngliche Matrix A");
        printMatrix(matrixA);
        System.out.println("\nUrsprüngliche Matrix B");
        printMatrix(matrixB);
        System.out.println("\nHadamard A x B");
        try {
            hadamardMatrix = Matrix.hadamardProduct(matrixA, matrixB);
            printMatrix(hadamardMatrix);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }

        System.out.println("\n_______________________AUFGABE 7 - sortMatrix______________________________");

        System.out.println("\nHadamard aus 6.");
        printMatrix(hadamardMatrix);
        System.out.println("\nsortierte Hadamard");
        try {
            Matrix.sortMatrix(hadamardMatrix);
            printMatrix(hadamardMatrix);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Es kam zu einem Index-Fehler");
        }
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

}

