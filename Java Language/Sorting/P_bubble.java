public class P_bubble {
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        for(int i = 1;i<arr.length;i++){
            for(int j = 0;j<arr.length-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
