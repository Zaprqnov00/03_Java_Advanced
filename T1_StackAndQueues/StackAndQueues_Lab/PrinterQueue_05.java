package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printHistory = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("print")){
            if (command.equals("cancel")){
                if (printHistory.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + printHistory.poll());
                }
            }else {
                printHistory.offer(command);
            }
            command = scanner.nextLine();
        }

        for (String texts :printHistory) {
            System.out.println(texts);
        }
    }
}
