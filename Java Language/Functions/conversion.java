public class conversion {

    public static int binTOdec(int num){
        int dec =0;
        for(int pow =0;num>0;pow++){
            int last_digit=num%10;
            dec = (int) (dec+ last_digit* Math.pow(2,pow));
            num=num/10;
        }

        return dec;
    }

    public static int decTObin(int num){
        int bin =0;
        int pow =0;
        while(num>0){
            
            bin = (int) (bin +( (num%2)* Math.pow(10, pow) ));
            num=num/2;
            pow++;
        }

        return bin;
    }

    public static void main(String[] args) {
        System.out.println(binTOdec(101));
        System.out.println(decTObin(6));
        
    }
    
}
