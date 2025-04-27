public class clear_lastI_Bits {

    public static void main(String[] args) {
        int num = 15;
        int i =2;
        int bitmask = (~0)<<i;    // same as -1<<i 
        System.out.println(num&bitmask);
    }
    
}
