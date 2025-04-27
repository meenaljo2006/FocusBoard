public class L_search {

    public static int LinearSearch(int num[],int key){
        for(int i=0;i<num.length;i++){
            if(key==num[i]){
                return i;
            }
        }
        
        return -1;
    }


    public static int menu(String menu[],String find){
        for(int i=0;i<menu.length;i++){
            if(find==menu[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // int num[] = {2,3,4,5,6,7};
        // int key = 10;
        String menu[] = {"roti","chole","samose","dal"};
        String find = "samose";

        int index = menu(menu,find);
        if(index==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("The key is at index = "+index);
        }
        
    }
    
}
