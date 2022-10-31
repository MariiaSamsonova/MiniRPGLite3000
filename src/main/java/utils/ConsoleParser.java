package utils;

import java.util.Scanner;


public class ConsoleParser implements InputParser{

    Scanner sc ;//TODO safe-scanner
    @Override
    public int getInteger() {
        sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void print(String alert) {
        System.out.println(alert);
    }

    @Override
    public String getString() {
        sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void doSomethingToContinue() {
        System.out.println("Press Enter to continue");
        sc = new Scanner(System.in);
        sc.nextLine();
    }
}
