public class Main {

    public static void main(String[] args) {

        int arr[][] = new int[][]{
                {-1, -2, -1, -4, -20},
                {-8, -3, -4, -2, -1},
                {-3, -8, -10, -1, -3},
                {-4, -1, -1, -7, -6}};

        // Function call
        System.out.println(MaxSum.MaximumSumRectangle.maxSumRectangle(arr));
    }
}

