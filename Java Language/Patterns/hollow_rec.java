public class hollow_rec{
    public static void main(String[] args) {
        int totrows = 7;
        int totcol = 10;

        for(int i= 1;i<=totrows;i++){
            for(int j =1;j<=totcol;j++){
                if(i==1 || i== totrows || j==1 || j==totcol){
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