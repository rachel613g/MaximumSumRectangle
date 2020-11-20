
import java.lang.*;

public class MaxSum {

    //Java Program to find max sum rectangular submatrix
    static class MaximumSumRectangle {

        // Function to find maximum sum rectangular
        // submatrix
        public static int maxSumRectangle(int[][] mat) {
            int totalRows = mat.length;
            int totalColumns = mat[0].length;

            //running column totals
            int preSum[][] = new int[totalRows + 1][totalColumns];
            boolean allNegative = true;
            for (int i = 0; i < totalRows; i++) { //perhaps change to just start with second
                for (int j = 0; j < totalColumns; j++) {
                        if(mat[i][j]>0){
                            allNegative = false;
                        }
                    //add running column totals for every point
                    preSum[i + 1][j] = preSum[i][j] + mat[i][j];
                    System.out.print(preSum[i + 1][j] + "    ");
                }
                System.out.println("\n");
            }

            int maxSum = Integer.MIN_VALUE; //changed from -1
            int minSum = Integer.MIN_VALUE;// what is this?!
            int firstRow = 0, lastRow = 0, firstColumn = 0, lastColumn = 0;


            //try every (sub)row-(sub)column combination
            for (int rowStart = 0; rowStart < totalRows; rowStart++) {
                for (int row = rowStart; row < totalRows; row++) {
                    int sum = 0;
                    int curColStart = 0;
                    for (int col = 0; col < totalColumns; col++) {
                        //subtract values no longer in the rectangle
                        sum += preSum[row + 1][col] - preSum[rowStart][col];
                        if (sum < 0) {
                            if (minSum < sum) {
                                minSum = sum;
                            }
                            sum = 0;
                            curColStart = col + 1;
                        } else if (maxSum < sum) {
                            maxSum = sum;
                            firstRow = rowStart;
                            lastRow = row;
                            firstColumn = curColStart;
                            lastColumn = col;
                        }
                    }
                }
            }


                System.out.println("from row : " + firstRow
                        + " to row : " + lastRow);
                System.out.println("from col : " + firstColumn
                        + " to col : " + lastColumn);

            return maxSum;
        }
    }
}
