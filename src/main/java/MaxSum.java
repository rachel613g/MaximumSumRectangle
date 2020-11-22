
import java.lang.*;

public class MaxSum {

    static class MaximumSumRectangle {

        // Function to find maximum sum rectangular submatrix
        public static int maxSumRectangle(int[][] matrix) {
            int totalRows = matrix.length;
            int totalColumns = matrix[0].length;

            //running column totals
            int preSum[][] = new int[totalRows + 1][totalColumns];

            int maxInt = Integer.MIN_VALUE;
            for (int i = 0; i < totalRows; i++) {
                for (int j = 0; j < totalColumns; j++) {
                    maxInt = (matrix[i][j] > maxInt) ? matrix[i][j] : maxInt;
                    //add running column totals for every point
                    preSum[i + 1][j] = preSum[i][j] + matrix[i][j];
                }
            }
            //return largest int if all ints are negative
            if (maxInt < 0) {
                return maxInt;
            }

            int maxSum = Integer.MIN_VALUE;

            //try every (sub)row-(sub)column combination
            for (int rowStart = 0; rowStart < totalRows; rowStart++) {
                for (int row = rowStart; row < totalRows; row++) {

                    //track sum for this iteration
                            int sum = 0;

                            //Use column running sums to determine rect sum
                            for (int col = 0; col < totalColumns; col++) {
                                //subtract values no longer in the rectangle
                                sum += preSum[row + 1][col] - preSum[rowStart][col];
                                // if the sum is negative, reset it because it to zero
                                // because you can consider the rect just the subsequent lines
                                if (sum < 0) {
                                    sum = 0;
                        } else if (maxSum < sum) {
                            maxSum = sum;
                        }
                    }
                }
            }
            return maxSum;
        }
    }
}
