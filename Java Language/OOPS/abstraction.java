public class abstraction {

    public static void main(String[] args) {
        Horse h = new Horse();
        h.changecolor();
        System.out.println(h.color);
        h.eat();
        h.walk();

        Chicken ch = new Chicken();
        System.out.println(ch.color);
        ch.eat();
        ch.walk();
    }

}

abstract class Animal {

    String color;
    Animal(){
        color = "Peach";
        System.out.println("Animal Constructor called");
    }

    void eat(){
        System.out.println("Animal eats");
    }

    abstract void walk();

}

class Horse extends Animal {

    Horse(){
        System.out.println("Horse constructor called");
    }
    
    void changecolor(){
        color = "Brown";
    } 

    void walk(){
        System.out.println("Walk on 4 legs");
    }
}

class Chicken extends Animal {
    
    void changecolor(){
        color = "Red";
    } 

    void walk(){
        System.out.println("Walk on 2 legs");
    }
}