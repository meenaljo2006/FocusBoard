import java.util.*;

public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum_Even = 0;
        int sum_odd = 0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                sum_Even=sum_Even+n;
            }
            else{
                sum_odd=sum_odd+n;
            }

        }

        System.out.println(sum_Even);
        System.out.println(sum_odd);
        
        sc.close();
    }
        

}
    

