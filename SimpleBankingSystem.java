import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleBankingSystem {
    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.nextLine();
                    accounts.put(name, 0.0);
                    System.out.println("Account created.");
                    break;
                case 2:
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (accounts.containsKey(name)) {
                        accounts.put(name, accounts.get(name) + deposit);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (accounts.containsKey(name)) {
                        double balance = accounts.get(name);
                        if (withdraw <= balance) {
                            accounts.put(name, balance - withdraw);
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account name: ");
                    name = scanner.nextLine();
                    if (accounts.containsKey(name)) {
                        System.out.println("Balance: " + accounts.get(name));
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
