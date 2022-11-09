package utils;

import java.util.Scanner;


public class ConsoleParser implements InputParser{

    Scanner sc ;
    @Override
    public int getInteger() {
        while(true)
        {
            try {
                sc = new Scanner(System.in);
                return sc.nextInt();
            } catch (Exception ex){
                System.out.println("Try again");
            }

        }

    }

    @Override
    public void print(String alert) {
        System.out.println(alert);
    }

    @Override
    public String getString() {
        while (true) {
            try {
                sc = new Scanner(System.in);
                return sc.nextLine();
            } catch (Exception ex) {
                System.out.println("Try again");
            }
        }
    }

    @Override
    public void doSomethingToContinue() {
        System.out.println("Press Enter to continue");
        sc = new Scanner(System.in);
        sc.nextLine();
    }
}
