public class subarrays {

    public static void sub(int num[]){

        int total_subarrays =0;

        for(int i = 0;i<num.length;i++){
            int start=i;
            for(int j =i;j<num.length;j++){
                int end = j;
                for(int k = start;k<=end;k++){
                    System.out.print(num[k]+" ");

                    total_subarrays++;
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println(total_subarrays);
    }

    public static void main(String[] args) {
        int num[] = {2,4,6,8,10};
        sub(num);

    }
    
}
