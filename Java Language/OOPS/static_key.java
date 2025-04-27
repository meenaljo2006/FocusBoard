public class static_key {
    public static void main(String[] args) {

        student S1 = new student();
        S1.School_name= "SFS";

        student S2 = new student();
        System.out.println(S2.School_name);
        
    }
  
}

class student{

    static int per(int maths,int physics,int chem){
        return((maths+physics+chem)/3);
    }

    String name;
    int rollNo;
    static String School_name;

    void setname(String name){
        this.name = name;
    }

    String getname(){
        return this.name;
    }

}
