public abstract class BankAccount implements Comparable<BankAccount>{       //abstract parent class; uses Comparable interface
    private int number;     //account number
    private String owner;
    private String type;        //savings or checking
    protected double balance;
    protected BankAccount(String owner, String type, double balance){   //3-arg constructor
        this.owner = owner;
        this.type = type;
        this.balance = balance;
    }
    protected BankAccount(int number, String owner, String type, double balance){   //4-arg constructor
        this.number = number;
        this.owner = owner;
        this.type = type;
        this.balance = balance;
    }
    public int getNumber(){     //method to get account number
        return number;
    }
    public String getOwner(){       //method to get account owner
        return owner;
    }
    public String getType(){        //method to get account type
        return type;
    }
    public double getBalance(){     //method to get account balance
        return balance;
    }
    public void deposit(double amount){     //method to deposit amount into account balance
        balance = balance + amount;
    }
    public void withdraw(double amount){        //method to withdraw amount from account balance
        if(amount > balance){
            System.out.println("Not enough funds for withdraw.");
        }
        else{
            balance = balance - amount;
        }
    }
    public boolean equals(Object obj){      //overrides equals method to check account numbers
        if(obj instanceof BankAccount){
            BankAccount ba = (BankAccount) obj;
            if(getNumber() == ba.getNumber()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public int compareTo(BankAccount ba){       //overrides compareTo method in Comparable interface; used for sorting
        if(balance == ba.getBalance()){
            return 0;
        }
        else if(balance > ba.getBalance()){
            return 1;
        }
        else{
            return -1;
        }
    }
    @Override       //method to override Object class's toString() method; used for printing; refers to parent class's toString() method
    public String toString(){
        return "Type: " + getType() + "\tNumber: " + getNumber() + "\tOwner: " + getOwner() + "\tBalance: $" + getBalance();
    }
    public abstract double getInterestRate();       //abstract method to set up for override in subclasses
}