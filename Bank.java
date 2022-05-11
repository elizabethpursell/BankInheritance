import java.util.Arrays;        //import Arrays class
public class Bank {
    private String name;
    private String branch;
    private BankAccount [] bankAccounts;
    private int count;
    private static int accounts;
    public static double monthlyFee;
    public Bank(String name, String branch){    //2-arg constructor
        this.name = name;
        this.branch = branch;
        bankAccounts = new BankAccount [10];
        accounts = 0;
    }
    public Bank(String name, String branch, BankAccount [] bc){     //3-arg constructor
        this(name, branch);
        bankAccounts = bc;
    }
    public String getName(){        //method to get bank name
        return name;
    }
    public String getBranch(){      //method to get bank branch
        return branch;
    }
    public void applyMonthlyFee(){      //method to apply monthly fee
        for(int index = 0; index < bankAccounts.length; index++){
            bankAccounts[index].balance = bankAccounts[index].getBalance() - monthlyFee;
        }
    }
    public BankAccount getAccount(int number){      //method to get account with matching account number
        for(int index = 0; index < bankAccounts.length; index++){
            if(bankAccounts[index].getNumber() == number){

                return bankAccounts[index];
            }
        }
        return null;
    }
    public void viewAllAccounts(){      //method to print all accounts
        System.out.println("Bank Name: " + getName() + "; Branch: " + getBranch());
        for(int index = 0; index < bankAccounts.length; index++){
            System.out.println(bankAccounts[index].toString());
        }
    }
    public void sortAccounts(){     //method to sort accounts by balance
        Arrays.sort(bankAccounts);
    }
}
