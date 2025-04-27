public class bubble{

    public static void bubbleSort(int arr[]){

        for(int turn =0;turn<arr.length-1;turn++){
            for(int swap = 0;swap<arr.length-1-turn;swap++){
                int temp = arr[swap];
                arr[swap] = arr[swap+1];
                arr[swap+1] = temp;
            }
        }

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        bubbleSort(arr);
    }

}