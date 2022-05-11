public class SavingsAccount extends BankAccount{     //subclass of BankAccount
    private double yearlyInterest;
    public SavingsAccount(String owner, double balance, String type, double rate){      //4-arg constructor
        super(owner, type, balance);
        yearlyInterest = rate;
    }
    public SavingsAccount(int number, String owner, String type, double balance, double rate){      //5-arg constructor
        super(number, owner, type, balance);
        yearlyInterest = rate;
    }
    public double getInterestRate(){        //method to get interest rate
        return yearlyInterest;
    }
    public void setInterestRate(double yearlyInterest){     //method to set interest rate
        this.yearlyInterest = yearlyInterest;
    }
    public double applyMonthlyInterest(){       //method to apply monthly interest
        return balance + ((balance * yearlyInterest / 12) / 100);
    }
    @Override       //method to override Object class's toString() method; used for printing; refers to parent class's toString() method
    public String toString(){
        return super.toString() + "\tYearly Interest: " + yearlyInterest + "%";
    }
}
