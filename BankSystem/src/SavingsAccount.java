public class SavingsAccount extends Account{
    private double depositAmount;
    private double withdrawalAmount;
    private int transferMoneyFrom;
    private int transferMoneyTo;
    private double transferAmount;
    private boolean transferMoneyFromVerificationStatus;
    private boolean transferMoneyFromBalanceVerificationStatus;
    private boolean transferMoneyToVerificationStatus;
    private boolean transferVerificationStatus;

    private int transferMoneyFromIndexPosition;
    private int transferMoneyToIndexPosition;
    private int balanceCheckAccNum;

    //Asks user how much money they wish to deposit to their account
    public void depositToSavingsAccount(){
        System.out.println("Please enter the amount you wish to deposit");
        depositAmount=scan.nextDouble();
    }

    public void addToSavingsAccountBalance(){
        //All deposits must be more than $5000
        if (depositAmount>=5000){
            //Searches for the savings account number, then add the amount of money to be deposited to it
            for (int i=0;i<100;i++) {
                if (existingSubAccountNumber == accountInfoStorage[i][0]) {
                    accountInfoStorage[i][1] += depositAmount;
                    System.out.println("Deposit Successful");
                    break;
                }
            }
        }

        else{
            System.out.println("You do not have enough money to make a deposit.");
        }
    }

    //Asks user how much money they wish to withdraw
    public void withdrawFromSavingsAccount(){
        System.out.println("Please enter the amount you wish to withdraw");
        withdrawalAmount= scan.nextDouble();
    }

    //Searches for the savings account number, then subtract the amount of money to be withdrawn from it
    public void subtractFromSavingsAccountBalance(){
        for (int i=0;i<100;i++) {
            if (existingSubAccountNumber == accountInfoStorage[i][0]) {
                accountInfoStorage[i][1] -= withdrawalAmount;
                System.out.println("Withdrawal Successful");
                break;
            }
        }

    }


    //Asks user for the relevant details for a transfer
    public void setTransferDetails(){
        System.out.println("Please enter the account you wish to transfer the money from ");
        transferMoneyFrom= scan.nextInt();
        System.out.println("Please enter the account you wish to transfer the money to ");
        transferMoneyTo=scan.nextInt();
        System.out.println("Please enter the amount of money you wish to transfer ");
        transferAmount= scan.nextDouble();
    }




    public void setTransferMoneyFromVerificationStatus(){

        for (int i =0;i<100;i++){
            //Make sures that the account the money will be transferred from exists and also stores a boolean value if it exists
            if (accountInfoStorage[i][0]==transferMoneyFrom){
                transferMoneyFromVerificationStatus=true;

                //Transfers are only allowed on accounts with a balance of $10000 or more, hence that is checked
                //Also transfer amount must be greater than the amount in the account
                //If both of those are true then the boolean value true will be stored to a variable
                // also a variable will store the index position of the account details in the array
                if(accountInfoStorage[i][1]>=10000 && accountInfoStorage[i][1]>transferAmount){
                    transferMoneyFromBalanceVerificationStatus=true;
                    transferMoneyFromIndexPosition=i;
                }
                break;
            }
        }

    }

    //Checks to see if the account money will be transferred to exists and if it does
    //a boolean variable will store the value true
    //another variable will also store the index position of the account details in the array
    public void setTransferMoneyToVerificationStatus(){

        for(int i=0;i<100;i++){
            if(accountInfoStorage[i][0]==transferMoneyTo){
                transferMoneyToVerificationStatus=true;
                transferMoneyToIndexPosition=i;
                break;
            }
        }
    }



    //get method that returns the verisfication status of the transfer
    public boolean getTransferVerificationStatus(){
        return transferVerificationStatus;
    }

    //If all verification checks that were previously done on the account is true then a boolean variable will store a value true
    public void setTransferVerificationStatus(){

        if (transferMoneyFromVerificationStatus && transferMoneyFromBalanceVerificationStatus && transferMoneyToVerificationStatus & transferAmount>0 == true){
            transferVerificationStatus=true;
        }

        else{
            transferVerificationStatus=false;
        }
    }

    //Subtracts the transfer amount from the account doing the transfer
    //adds the transfer amount to the account receiving the transfer
    //this method is positioned strategically, so it will only be executed when necessary checks are done
    public void moneyTransfer(){
        accountInfoStorage [transferMoneyToIndexPosition][1]+=transferAmount;
        accountInfoStorage [transferMoneyFromIndexPosition][1]-=transferAmount;
        System.out.println("Money Transferred Successfully");
    }



    //Balance check
    public void balanceCheck(){
        boolean existStatus=false;

        System.out.println("Please enter the account number for the account you wish to check the balance for ");
        balanceCheckAccNum= scan.nextInt();


        for (int i=0;i<100;i++){
            if(balanceCheckAccNum==accountInfoStorage[i][0]){
                System.out.println("Your Account Balance Is: "+accountInfoStorage[i][1]);
                existStatus=true;
                break;
            }//Bank System By Dalvin Wray
        }
        if (existStatus==false){
            System.out.println("Account Does Not Exist");
        }


    }

}
