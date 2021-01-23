package banking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        Menu.mainMenu(scanner, accounts);
    }
}