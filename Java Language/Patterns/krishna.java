public class krishna{
    public static void main(String[] args) {
        String msg = "ILOVEYOUKRISHNA";
        int k =0;
        for(int i=0;i<msg.length();i++){
            for(int j=0;j<=i;j++){
                System.out.print(msg.charAt(k));
                k=k+1;
            }
            System.out.println();

        }

    }
}