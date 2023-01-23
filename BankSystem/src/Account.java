import java.util.Scanner;

public class Account {

    private int subAccountNumber;
    protected boolean tempStatus=false;

    private boolean authenticationStatus;

    protected int existingSubAccountNumber;
    protected int accountInfoStorageRowIndex;
    protected int savingsPlaLinkRowIndex;
    private int savingsAccAsc;

    protected int [][]savingsPlaLink=new int[100][2];
    protected double  [][] accountInfoStorage= new double [100][2];



    Scanner scan =new Scanner(System.in);


    //Prompts user to enter the account number for the account they wish to create
    public void createAccount(){
        System.out.println("Please Enter The Account Number You Wish To Use For The Account You Are Creating");
        subAccountNumber=scan.nextInt();
    }

    // for savings account

    //Stores the savings account number if all the necessary rules are met
    public void accountNumberStorage(){

        boolean accountExistStatus=false;

        //Searches the array that stores the account number and account balance for the savings account
        //to see if the savings account exist, if the account exist then the boolean variable will
        //be assigned a value of true, else the initial value of  false will remain.
        for (int i =0;i<100;i++) {
            if (subAccountNumber == accountInfoStorage[i][0]){
                accountExistStatus=true;
                break;
            }
        }

        //If the account does not already exist the 2d array will store the subAccountNumber in the first column
        //then increment the row index number to make room for when a new value will be stored
        if (accountExistStatus==false){
            accountInfoStorage[accountInfoStorageRowIndex][0] = subAccountNumber;
            accountInfoStorageRowIndex++;
            System.out.println("Account created successfully");
        }

        //If the account Exists an appropriate error message will be displayed
        else{
            System.out.println("Account created unsuccessfully, because account number already exists");
        }

    }

    //Asks user to enter an existing subAccountNumber that will be used for login
    public void setExistingAccountNumber(){
        System.out.println("What is the Sub Account Number you wish to login to: ");
        existingSubAccountNumber=scan.nextInt();
    }//Bank System By Dalvin Wray


    //Verifies that the savings account number exists
    public void setAccountNumberAuthentication(){

        //Searches the savings account array to see if the user entered a valid savings account
        //if the user entered a valid savings account number, then true will be assigned to a boolean variable
        for (int i=0;i<100;i++){
            if (existingSubAccountNumber==accountInfoStorage[i][0]){
                authenticationStatus=true;
                break;
            }

        }

        //If the boolean variable was assigned true an appropriate message will be printed
        //To show that login was successful. Else the authentication status will be false.

        if(authenticationStatus==true){
            System.out.println("Login Successful");
        }

        else {
            System.out.println("Account Does Not Exist");
            authenticationStatus=false;
        }
    }

    //Get method used for the authenticationStatus variable;
    public boolean getAccountNumberAuthentication(){
        return authenticationStatus;
    }


    //personaol loan account

    //Get method used for the savingsAccAsc variable;
    public int getSavingsAccAsc(){
        return savingsAccAsc;
    }

    //Asks user which to enter a savings account to pair with their personal loan account
    public void setSavingsAccAsc(){
        System.out.println("Please Enter the savings account you wish to associate your Personal Loan Account With.");
        savingsAccAsc=scan.nextInt();
    }

    //Verifies then stores personal loan account and savings account

    public void storeSavingsPlaLink(){
        //first is pla then second is matching savings account number

        boolean accountExistStatus = false;
        boolean accountExistStatusForSavingsAcc=false;

        //searches the 2d array that stores details for the personal loan account to make sure that
        //the account numbers do not exist
        for (int i =0;i<100;i++) {
            if (subAccountNumber == savingsPlaLink[i][0]){
                accountExistStatus=true;
                break;
            }
        }

        for (int i =0; i<100;i++){
            if (savingsAccAsc==savingsPlaLink[i][1]){
                accountExistStatusForSavingsAcc=true;
                break;
            }
        }

        //if the account number do not exist the data is stored and the row number is incremented to make room for the
        //next time data needs to be stored
        if (accountExistStatus==false&&accountExistStatusForSavingsAcc==false){
            savingsPlaLink[savingsPlaLinkRowIndex][0] = subAccountNumber;
            savingsPlaLink[savingsPlaLinkRowIndex][1]=savingsAccAsc;
            savingsPlaLinkRowIndex++;
            System.out.println("Account created successfully");
        }

        else{
            System.out.println("Account created unsuccessfully, because account number already exists");
        }
    }

    //Verifies that the personal loan account exists
    public void setPlaLoginAuthentication(){
        for (int i=0;i<100;i++){
            if (existingSubAccountNumber==savingsPlaLink[i][0]){
                authenticationStatus=true;
                break;
            }
        }

        if(authenticationStatus==true){
            System.out.println("Login Successful");
        }

        else {
            System.out.println("Account Does Not Exist");
            authenticationStatus=false;
        }
    }



}
