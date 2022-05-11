public class CheckingAccount extends BankAccount{       //subclass to BankAccount
    public CheckingAccount(String owner, double balance, String type){      //3-arg constructor that calls BankAccount constructor
        super(owner, type, balance);
    }
    public CheckingAccount(int number, String owner, double balance, String type){  //4-arg constructor that calls BankAccount constructor
        super(number, owner, type, balance);
    }
    @Override       //method to override Object class's toString() method; used for printing; refers to parent class's toString() method
    public String toString(){
        return super.toString();
    }
    public double getInterestRate(){    //method to get interest rate -- 0 since CheckingAccounts don't have interest
        return 0;
    }
}
