public class BrutSum_sub {
    
    public static void sub(int num[]){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<num.length;i++){
            int start=i;
            for(int j =i;j<num.length;j++){
                int end = j;
                int sum = 0;
                for(int k = start;k<=end;k++){
                    System.out.print(num[k]+ " ");
                    sum = sum + num[k];
                }
                
                System.out.println("Sum = " +sum);
                if(sum>max){
                    max = sum;
                }
                if(sum<min){
                    min = sum;
                }
            }
        }
        System.out.println();
        System.out.println("Maximum Sum Value = " +max);
        System.out.println("Minimum Sum Value = " +min);
    }

    public static void main(String[] args) {
        int num[] = {1,-2,6,-1,3};
        sub(num);

    }

}
