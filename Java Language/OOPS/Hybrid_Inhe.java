public class Hybrid_Inhe{
    public static void main(String[] args) {
        
        peacock kuhu = new peacock();
        kuhu.color = "green-blue";
    }
}

class Animals{
    String color;
    void eat(){
        System.out.println("eat");
    }
    void breathe(){
        System.out.println("breathe");
    }

}

class Fish extends Animals{
    int fins;
    void swim(){
        System.out.println("Swim");
    }
}

class Tuna extends Fish{
    void call(){
        System.out.println("I am Tuna");
    }
    
}

class Shark extends Fish{
    void call(){
        System.out.println("I am Fish");
    }
    
}

class Birds extends Animals{
    int fly_rate;
    void fly(){
        System.out.println("Fly");
    }
}

class peacock extends Birds{
    void call(){
        System.out.println("Sweet Voice");
    }
   
}

