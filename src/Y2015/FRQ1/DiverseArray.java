package Y2015.FRQ1;

public class DiverseArray {
    /**
     * Part (a)
     * Returns the sum of the entries in the one-dimensional array arr.
     */
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int toSum : arr) {
            sum += toSum;
        }
        return sum;
    }

    /**
     * Part (b)
     * Returns a one-dimensional array in which the entry at index k is the sum of
     * the entries of row k of the two-dimensional array arr2D
     */
    public static int[] rowSums(int[][] arr2D) {
        int[] sums = new int[arr2D.length];

        for (int i = 0; i < sums.length; i++) {
            int[] row = arr2D[i];
            int rowSum = DiverseArray.arraySum(row);
            sums[i] = rowSum;
        }

        return sums;
    }

    /**
     * Part (c)
     * Returns true if all rows in arr2D have different row sums;
     * false otherwise.
     */
    public static boolean isDiverse(int[][] arr2D) {
        int[] rowSums = DiverseArray.rowSums(arr2D);

        for (int i = 0; i < rowSums.length - 1; i++) {
            for (int k = i + 1; k < rowSums.length; k++) {
                if (rowSums[k] == rowSums[i]) return false;
            }
        }

        return true;
    }

    /**
     * Used for testing
     */
    public static void main(String[] args) throws Exception {
        int arrSum = DiverseArray.arraySum(new int[]{1, 3, 2, 7, 3});
        if (arrSum != 16) {
            throw new Exception("Method arraySum does not work! Expected: 16, Actual: " + arrSum);
        }

        int[][] arr2D = {
                {1, 3, 2, 7, 3},
                {10, 10, 4, 6, 2},
                {5, 3, 5, 9, 6},
                {7, 6, 4, 2, 1}
        };

        int[] rowSums = DiverseArray.rowSums(arr2D);
        int[] expectedSums = {16, 32, 28, 20};

        for (int i = 0; i < rowSums.length; i++) {
            int rowSum = rowSums[i];
            int expected = expectedSums[i];

            if (rowSum != expected) {
                throw new Exception("Method rowSums does not work! Expected: " + expected + ", Actual: " + rowSum + " (Index: " + i + ")" );
            }
        }

        int[][] secondArr2D = {
                {1, 1, 5, 3, 4},
                {12, 7, 6, 1, 9},
                {8, 11, 10, 2, 5},
                {3, 2, 3, 0, 6}
        };

        boolean diverseFirst = DiverseArray.isDiverse(arr2D);
        if(!diverseFirst) {
            throw new Exception("Method isDiverse does not work! Expected: true, Actual: false");
        }

        boolean diverseSecond = DiverseArray.isDiverse(secondArr2D);
        if(diverseSecond) {
            throw new Exception("Method isDiverse does not work! Expected: false, Actual: true");
        }
    }
}
