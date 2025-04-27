public class PrefixSum_sub {

    public static void sub(int num[]){

        int max = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];
        prefix[0] = num[0];
        for(int i = 1; i<prefix.length;i++){
            prefix[i] = prefix[i-1]+num[i];
        }
        for(int i=0;i<num.length;i++){
            int start = i;
            for(int j = i;j<num.length;j++){
                int end = j;
                int sum = (start==0)?prefix[end]:prefix[end]-prefix[start-1];
                if(sum>max){
                    max = sum;
                }
            }
        }
        System.out.println(max);

    }

    public static void main(String[] args) {
        int num[] = {1,-2,6,-1,3};
        sub(num);
    }
    
}
