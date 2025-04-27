public class diamond {
    public static void main(String[] args) {
        int n = 4;
        for(int i=1;i<=n;i++){
            for(int spaces1= 0;spaces1<n-i;spaces1++){
                System.out.print("  ");
            }
            for(int times=0;times<=2*(i-1);times++){
                System.out.print("* ");
            }

            System.out.println();
        }

        for(int i=1;i<=n-1;i++){
            for(int spaces1= 0;spaces1<i;spaces1++){
                System.out.print("  ");
            }
            for(int times=0;times<(n-(2*i)+3);times++){
                System.out.print("* ");
            }

            System.out.println();
        }

        
    }
    
}
