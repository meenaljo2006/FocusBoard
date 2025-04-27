public class builder {

    

    public static void main(String[] args) {
        
        StringBuilder str= new StringBuilder("");
        for( char i ='a';i<='z';i++){

            str.append(i);
        }
        str.toString();
        System.out.println(str);


        Integer a = 10;
        System.out.println(a.toString().getClass());


    }
    
}
