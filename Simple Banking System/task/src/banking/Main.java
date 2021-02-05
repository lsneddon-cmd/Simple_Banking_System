package banking;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Account> accounts = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        Menu.mainMenu(scanner);
    }
}