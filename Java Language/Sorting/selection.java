public class selection{

    public static void SelectionSort(int arr[]){

        for(int i = 0;i<arr.length-1;i++){
            int min_pos = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[min_pos]>arr[j]){
                    min_pos=j;
                }
            }

            int temp = arr[min_pos];
            arr[min_pos] = arr[i];
            arr[i] = temp;
        }

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]= {5,4,3,1,2};
        SelectionSort(arr);
    }
}