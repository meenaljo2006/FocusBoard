public class P_counting {

    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        
        // Finding max. no.  
        int max= Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }

        // Defining count array  
        int count[] = new int[max+1];
        for(int i =0;i<arr.length;i++){
            count[arr[i]]++;
        }

        // update count array and sort the initial array
        // int j =arr.length-1;
        // for(int i =0;i<count.length;i++){
        //     while(count[i]>0){
        //         arr[j] = i;
        //         j--;
        //         count[i] --;
        //     }
        // }

        int j =0;
        for(int i =count.length-1;i>=0;i--){
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i] --;
            }
        }
        
        // printing array
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
}
