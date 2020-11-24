
import java.lang.*;

public class MaxSum {

    /*
    This code is heavily inspired by
    https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/.
     */

    // Function to find maximum sum rectangular submatrix
    public int maxSumRectangle(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        //running column totals
        int preSum[][] = new int[totalRows + 1][totalColumns];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                max = (matrix[i][j] > max) ? matrix[i][j] : max;
                //add running column totals for every point
                preSum[i + 1][j] = preSum[i][j] + matrix[i][j];

            }
        }
        //return largest int if all ints are negative
        if (max < 0) {
            return max;
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
