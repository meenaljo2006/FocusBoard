public class solid_rhombus {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int space1=1;space1<=n-i;space1++){
                System.out.print("  ");
            }
            for(int times=1;times<=n;times++ ){
                System.out.print("* ");
            }
            
            System.out.println();
        }
    }
    
}
