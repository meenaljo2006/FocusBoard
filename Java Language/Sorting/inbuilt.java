
import java.util.*;
public class inbuilt {

    public static void printArr(Integer arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer arr[] = {5,4,1,3,2};
        //Arrays.sort(arr);
        //printArr(arr);
        Arrays.sort(arr, 0, 3);
        printArr(arr);
        Arrays.sort(arr, Collections.reverseOrder());
        printArr(arr);

    }
    
}
