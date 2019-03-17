import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Dynamic programming strategy of matrix multiplication parenthesization.
 *
 * This is the implementation based on the pseudocode from page 375 of
 * "Introduction to Algorithms" by Cormen, Thomas H.; Leiserson, Charles E.;
 * Rivest, Ronald L.; Stein, Clifford.
 *
 * This runs in Theta(n^3) where n is the number of dimensions in the chain
 * of matrices.
 */
class dp {

    /**
     * Actual implementation of the dp strategy.
     *
     * @param n number of matrices
     * @param p list of dimensions
     * @return total number of multiplications with a dp parenthesization
     */
    private static long dpMCM(int n, long[] p) {
        long[][] m = new long[n][n];
        for (int i = 1; i <= n; i++) {
            m[i-1][i-1] = 0L;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i-1][j-1] = Long.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    long q = m[i-1][k-1] + m[k][j-1] + p[i-1] * p[k] * p[j];
                    if (q < m[i-1][j-1]) {
                        m[i-1][j-1] = q;
                    }
                }
            }
        }

        // top right hand corner of table which contains optimal number of multiplications
        return m[0][n-1];
    }

    /**
    * Main function, called when the user runs the program.
    * Reads the given file and store the number of matrices
    * and the dimensions that will be needed for the 
    * multiplication
    */
    public static void main(String[] args) {
        //Number of matrices on the input
        int numMatrices = 0;
        //List of dimensions of the matrices in the chain
        List<Long> dimensions = new ArrayList<>();
        //Input Scanner
        Scanner scanner = new Scanner(System.in);

        // The first number in the stream is the number of matrices in the chain
        if (scanner.hasNextInt()) {
            numMatrices = scanner.nextInt();
        }

        // The rest of the numbers in the stream are matrix chain dimensions
        while (scanner.hasNextLong()) {
            dimensions.add(scanner.nextLong());
        }

        // Compute result
        long result = dpMCM(numMatrices,
                dimensions.stream()
                        .mapToLong(Long::longValue)
                        .toArray());

        System.out.println(result);
    }
}
