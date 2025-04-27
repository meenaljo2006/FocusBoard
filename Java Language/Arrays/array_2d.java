import java.util.*;
public class array_2d {

    public static boolean search(int matrix[][],int key){

        for(int i = 0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == key){
                    System.out.println("Found at index ("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Not found");
        return false;
    }

    public static void main(String[] args) {
        
        int matrix[][] = new int [3][4];
        int n = matrix.length;
        int m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print("Enter the key to find in the matrix = ");
        int key = sc.nextInt();

        System.out.print("Key present ? ");
        System.out.print (search(matrix,key));

        sc.close();

    }

    
    
}
