public class PersonalLoanAccount extends Account{
    private int plaAscSavingsAccountNumber;

    //checks to see if the personal loan account exists
    //if it exists the method stores the savings account number associated with the persoanl
    //loan account number in a variable then the method returns the variable
    //containing the savings account number.
    public int getPlaAscSavingsAccountNumber(){
        for (int i=0;i<100;i++){
            if (existingSubAccountNumber == savingsPlaLink[i][0]){
                plaAscSavingsAccountNumber =savingsPlaLink[i][1];
                break;
            }
        }
        return plaAscSavingsAccountNumber;
    }//Bank System By Dalvin Wray






}
