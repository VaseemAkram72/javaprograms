import java.util.Scanner;

public class ATMExample {
    public static void main(String[] args) {
        int balance = 100000, withdraw, deposit;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("_________Welcome to simplified learner ATM");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 1 for Deposit ");
            System.out.println("Choose 1 for Check Balance");
            System.out.println("Choose 1 for Check Balance");
            System.out.print("Choose the operation you want to perform :");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter money to be withdraw: ");

                    withdraw = sc.nextInt();

                    if (balance >= withdraw) {
                        balance = balance - withdraw;
                        System.out.println("Please Collect your Money.");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Enter money to be deposited :");
                    deposit = sc.nextInt();

                    balance = balance + deposit;
                    System.out.println("Your Money has been successfully deposited");
                    System.out.println("");

                    break;

                case 3:
                    System.out.println("Balance : " + balance);
                    System.out.println("");
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}