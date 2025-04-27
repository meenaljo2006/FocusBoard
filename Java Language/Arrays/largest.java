
public class largest {

    public static int getLargest(int num[]){
        
        int largest = Integer.MIN_VALUE;
        for(int i =0;i<num.length;i++){
            if(largest<num[i]){
                largest = num[i];
            }
        }
        return largest;
    }
    public static int getSmallest(int num[]){
        
        int smallest = Integer.MAX_VALUE;
        for(int i =0;i<num.length;i++){
            if(smallest>num[i]){
                smallest = num[i];
            }
        }
        return smallest;
    }
    public static void main(String[] args) {
         int num[] = {23,45,12,100,45,150};
         System.out.println(getLargest(num));
         System.out.println(getSmallest(num));
         
    }
    
}
