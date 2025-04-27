public class floyd_triangle {
    public static void main(String[] args) {
        int rows = 5;
        int count = 1;
        for(int line=1;line<=rows;line++){
            for(int times = 1;times<=line;times++){
                System.out.print(count +" ");
                count++;
            }
            for(int space = rows-1;space>0;space--){
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
}
