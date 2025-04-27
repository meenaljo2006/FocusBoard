public class P_transpose {

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                            {4,5,6}};
        int trans[][] = new int[matrix[0].length][matrix.length];
        
        for(int i = 0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                
                trans[j][i] = matrix[i][j];
                
            }
        }

        for(int i = 0;i<trans.length;i++){
            for(int j =0;j<trans[0].length;j++){
                System.out.print(trans[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
