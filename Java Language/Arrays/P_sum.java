public class P_sum {

    public static void main(String[] args) {
        int nums[][] = {{1,4,9},
                        {11,4,3},
                        {2,2,3}};
        int sum =0;
        int row =2;
        for(int j =0;j<nums[0].length;j++){
            sum = sum+nums[row-1][j];
        }

        System.out.println(sum);
        

    }
    
}
