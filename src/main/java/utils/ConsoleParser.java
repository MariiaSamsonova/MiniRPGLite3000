package utils;
import rpg.*;

import java.util.Scanner;


public class ConsoleParser implements InputParser{

    @Override
    public int getInteger() {
        Scanner sc = new Scanner(System.in);//TODO safescanner
        return sc.nextInt();
    }

    @Override
    public void print(String alert) {
        System.out.println(alert);
    }

    @Override
    public String getString() {
        Scanner sc = new Scanner(System.in);//TODO safescanner
        return sc.nextLine();
    }
}
