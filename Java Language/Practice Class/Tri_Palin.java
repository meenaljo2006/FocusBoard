public class Tri_Palin {

    public static void main(String[] args) {
        
        int n=4;
        for(int i =1;i<=n;i++){
            for(int spaces =n-i;spaces>0;spaces--){
                System.out.print("  ");
            }
            int print =0;
            for(int times =1;times<=2*i-1;times++){
                
                if(times<=((2*i-1)/2)+1){
                    print++;
                }
                else{
                    print--;
                }
                System.out.print(print+ " ");
            }

            System.out.println();
        }

        for(int i =n-1;i>=1;i--){
            for(int spaces =n-i;spaces>0;spaces--){
                System.out.print("  ");
            }

            int print =0;
            for(int times =1;times<=2*i-1;times++){

                if(times<=((2*i-1)/2)+1){
                    print++;
                }
                else{
                    print--;
                }
                System.out.print(print+" ");
            }

            System.out.println();
        }

    }
    
}
