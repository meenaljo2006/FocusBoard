public class count_set {

    public static void main(String[] args) {
        
        int num = 10;
        int count =0;
        int bitmask = 1;
        // for(int i =1;num>0;i++){
            
        //     if((num&bitmask)==1){
        //         count++;
        //     }

        //     num = num>>i;
            
        // }

        while(num>0){
            if((num&bitmask)!=0){
                count++;
            }
            num=num>>1;
        }
        System.out.println(count);
    }
    
}
