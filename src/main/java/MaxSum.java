
import java.lang.*;

public class MaxSum {

    //Java Program to find max sum rectangular submatrix
    static class MaximumSumRectangle {

        // Function to find maximum sum rectangular submatrix
        public static int maxSumRectangle(int[][] mat) {
            int totalRows = mat.length;
            int totalColumns = mat[0].length;

            //running column totals
            int preSum[][] = new int[totalRows + 1][totalColumns];

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < totalRows; i++) { //perhaps change to just start with second
                for (int j = 0; j < totalColumns; j++) {
                    max = mat[i][j] > max ? mat[i][j] : max;
                    //add running column totals for every point
                    preSum[i + 1][j] = preSum[i][j] + mat[i][j];

                }

            }
            if (max < 0) {
                return max;
            }
            
            int maxSum = Integer.MIN_VALUE; //changed from -1
            int minSum = Integer.MIN_VALUE;// what is this?!

            //try every (sub)row-(sub)column combination
            for (int rowStart = 0; rowStart < totalRows; rowStart++) {
                for (int row = rowStart; row < totalRows; row++) {
                    int sum = 0;
                    for (int col = 0; col < totalColumns; col++) {
                        //subtract values no longer in the rectangle
                        sum += preSum[row + 1][col] - preSum[rowStart][col];
                        if (sum < 0) {
                            if (minSum < sum) {
                                minSum = sum;
                            }
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
