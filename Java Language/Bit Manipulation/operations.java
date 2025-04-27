public class operations {

    public static int getIth_Bit(int num,int i){
        int bitmask = 1<<i;
        if((num & bitmask) == 0){
            return 0;
        }
        else{
            return 1;
        }

    }

    public static int setIth_Bit(int num,int i){

        int bitmask = 1<<i;
        return num|bitmask;

    }

    public static int clearIth_Bit(int num,int i){

        int bitmask = ~(1<<i);
        return(num&bitmask);

    }

    public static int updateIth_Bit(int num, int i,int update){
        
        // if(update==0){
        //     return clearIth_Bit(num, i);
        // }
        // else{
        //     return setIth_Bit(num, i);
        // }

        num = clearIth_Bit(num, i);
        int bitmask = update<<i;
        return num|bitmask;
    }

    public static void main(String[] args) {

        System.out.println(getIth_Bit(10, 3));
        System.out.println(setIth_Bit(10, 2));
        System.out.println(clearIth_Bit(10, 2));
        System.out.println(updateIth_Bit(10, 1, 1));
        
    }
    
}
