import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        UserDb userDb= new UserDb();
        User user;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter UserId");
        String userId = sc.next();

        System.out.println("\nEnter UserPin");
        String userPin = sc.next();


        if (userDb.validateUser(userId,userPin)){
            boolean exit = false;
            while(!exit) {
                System.out.println("\n"+"""
                        1.Transaction History
                        2.Withdrawal
                        3.Deposit
                        4.Transfer
                        5.Quit
                        6.Check Balance
                        """);
                int option = sc.nextInt();

                switch (option) {
                    case 1 : {
                        System.out.println("\n");
                        for (String statement : userDb.getUser().getTransactionHistoryList()) {
                            System.out.println(statement);
                        }
                        break;
                    }
                    case 2 : {
                        Withdrawal withdrawal = new Withdrawal();

                        System.out.println("\nEnter Withdrawal amount.");
                        int amount = sc.nextInt();

                        boolean success = withdrawal.withdrawalAmount(amount);
                        if (success) {
                            System.out.println("\n" + amount + " is withdrawal successfully.\n");
                        } else {
                            System.out.println("\nInsufficient balance???");
                        }
                        break;
                    }
                    case 3 : {
                        Deposit deposit = new Deposit();

                        System.out.println("\nEnter Deposit amount.");
                        int amount = sc.nextInt();
                        boolean success = deposit.depositAmount(amount);
                        if (success) {
                            System.out.println("\n" + amount + " is deposited successfully.");
                        } else {
                            System.out.println("\ninvalid amount.");
                        }
                        break;
                    }
                    case 4 : {
                        System.out.println("\nEnter name toTransfer");
                        sc = new Scanner(System.in);
                        String receiverName = sc.next();

                        System.out.println("\nEnter amount toTransfer " + receiverName);
                        int transferAmount = sc.nextInt();

                        Transfer transfer = new Transfer();
                        boolean success = transfer.transferAmount(transferAmount);
                        if (success) {
                            System.out.println("\n" + transferAmount + " amount transfer to " + receiverName + " successfully.\n");
                        } else {
                            System.out.println("\nInsufficient balance???");
                        }
                        break;
                    }
                    case 5 : {
                        System.out.println("Quit....");
                        exit = true;
                        break;
                    }
                    case 6 : {
                        user = userDb.getUser();
                        System.out.println("\nYour total balance is " + user.getBalance() + "₹");
                        break;
                    }
                    default : {
                        System.out.println("\nSelect Correct option");
                        break;
                    }
                }
            }
        }else {
            System.out.println("\nUser Not found");
        }
    }
}