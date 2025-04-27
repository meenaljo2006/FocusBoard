public class spiral {

    public static void matrix_spiral(int arr[][]){
        int start_row=0;
        int start_Col = 0;
        int end_row = arr.length-1;
        int end_col = arr[0].length-1;

        while(start_row<=end_row && start_Col<=end_col){

            // top boundary
            for(int i =start_Col;i<=end_col;i++){
                System.out.print(arr[start_row][i] +" ");
            }

            //Right Boundary
            for(int j = start_row+1;j<=end_row;j++){
                System.out.print(arr[j][end_col] +" ");
            }

            //Bottom Boundary
            for(int i =end_col-1;i>=start_Col;i--){
                if(start_row==end_row){
                    break;
                }
                System.out.print(arr[end_row][i] +" ");
            }

            //Left Boundary
            for(int j = end_row-1;j>start_row;j--){
                if(start_Col==end_col){
                    break;
                }
                System.out.print(arr[j][start_Col] +" ");
            }

            start_Col++;
            start_row++;
            end_col--;
            end_row--;
        }
    }

    public static void main(String[] args) {
        
        int arr[][] = {{1,2,3,4,34},
                        {5,6,7,6,45},
                        {9,10,11,89,90}};


        matrix_spiral(arr);

    }
    
}
