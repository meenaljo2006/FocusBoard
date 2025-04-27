public class super_key {

    public static void main(String[] args) {
        horse h = new horse();
        h.color = "purple";
        System.out.println(h.color);

    }
    
}

class Animal{
    String color;
    Animal(){
        System.out.println("Animal is called");
    }
}

class horse extends Animal{
    horse(){
        super.color="brown";
        System.out.println("horse is called");
    }
}
