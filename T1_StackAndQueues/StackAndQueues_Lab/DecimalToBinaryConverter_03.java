package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumbers = new ArrayDeque<>();

        while (number > 0){
            int pushBinaryNumber = number % 2;
            number = number / 2;
            binaryNumbers.push(pushBinaryNumber);
        }

        for (int num :binaryNumbers) {
            System.out.print(num + "");
        }
    }
}
