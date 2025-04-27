

public class poly_overload {

    public static void main(String[] args) {

        calc add1= new calc();
        calc add2 = new calc();
        System.out.println(add1.sum(3,4));
        System.out.println(add1.sum((float)3.5,(float)4.5));
        System.out.println(add2.sum(3,4, 5));
        
    }
    
}

class calc{
    int sum(int a ,int b){
        return a+b;
    }

    float sum(float a ,float b){
        return a+b;
    }

    int sum(int a,int b,int c){
        return a+b+c;
    }
}
