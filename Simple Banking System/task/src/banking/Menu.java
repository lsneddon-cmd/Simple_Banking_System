package banking;

public class Menu {
    public static void mainMenu() {
        MainMenu choice;
        while(true) {
            try {
                MainMenu.printMenu();
                choice = MainMenu.values()[Integer.parseInt(Main.scanner.nextLine())];
                switch (choice) {
                    case NEW:
                        // TODO look at creational design patterns
                        Account.createNewAccount();
                        break;
                    case LOGIN:
                        Account current = AuthManager.logIntoAccount();
                        if (current != null) {
                            System.out.println("\nYou have successfully logged in!\n");
                            accountMenu(current);
                        } else {
                            System.out.println("\nWrong card number or PIN!\n");
                        }
                        break;
                    case EXIT:
                        System.out.println("Bye!");
                        System.exit(0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inappropriate input");
            }
        }
    }

    public static void accountMenu(Account account) {
        AccountMenu choice;
        while(true) {
            try {
                AccountMenu.printMenu();
                choice = AccountMenu.values()[Integer.parseInt(Main.scanner.nextLine())];
                switch (choice) {
                    case BALANCE:
                        System.out.println("Balance: " + account.getBalance());;
                        break;
                    case LOGOUT:
                        System.out.println("You have successfully logged out");
                        return;
                    case EXIT:
                        System.out.println("Bye!");
                        System.exit(0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inappropriate input");
            }
        }
    }
}
