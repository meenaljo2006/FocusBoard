public class counting {

    public static void CountingSort(int arr[]){

        // max no. find
        int max= Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            max= Math.max(max, arr[i]);
        }

        // make count array
        int count[] = new int[max+1];
        for(int i =0;i<arr.length;i++){
            count[arr[i]] = count[arr[i]]+1;
        }

        // update count array and sort it
        int j =0;
        for(int i =0;i<count.length;i++){
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        
        // print sorted array
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,4,1,3,2,4,3,7,0,6,2};
        CountingSort(arr);
    }
    
}
