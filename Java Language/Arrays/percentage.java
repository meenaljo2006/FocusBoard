import java.util.*;
public class percentage{
    public static void main(String[] args) {
        int marks[] = new int[3];
        Scanner sc = new Scanner(System.in);

        // input elements to array
        for(int i =0;i<3;i++){
            System.out.print("marks ["+i+"] = ");
            marks[i] = sc.nextInt();
        }

        // printing elements of array
        System.out.print("ELements = ");
        for(int i =0;i<3;i++){
            System.out.print(marks[i] +" ");
        }
        
        System.out.println();
        System.out.println("Length of array = "+marks.length);
        

        int sum =0;
        for(int i =0;i<3;i++){
            sum = sum+marks[i];
        }
        System.out.println(sum);
        int per = (int)((sum/300.0)*100.0);
        System.out.println("percentage = "+per+" %");

        sc.close();

    }

}