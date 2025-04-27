public class Acc_mod {

    public static void main(String[] args) {

        BankAccount myAcc = new BankAccount();
        myAcc.username = "Meenaljoshi";
        myAcc.setPass(123440);

        
    }
    
}

class BankAccount {

    public String username;
    private int password;

    public void setPass(int pwd) {
        password = pwd;
    }


}
