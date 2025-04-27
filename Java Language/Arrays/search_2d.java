public class search_2d{

    public static boolean Staircase_Search(int arr[][],int key){

        // int row =0;
        // int col = arr[0].length-1;

        // while(row<arr.length && col>=0){
        //     if(arr[row][col] == key){
        //         System.out.println("Key found");
        //         return true;
        //     }
        //     else if (arr[row][col]>key){
        //         col--;
        //     }
        //     else if( arr[row][col]<key){
        //         row++;
        //     }
        // }
        // System.out.println("Key not found");
        // return false;


        int row =arr.length-1;
        int col = 0;

        while(row>=0 && col<arr[0].length){
            if(arr[row][col] == key){
                System.out.println("Key found");
                return true;
            }
            else if (arr[row][col]>key){
                row--;
            }
            else if( arr[row][col]<key){
                col++;
            }
        }
        System.out.println("Key not found");
        return false;


    }

    

    public static void main(String[] args) {
        
        int arr[][] = {{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};

        int key = 33;
        Staircase_Search(arr,key);
        
        
    }
}