public class Constructor {

    public static void main(String[] args) {

        student S1 = new student("Meenal");
        S1.rollNo = 9;
        S1.marks[0]=89;
        S1.marks[1]=96;
        S1.marks[2]=90;
        student S2 = new student(S1);
        System.out.println(S1.name);
        S1.marks[1]=78;
        

        for(int i=0;i<3;i++){
            System.out.println(S2.marks[i]);
        }
    }
    
}

class student {

    String name;
    int rollNo ;
    int marks[] ;

    student(String name){    //parametrized constructor
        marks = new int[3]; 
        this.name = name;
    }

    student(){      // non parametrized constructor
        marks = new int[3]; 
        System.out.println("Constructor is called...");
    }

    // student(student S1){   // Shallow copy constructor
    //     marks = new int[3];           
    //     this.name = S1.name; 
    //     this.rollNo = S1.rollNo;
    //     this.marks = S1. marks;
    // }

    student(student S1){     // deep copy

        marks = new int[3];           
        this.name = S1.name; 
        this.rollNo = S1.rollNo;
        for(int i=0;i<marks.length;i++){
            this.marks[i] = S1. marks[i];
        }



    }

    

    
}



