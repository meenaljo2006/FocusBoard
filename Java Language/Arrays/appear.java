import java.util.*;
public class appear {

    public static boolean times_Appear(int num[]){
        int times =0;
        for(int i=0;i<num.length;i++){
            for(int j =i+1;j<num.length;j++){
                if(num[i]==num[j]){
                    times++;
                }

            }
        }

        if(times>=2){
            return true;
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array = ");
        int arraySize = sc.nextInt();
        int num[] = new int[arraySize];
        // Input elements to arrays
        for(int i = 0;i<arraySize;i++){
            num[i] = sc.nextInt();
        }
        // print array
        for(int i = 0;i<arraySize;i++){
            System.out.print(num[i] +" ");
        }

        System.out.println();

        System.out.println(times_Appear(num));

        sc.close();
    }
    
}
