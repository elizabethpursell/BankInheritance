import java.util.Scanner;       //import Scanner class
public class BankManager{
    public static void main(String [] args){
        Scanner myScan = new Scanner(System.in);
        Bank.monthlyFee = 20.0;

        //create and fill bankAcctList
        BankAccount [] bankAcctList = new BankAccount[10];
        bankAcctList[0] = new SavingsAccount(183957, "Charlie", "Savings", 75395.59, 3.4);
        bankAcctList[1] = new SavingsAccount(573827, "Mark", "Savings", 46328.38, 5.2);
        bankAcctList[2] = new SavingsAccount(592235, "Emma", "Savings", 28462.34, 4.6);
        bankAcctList[3] = new SavingsAccount(563293, "Steve", "Savings", 56372.44, 3.5);
        bankAcctList[4] = new SavingsAccount(883923, "Oliva", "Savings", 28434.24, 6.3);
        bankAcctList[5]= new CheckingAccount(394845, "Dorothy", 12758.48, "Checking");
        bankAcctList[6] = new CheckingAccount(239224, "Beth", 46284.32, "Checking");
        bankAcctList[7] = new CheckingAccount(129583, "Nick", 47562.43, "Checking");
        bankAcctList[8] = new CheckingAccount(589203, "Bill", 56385.97, "Checking");
        bankAcctList[9] = new CheckingAccount(629384, "Sofia", 27568.53, "Checking");

        //create new Bank with bankAcctList
        Bank myBank = new Bank("Lehigh University Bank", "Bethlehem", bankAcctList);

        boolean quit = false;
        //do-while loop to display menu while user does not want to quit
        do{
            displayMenu(myBank);    //display menu
            int userInput = getUserInput(myScan);
            switch(userInput){      //call methods based on user's input
                case 1:
                    manageAccount(myScan, myBank);
                    break;
                case 2:
                    myBank.viewAllAccounts();
                    System.out.println();
                    break;
                case 3:
                    myBank.applyMonthlyFee();
                    System.out.println("Monthly Fee Applied.");
                    myBank.viewAllAccounts();
                    System.out.println();
                    break;
                case 4:
                    myBank.sortAccounts();
                    System.out.println("Accounts Sorted.");
                    myBank.viewAllAccounts();
                    System.out.println();
                    break;
                case 5:
                    quit = true;
                    System.out.println("Goodbye.");
                    break;
            }
        }while(!quit);
    }
    public static void displayMenu(Bank myBank){        //method to display the main menu
        System.out.println(myBank.getName() + " Main Menu:");
        System.out.println("\t1. Manage Existing Account");
        System.out.println("\t2. View All Accounts");
        System.out.println("\t3. Apply Monthly Fee");
        System.out.println("\t4. Sort Accounts");
        System.out.println("\t5. Quit");
        System.out.println("Enter your choice: ");
    }
    public static int getUserInput(Scanner myScan){     //method to verify and get user input
        boolean valid = false;
        int userInput = 0;
        do{
            valid = myScan.hasNextInt();
            if(!valid){
                System.out.println("Invalid Input: Not an Integer. Try Again.");
                myScan.nextLine();
            }
            else{
                userInput = myScan.nextInt();
                myScan.nextLine();
                if(userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5){
                    System.out.println("Invalid Input: Out of Range. Try Again.");
                    valid = false;
                }
            }
        }while(!valid);
        return userInput;
    }
    public static void manageAccount(Scanner myScan, Bank myBank){      //method to manage account
        boolean valid = false;
        int userNum = 0;
        BankAccount userAccount = new SavingsAccount(null, 0, null, 0);

        //do-while loop to get user's account number until valid
        do{
            System.out.println("Enter an account number:");
            valid = myScan.hasNextInt();
            if(!valid){
                System.out.println("Invalid Input: Not an Integer.");
                myScan.nextLine();
            }
            else{
                userNum = myScan.nextInt();
                myScan.nextLine();
                if(Integer.toString(userNum).length() != 6){
                    System.out.println("Invalid Input: Not 6 Digits.");
                    valid = false;
                }
                if(valid){
                    userAccount = myBank.getAccount(userNum);
                    if(userAccount == null){
                        System.out.println("Invalid Input: Account Number Not Found.");
                        valid = false;
                    }
                }
            }
        }while(!valid);

        boolean quit = false;
        double amount = 0;

        //do-while loop to display manage account menu until quit
        do{
            displayAcctMenu();
            int userInput = getUserInput(myScan);
            switch(userInput){      //switch statement to call methods based off user's input
                case 1:
                    System.out.println("$" + userAccount.getBalance());
                    break;
                case 2:
                    amount = getAmount(myScan);
                    userAccount.deposit(amount);
                    System.out.println("$" + userAccount.getBalance());
                    break;
                case 3:
                    amount = getAmount(myScan);
                    userAccount.withdraw(amount);
                    System.out.println("$" + userAccount.getBalance());
                    break;
                case 4:
                    if(userAccount instanceof SavingsAccount){
                        SavingsAccount userAccountS = (SavingsAccount) userAccount;
                        System.out.printf("Balance with Monthly Interest $%.2f\n", userAccountS.applyMonthlyInterest());
                    }
                    else if(userAccount instanceof CheckingAccount){
                        System.out.println("Invalid Input: Cannot Apply Monthly Interest to Checking Account.");
                    }
                    break;
                case 5:
                    quit = true;
                    System.out.println("Goodbye.");
                    break;
            }
        }while(!quit);
    }
    public static void displayAcctMenu(){       //method to display the manage account menu
        System.out.println("Account Main Menu:");
        System.out.println("\t1. View Balance");
        System.out.println("\t2. Deposit");
        System.out.println("\t3. Withdraw");
        System.out.println("\t4. View the Monthly Interest");
        System.out.println("\t5. Exit Manage Account");
        System.out.println("Enter your choice: ");
    }
    public static double getAmount(Scanner myScan){     //method to get valid double amount
        boolean valid = false;
        double amount = 0;
        do{
            System.out.println("Enter an Amount: ");
            valid = myScan.hasNextDouble();
            if(!valid){
                System.out.println("Invalid Input: Not a Double Value.");
                myScan.nextLine();
            }
            else{
                amount = myScan.nextDouble();
                myScan.nextLine();
            }
        }while(!valid);
        return amount;
    }
}