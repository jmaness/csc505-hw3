import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Naive strategy of matrix multiplication parenthesization.
 *
 * This runs in Theta(n) where n is the number of dimensions in the chain of matrices.
 *
 */
class naive {

    /**
     * Actual implementation of the naive strategy.
     *
     * @param n number of matrices
     * @param p list of dimensions
     * @return total number of multiplications with a naive parenthesization
     */
    private static long naiveMCM(int n, long[] p) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += p[0] * p[i] * p[i + 1];
        }
        return sum;
    }

    /**
    * Main function, called when the user runs the program.
    * Reads the given file and store the number of matrices
    * and the dimensions that will be needed for the 
    * multiplication.
    * Prints out the result once the execution is done.
    */
    public static void main(String[] args) {
        int numMatrices = 0;
        List<Long> dimensions = new ArrayList<>();
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
        long result = naiveMCM(numMatrices,
                dimensions.stream()
                        .mapToLong(Long::longValue)
                        .toArray());

        // Write result to stdout
        System.out.println(result);
    }
}
