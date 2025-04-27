public class water {

    public static void trapWater(int height[],int width){

        int leftMax_Bound[] = new int[height.length];
        // assigning values to array1
        leftMax_Bound[0] = height[0];
        for(int i =1;i<height.length;i++){
            leftMax_Bound[i] = Math.max(leftMax_Bound[i-1],height[i]);
        }
        // printing array1
        for(int i=0;i<leftMax_Bound.length;i++){
            System.out.print(leftMax_Bound[i] +" ");
        }

        System.out.println();

        int rightMax_Bound[] = new int[height.length];
        // assigning values to array2
        rightMax_Bound[height.length-1] = height[height.length-1];
        for(int i =height.length-2;i>=0;i--){
            rightMax_Bound[i] = Math.max(rightMax_Bound[i+1],height[i]);
        }
        // printing array2
        for(int i=0;i<rightMax_Bound.length;i++){
            System.out.print(rightMax_Bound[i] +" ");
        }

        System.out.println();

        // Amount of trapped water
        int T_Water = 0;
        for(int i=0;i<height.length;i++){
            int waterlevel =Math.min(leftMax_Bound[i],rightMax_Bound[i]);
            T_Water = T_Water + ((waterlevel-height[i])*width);
        }
        System.out.print("Water Trapped = ");
        System.out.println(T_Water);
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        int width =1;
        trapWater(height,width);

    }
    
}
