public class Bank {
    public static void main(String[] args) {

        Login login=new Login();
        Menu menu = new Menu();
        SavingsAccount savings = new SavingsAccount();
        PersonalLoanAccount pla= new PersonalLoanAccount();

        //While loop that keeps asking the user to re-enter their password
        while(true) {

            //Login Message
            login.loginMessage();

            //User Enters Main Savings Account Number
            login.setAccountSavingsNumber();

            //Main Savings Account Number Pin
            login.setMainAccountSavingsNumberPin();


            //Main Savings Account Authentication
            if (login.getAccountSavingsNumber() == 258647 & login.getMainAccountSavingsNumberPin() == 3284) {
                //Login Successful Message
                login.loginSuccessfulMessage();

                //While loop that keeps the program running until user decides to end the program
                while (true) {

                    //MainMenu Options
                    menu.setMainMenuOptions();

                    //First MainMenu Option Which Is To Create An Account
                    if (menu.getMainMenuOptions() == 1) {

                        //Displays an appropriate menu that gives users various options
                        menu.setCreateSubAccountMenuOption();

                        //Create a Savings account
                        if(menu.getCreateSubAccountMenuOption()==1){

                            //User Enters the account number for the savings account they wish to create
                            savings.createAccount();

                            //Stores account number if neccessary conditions are met
                            savings.accountNumberStorage();

                        }

                        //Create a personal loan account
                        else if (menu.getCreateSubAccountMenuOption()==2) {

                            //User Enters the account number for the personal account they wish to create
                            pla.createAccount();

                            //User enters an existing savings account number that they wish to associate their personal loan account with
                            pla.setSavingsAccAsc();

                            //searches the array that stores the savings account information to see if
                            //the previously entered savings account exists
                            for (int i= 0;i<100;i++){
                                //If the savings account exist the program will store the value true in a variable
                                //that will later be used in the program
                                if (savings.accountInfoStorage[i][0]==pla.getSavingsAccAsc()){
                                    pla.tempStatus=true;
                                    break;
                                }
                            }

                            // if savings account exists necessary checks will be made, then the savings account number
                            //and personal loan account number will be stored together if the checks are all successfull
                            if (pla.tempStatus==true){
                                pla.storeSavingsPlaLink();
                            }

                            //if the savings account does not exist an appropriate error message is printed
                            else{
                                System.out.println("Savings Account Does Not Exist,hence Personal Loan Account Does Not Exist");
                            }



                        }

                        //Displays an appropriate error message if the value the user inputs is invalid
                        else{
                            menu.setErrorMessage();
                        }


                    }

                    //MainMenu Option 2 Login to Sub Account
                    else if (menu.getMainMenuOptions() == 2) {

                        //Login menu for the respective sub accounts
                        menu.setLoginToSubAccountMenuOption();

                        //Login to Savings Account
                        if(menu.getLoginToSubAccountMenuOption()==1){

                            //Asks user for an existing account number
                            savings.setExistingAccountNumber();

                            //Verifies that the savings account number exists
                            savings.setAccountNumberAuthentication();

                            //Allow user entry if the savings account number exists
                            if (savings.getAccountNumberAuthentication()==true){

                                //Appropriate menu options for the savings account
                                menu.setSavingsAccountMenuOption();

                                //Deposit to Savings Account
                                if(menu.getSavingsAccountMenuOption()==1){

                                    //Asks the user the amount they wish to deposit
                                    savings.depositToSavingsAccount();

                                    //If the correct criteria is met the money will be deposited to the account
                                    savings.addToSavingsAccountBalance();
                                }

                                //Withdraw from Savings Account
                                else if (menu.getSavingsAccountMenuOption()==2) {
                                    //Asks the user for the withdrawal amount
                                    savings.withdrawFromSavingsAccount();

                                    //If the correct criteria is met the money will be taken from the account
                                    savings.subtractFromSavingsAccountBalance();

                                }

                                else{
                                    menu.setErrorMessage();
                                }


                            }





                        }

                        //Login to Personal Loan Account
                        else if (menu.getLoginToSubAccountMenuOption()==2) {
                            //Asks user for personal loan account number
                            pla.setExistingAccountNumber();

                            //Verifies that the Personal Loan Account number exists
                            pla.setPlaLoginAuthentication();

                            if(pla.getAccountNumberAuthentication()==true){
                                //Displays an appropriate menu
                                menu.setPlaMenuOption();

                                //Calculates allowed loan amount
                                if(menu.getPlaMenuOption()==1){

                                    //Searches for the  savings account number associated with the personal loan account number
                                    //Then calculates the loan amount allowed based on the balance of the associated savings account
                                    for (int i=0;i<100;i++){
                                        if(savings.accountInfoStorage[i][0]==pla.getPlaAscSavingsAccountNumber()){
                                            System.out.println("You are eligible for a maximum loan of: "+ 1000*savings.accountInfoStorage[i][1]);
                                            System.out.println("Please visit the bank in person in order to take out a loan");
                                            break;
                                        }
                                    }

                                }

                                //Tells the user the procedures to get a loan
                                else if (menu.getPlaMenuOption()==2) {
                                    System.out.println("Please visit the bank in person in order to take out a loan");
                                    System.out.println("You can contact us at 1876 000 0000");

                                }

                                else{
                                    menu.setErrorMessage();

                                }

                            }

                        }

                        else{
                            menu.setErrorMessage();
                        }
                        //Bank System By Dalvin Wray
                    }


                    //Transfer money between sub savings accounts
                    else if (menu.getMainMenuOptions() == 3) {

                        //Set the necessary details to do a transfer
                        savings.setTransferDetails();

                        //Verifies that all the details are ok with the accounts and all the banks rules are followed
                        savings.setTransferMoneyFromVerificationStatus();
                        savings.setTransferMoneyToVerificationStatus();
                        savings.setTransferVerificationStatus();

                        //Transfers money  if the criteria is met to do so
                        if (savings.getTransferVerificationStatus()==true){
                            savings.moneyTransfer();
                        }

                        else {
                            System.out.println("Transfer Unsuccessful");
                            //Bank System By Dalvin Wray
                        }

                    }

                    //Check Sub Savings Account Balance
                    else if (menu.getMainMenuOptions() == 4) {
                        savings.balanceCheck();
                    }


                    else if (menu.getMainMenuOptions() == 5) {
                        break;
                    }


                    else{
                        menu.setErrorMessage();
                    }


                }



            }

            else {
                login.loginUnsuccessfulMessage();
            }

        }



    }



}