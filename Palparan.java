import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] users = new String[100][2];
        int userCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n"+"==== LOGIN SYSTEM ====" + "\n");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("\n" +"===== LOGIN =====" + "\n");
                    System.out.print("Enter username: ");
                    String loginUsername = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = sc.nextLine();
                    boolean loginSuccess = false;

                    for (int i = 0; i < userCount; i++) {
                        if (users[i][0].equals(loginUsername) && users[i][1].equals(loginPassword)) {
                            System.out.println("Hello, " + loginUsername + "!");
                            loginSuccess = true;
                            break;
                        }
                    }

                    if (!loginSuccess) {
                        System.out.println("Invalid username or password!");
                    }
                    break;
                case 2:
                    System.out.println( "\n"+"===== REGISTER =====" + "\n");
                    System.out.print("Enter username: ");
                    String registerUsername = sc.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = sc.nextLine();
                    System.out.print("Confirm password: ");
                    String confirmPassword = sc.nextLine();

                    boolean usernameExists = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i][0] != null && users[i][0].equals(registerUsername)) {
                            usernameExists = true;
                            break;
                        }
                    }

                    if (usernameExists) {
                        System.out.println("Username already exists!");
                    } else if (!registerPassword.equals(confirmPassword)) {
                        System.out.println("Passwords do not match!");
                    } else {
                        users[userCount][0] = registerUsername;
                        users[userCount][1] = registerPassword;
                        userCount++;
                        System.out.println("Registration successful!");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
