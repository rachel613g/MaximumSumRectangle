
import java.lang.*;

public class MaxSum {

    // Function to find maximum sum rectangular submatrix
    public int maxSumRectangle(int[][] mat) {
        int totalRows = mat.length;
        int totalColumns = mat[0].length;

        //running column totals
        int preSum[][] = new int[totalRows + 1][totalColumns];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < totalRows; i++) { //perhaps change to just start with second
            for (int j = 0; j < totalColumns; j++) {
                max = (mat[i][j] > max) ? mat[i][j] : max;
                //add running column totals for every point
                preSum[i + 1][j] = preSum[i][j] + mat[i][j];
            }
        }
        //return largest int if all ints are negative
        if (max < 0) {
            return max;
        }

        int maxSum = Integer.MIN_VALUE; //changed from -1

        //try every (sub)row-(sub)column combination
        for (int rowStart = 0; rowStart < totalRows; rowStart++) {
            for (int row = rowStart; row < totalRows; row++) {

                //tracks sum for this iteration
                int sum = 0;

                //Use column running sums to determine rect sum
                for (int col = 0; col < totalColumns; col++) {
                    //subtract values no longer in the rectangle
                    sum += preSum[row + 1][col] - preSum[rowStart][col];
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
