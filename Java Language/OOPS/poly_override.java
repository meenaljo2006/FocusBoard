public class poly_override {

    public static void main(String[] args) {

        Deer d= new Deer();
        d.eat();
        
    }

}

class Animal{
    void eat(){
        System.out.println("Eat ANything");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("Eat Grass");
    }
}
