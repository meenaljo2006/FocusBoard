public class P_selection {
    public static void main(String[] args) {

        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        for(int i =0; i<arr.length-1;i++){
            int max_pos = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[max_pos]<arr[j]){
                    max_pos = j;
                }
            }

            int temp = arr[max_pos];
            arr[max_pos] = arr[i];
            arr[i] = temp ; 
        }

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
    
}
