public class largest {

    public static void main(String[] args) {
        
        String fruits[] = {"Apple","apricot","Mango","Banana"};
        String largest = fruits[0];

        for(int i =1;i<fruits.length;i++){
            if(fruits[i].compareToIgnoreCase(largest)>0){
                largest = fruits[i];
            }

        }
        
        System.out.println(largest);

        // comparetoignorecase --- largest = mango
        // compareto case --- larges = apricot  ASCII a = 97  A = 65




    }
    
}
