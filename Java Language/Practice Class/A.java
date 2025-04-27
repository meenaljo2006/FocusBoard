public class A {
    public static void main(String[] args) {

        int rows = 7;
        int columns = 13;
        for(int i=1;i<=rows;i++){
            // for(int spaces =rows-i;spaces>0;spaces--){
            //     System.out.print("  ");
            // }
            for(int j =1;j<=columns;j++){
                if(i+j==rows+1 || ((i==(rows/2)+1) && (j>=rows/2+1) && j <= columns - (rows / 2)) || (j-i==rows-1)){
                    System.out.print("A ");
                }
                else
                System.out.print("  ");

            }
            System.out.println();
        }
    }

}
