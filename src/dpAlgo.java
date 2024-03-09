public class dpAlgo {
    public static int binomial(int x, int y) {
        int[][] B = new int[x + 1][y + 1];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (j == 0 || j == i) {
                    B[i][j] = 1;
                } else if (i > 0) {
                    B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
                }
            }
        }
        return B[x][y];
    }
}