
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(new File(args[0]));

            int dimension = scanner.nextInt();

            int[][] matrix = new int[dimension][dimension];
            while (scanner.hasNextInt()) {

                for (int i = 0; i < dimension; i++) {
                    for (int j = 0; j < dimension; j++) {

                        matrix[i][j] = scanner.nextInt();

                    }
                }
            }
            // Function call
            System.out.println(MaxSum.MaximumSumRectangle.maxSumRectangle(matrix));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


