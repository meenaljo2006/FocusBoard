public class inverted_star{
    public static void main(String[] args) {
        for(int line =1;line<=4;line++){
            for(int times=4;times>=line;times--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}