public class Class_obj {

    public static void main(String args[]){
        Pen P1 = new Pen();   // created a pen object called P1
        P1.setColor("Blue");
        System.out.println(P1.color);
        P1.setTip(5);
        System.out.println(P1.tip);

        Student S1 = new Student(); // created a student object called S1
        S1.Name = "Meenal";
        S1.age = 18;
        S1.calPer(45,87,98);
        System.out.println(S1.percentage);

    } 
}

class Pen {          
    String color;
    int tip;

    void setColor(String newColor){
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}

class Student {

    String Name;
    int age;
    float percentage;

    void calPer (int maths, int physics, int chemistry){
        percentage = (((maths+physics+chemistry)*100)/300);
    }

}