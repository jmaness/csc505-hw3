import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class greedy {

    private static final int MIN_NUM_DIMENSIONS = 3;

    /**
     * Actual implementation of the greedy strategy.
     *
     * @param n number of matrices
     * @param p list of dimensions
     * @return total number of multiplications with a greedy parenthesization
     */
    private static long run(int n, List<Long> p) {
        long sum = 0;
        if (n >= MIN_NUM_DIMENSIONS) {

        }

        return sum;
    }

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
        long result = run(numMatrices, dimensions);

        System.out.println(result);
    }
}