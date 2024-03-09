import java.util.Arrays;

public class DCAlgo {
    public static void main(String[] args) {
        DivideConquer dc = new DivideConquer();
        dc.setVisible(true);
    }

    public static void merge(int h, int m, int[] U, int[] V, int[] S) {
        int i = 0, j = 0, k = 0;
        while (i < h && j < m) {
            if (U[i] < V[j]) {
                S[k] = U[i];
                i++;
            } else {
                S[k] = V[j];
                j++;
            }
            k++;
        }
        if (i > h - 1) {
            for (int l = j; l < m; l++) {
                S[k++] = V[l];
            }
        } else {
            for (int l = i; l < h; l++) {
                S[k++] = U[l];
            }
        }
    }

    public static void mergeSort3(int n, int[] S) {
        if (n == 2) {
            if (S[0] > S[1]) {
                int temp = S[0];
                S[0] = S[1];
                S[1] = temp;
            }
        }
        if (n > 2) {
            int h = n / 3;
            int[] U = new int[h];
            int[] V = new int[h];
            int[] W = new int[n - 2 * h];
            int[] UV = new int[2 * h];
            Arrays.setAll(U, l -> S[l]);
            Arrays.setAll(V, l -> S[l + h]);
            Arrays.setAll(W, l -> S[l + 2 * h]);
            mergeSort3(h, U);
            mergeSort3(h, V);
            mergeSort3(n - 2 * h, W);
            merge(h, h, U, V, UV);
            merge(2 * h, n - 2 * h, UV, W, S);
        }
    }

    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
    }
}