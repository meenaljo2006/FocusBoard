public class inv_pyramid {
    public static void main(String[] args) {
        int lines = 6;
        for(int i =1;i<=lines;i++){
            for(int sp = lines-i; sp>0;sp--){
                System.out.print("  ");
            }
            for(int times = 1;times<=i;times++){
                System.out.print(" *");
            }

            System.out.println();
        }

    }
    
}
