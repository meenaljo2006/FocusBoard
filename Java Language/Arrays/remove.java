public class remove {
    public static int removeElement(int[] nums, int val) {
        int arr[] = new int [nums.length];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                arr[count]=nums[i];
                count++;
            }
        }
        for(int i=0;i<count;i++){
            System.out.print(arr[i] +" ");

        }
        
        System.out.println();
        return count;
    }
    
    public static void main(String[] args) {
        int nums[] ={3,2,2,3};
        int val=3;
        System.out.println();
        System.out.println(removeElement(nums,val));
    }
}
