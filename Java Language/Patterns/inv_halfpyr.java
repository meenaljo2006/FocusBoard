public class inv_halfpyr {
    public static void main(String[] args) {
        int rows = 5;
        
        for(int lines=1;lines<=rows;lines++){
            int count = 1;
            for(int times = rows; times>=lines;times--){
                System.out.print(count +" ");
                count++;
            }
            // we can do this by printing j if for(int times = 1;times<=rows-lines+1;times++)
            for(int space =1;space<lines;space++ ){
                System.out.print("  ");
            }

            System.out.println();
        }
    }
    
}
