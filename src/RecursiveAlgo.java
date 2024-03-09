public class RecursiveAlgo {
    public static void main(String[] args){
        RecurrenceGUI test = new RecurrenceGUI();
        test.setVisible(true);
    }
      public static int T (int n){
        if(n==1||n==0) return n;
        return T(n-1)+2*n-1;
    }
}
