public class kadane {

    public static void sub(int num[]){
        int sum =0;
        int max = Integer.MIN_VALUE;
        
        
        for(int i=0;i<num.length;i++){
            sum = sum+num[i];
            if(sum<0){
                sum =0;
            }
            
            max= Math.max(max, sum);
            // if(sum>max){
            //     max = sum;
            // }
        }
        
        if(sum==0){
            for(int i =0;i<num.length;i++){
                if(num[i]<0){
                    max = Math.max(max,num[i]);
                }
            }
            System.out.println(max);
        }
        else{
            System.out.println(max);
        }

    }

    public static void main(String[] args) {
        int num[] = {-2,-3,-4,-1,-2,-1,-5,-4};
        sub(num);

    }
    
}
