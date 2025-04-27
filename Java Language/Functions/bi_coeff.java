public class bi_coeff {

    public static int fact(int num){

        int fact =1;
        for(int i=num;i>=1;i--){
            fact=fact*i;
        }
        return fact;

    }

    public static int binomial_coefficient(int n,int r){

        int bin_coeff = (fact(n))/ (fact(r)*fact(n-r));
        return bin_coeff;

    }

    public static void main(String[] args) {
        
        System.out.println(binomial_coefficient(5, 2));
    }
    
}
