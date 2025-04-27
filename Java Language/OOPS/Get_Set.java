public class Get_Set {

    public static void main(String args[]){

        HPen P1 = new HPen();
        P1.setColor("Blue");
        P1.setTip(5);

        System.out.println(P1.getColor());
        System.out.println(P1.getTip());


    }
    
}

class HPen {

    private String color;
    private int tip;

    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }

    void setColor(String color){
        this.color = color;
    }

    void setTip(int tip){
        this.tip = tip;
    }


}