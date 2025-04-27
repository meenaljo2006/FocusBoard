public class sub {

    public static void main(String[] args) {
        String str = "HelloWorld";
        
        //Inbuilt Function
        System.out.println(str.substring(0,5));

        //Manually
        String substr = "";
        int si= 0;
        int ei = 5;
        for(int i =si;i<ei;i++){
            substr+=str.charAt(i);
        }

        System.out.println(substr);
        

    }
    
}
