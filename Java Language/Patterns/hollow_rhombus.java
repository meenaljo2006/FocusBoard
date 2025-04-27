public class hollow_rhombus {
    public static void main(String[] args) {
        int rows=5;
        int columns=5;
        for(int i =1;i<=rows;i++){
            for(int spaces = rows-i;spaces>0;spaces--){
                System.out.print("  ");
            }
            for(int j=1;j<=columns;j++){
                if(i==1||i==rows || j==1||j==columns){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
    
}
