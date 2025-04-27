public class compare{

    public static void main(String[] args) {
        
        String str1 = "Tony";
        String str2 = "Tony";
        String str3 = new String("Tony");

        System.out.println(str1==str2);
        System.out.println(str1==str3); // interning


        System.out.println(str1.equals(str3));
    }

}