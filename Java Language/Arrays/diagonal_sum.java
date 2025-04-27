public class diagonal_sum{

    public static void sum(int arr[][]){

        if(arr.length==arr[0].length){
            int sum =0;

            // for(int i =0;i<arr.length;i++){
            //     for(int j =0;j<arr[0].length;j++){
            //         if(i==j){
            //             sum = sum+arr[i][j];
            //         }
            //         else if(i+j==arr.length-1){
            //             sum=sum+arr[i][j];
            //         }
            //     }
            // }

            for(int i =0;i<arr.length;i++){
                sum = sum+arr[i][i];      // primary diagonal
                if(i!=arr.length-1-i){
                    sum = sum+arr[i][arr.length-1-i];    // secondary diagonal
                }
            }

            System.out.println("Sum of the diagonal elts = "+ sum);
        }
        else{
            System.out.println("Diagonal sum can't be found.");
        }

    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

        sum(arr);
    }
}