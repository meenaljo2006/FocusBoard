import java.util.*;
public class large_small {

    public static int largest(int matrix[][]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]>largest){
                    largest = matrix[i][j];
                }
                
            }
        }

        return largest;
    }

    public static int smallest(int matrix[][]){
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]<smallest){
                    smallest = matrix[i][j];
                }
                
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        
        int matrix[][] = new int[4][3];
        int n = matrix.length;
        int m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of matrix  = ");
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Print the Matrix = ");
        for(int i =0;i<n;i++){
            for(int j =0 ;j<m;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }

        System.out.println("Largest no. in the matrix = " + largest(matrix));
        System.out.println("Smallest no. in the matrix = " + smallest(matrix));

        sc.close();

    }
    
}
