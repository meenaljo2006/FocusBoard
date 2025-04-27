public class prime {

    public static void isPrime(int start,int end){

        for( int num=start;num<=end;num++){

            boolean status = true;
            for(int i =2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    status = false;
                }  
            }

            if(status==true){
                System.out.print(num +" ");
            }

        }
        
    }

    public static void main(String[] args) {
       isPrime(2,100);
        
        
        

        

    }
    
}
