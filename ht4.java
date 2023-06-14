import java.util.Scanner;
import java.io.IOException;

import java.util.logging.*; 

public class ht4 {
    //     Реализовать простой калькулятор (+-/*).К калькулятору из предыдущего ДЗ добавить логирование.
public static void main(String[] args) throws SecurityException, IOException {
    Logger ll = Logger.getLogger(ht4.class.getName());
    ll.setUseParentHandlers(false);
    String logsPath = "log4.txt";
    FileHandler fh = new FileHandler(logsPath, true);
    ll.addHandler(fh);
    SimpleFormatter formatter = new SimpleFormatter();
    fh.setFormatter(formatter);
    Scanner sc = new Scanner(System.in, "cp866");
            System.out.print("Введите 1е число: ");
            int number_1 = sc.nextInt();
            ll.info("First number "+ number_1);
            System.out.print("Введите 2е число: ");
            int number_2 = sc.nextInt();
            ll.info("Second number "+ number_2);
            sc.nextLine();
            System.out.print("Введите действие: ");
            String action = sc.nextLine();
            ll.info("Action " + action);
            double result = 0;
            switch (action) {
                case "+":
                result = number_1+ number_2;
                break;
                case "-":
                result = number_1- number_2;
                break;
                case "*":
                result = number_1* number_2;
                break;
                case "/":
                result = number_1/number_2;
                break;
                default:
                System.out.print("Ошибка ввода.");
                break;
            }
            ll.info("Result " + result);
            String res = number_1 + " " +action + " "  +  number_2 + " = " + result;
            System.out.println(res);

    }
}
