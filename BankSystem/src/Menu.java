import java.util.Scanner;

//Displays the various menus used throughout the program
public class Menu {
    private int menuOption;
    //Bank System By Dalvin Wray
    Scanner scan = new Scanner(System.in);


    public int getMainMenuOptions(){
        return menuOption;
    }
    public void setMainMenuOptions(){

        System.out.println("***********Main Menu***********");
        System.out.println("Please Select the Number Beside the Option You Wish To Select to Continue");
        System.out.println("1.Create a Sub Account");
        System.out.println("2.Login to Sub Account");
        System.out.println("3.Transfer Money Between Sub Savings Accounts");
        System.out.println("4.Check Sub Savings Account Balance");
        System.out.println("5.Logout");
        menuOption= scan.nextInt();

    }

    public void setErrorMessage(){
        System.out.println("ERROR INCORRECT MENU OPTION");
    }

    public int getCreateSubAccountMenuOption(){
        return menuOption;
    }


    public void setCreateSubAccountMenuOption(){
        System.out.println("*********Create a Sub Account Menu***********");
        System.out.println("1.Create a Savings Account");
        System.out.println("2.Create a Personal Loan Account");
        menuOption= scan.nextInt();
    }


    public int getLoginToSubAccountMenuOption(){
        return menuOption;
    }

    public void setLoginToSubAccountMenuOption() {
        System.out.println("**************Sub Account Login Menu ****************");
        System.out.println("1.Login to Savings Account");
        System.out.println("2.Login to Personal Loan Account");
        menuOption= scan.nextInt();
    }


    public int getSavingsAccountMenuOption(){
        return menuOption;
    }

    public void setSavingsAccountMenuOption(){
        System.out.println("**************Savings Account Menu ****************");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        menuOption= scan.nextInt();
    }

    public int getPlaMenuOption(){
        return menuOption;
    }

    public void setPlaMenuOption(){
        System.out.println("***********************Personal Loan Account Menu***************");
        System.out.println("1.Check How Much Money I am Allowed to Borrow");
        System.out.println("2.Take out a loan");
        menuOption= scan.nextInt();
    }




}
