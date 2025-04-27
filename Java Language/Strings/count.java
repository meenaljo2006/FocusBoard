public class count {

    public static void main(String[] args) {
        
        String str = "Hi I am Shradha";  // 9
        int count = 0;
        for(int i=0;i<str.length();i++){
        
            if(Character.isLowerCase(str.charAt(i))== true){
                count++;
            }

        }

        System.out.println(count);

    }
    
}
