import java.util.Scanner;

//Used for the initial login
public class Login {
    //Bank System By Dalvin Wray
    private int mainAccountSavingsNumber;
    private int mainAccountSavingsNumberPin;


    Scanner scan=new Scanner(System.in);

    public void loginMessage(){
        System.out.println("Welcome to the National Bank of Dalvin Wray");
        System.out.println("Please Enter Your Credentials Below");
    }

    public int getAccountSavingsNumber() {
        return mainAccountSavingsNumber;
    }

    public void setAccountSavingsNumber(){
        System.out.println("Please Enter Your Main Account Savings Number: ");
        mainAccountSavingsNumber = scan.nextInt();
    }   //Bank System By Dalvin Wray

    public int getMainAccountSavingsNumberPin(){
        return mainAccountSavingsNumberPin;
    }

    public void setMainAccountSavingsNumberPin(){
        System.out.println("Please Enter Your Main Account Savings Number Pin");
        mainAccountSavingsNumberPin=scan.nextInt();
    }

    public void loginSuccessfulMessage(){
        System.out.println("Login Succesful");
    }

    public void loginUnsuccessfulMessage(){
        System.out.println("Login Unsuccesful");
    }



}
