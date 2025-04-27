public class Inheritance {

    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
        

        
    }
    
}

// Base Class
class Animals{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}

//Derived Class
class Fish extends Animals{
    int fins;
    void swim(){
        System.out.println("swims");
    }
}

class Mammal extends Animals{
    int legs;
}

class Dog extends Mammal {
    String breed;
    String sound;

}
