public class arg_pass {

    public static void update(int marks[],int n){
        n=10;
        for (int i=0;i<marks.length;i++){
            marks[i] = marks[i]+1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int marks[] = {87,78,65};
        for(int i =0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println();

        update(marks,n);
        System.out.println(n);
        for(int i =0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
        }



    }
    
}
