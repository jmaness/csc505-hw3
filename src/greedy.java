import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Greedy strategy of matrix multiplication parenthesization.
 *
 * This runs in Theta(n log n) where n is the number of dimensions in the chain of matrices.
 *
 */
class greedy {

    /**
     * Actual implementation of the greedy strategy.
     *
     * @param p list of dimensions
     * @return total number of multiplications with a greedy parenthesization
     */
    private static long greedyMCM(List<Long> p) {
        if (p.size() <= 2) {
            return 0;
        } else if (p.size() == 3) {
            return product(p);
        } else {
            /*
             * Find minimum k that minimizes the cost of multiplying the
             * result of M1 ·M2 ·. . . Mk times the result of
             * Mk+1 ·Mk+2 ·. . . Mn. This is essentially just the minimum
             * dimension excluding the first and last dimensions.
             */
            int k = 1;
            for (int j = 1; j < p.size() - 1; j++) {
                if (p.get(j) < p.get(k)) {
                    k = j;
                }
            }

            long left = greedyMCM(p.subList(0, k + 1));
            long right = greedyMCM(p.subList(k, p.size()));
            return left + right + p.get(0) * p.get(k) * p.get(p.size() - 1);
        }
    }

    private static long product(List<Long> vals) {
        long product = 1;
        for (int i = 0; i < vals.size(); i++) {
            product *= vals.get(i);
        }
        return product;
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
        long result = greedyMCM(dimensions);

        // Write result to stdout
        System.out.println(result);
    }
}