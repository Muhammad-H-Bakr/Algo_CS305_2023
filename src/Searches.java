import java.util.Arrays;

public class Searches {
    public static void main(String[] args){
        SearchesGUI test = new SearchesGUI();
        test.setVisible(true);
    }
    public static int binSearch(int[] arr, int val) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int linSearch(int[] arr, int val){
        for(int i = 0; i<arr.length;i++){
            if(arr[i]==val){
                return i;
            }
        }
        return -1;
    }
    public static void fillArray(int[] arr){
          for(int i =0;i<arr.length;i++){
              arr[i] = (int) (Math.random()*10);
          }
          Arrays.sort(arr);
      }
}
