package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int min = 0;
        int hour = 0;
        while (input > 500){
            min += 45;
            hour += 5;
            input = input - 500;
        }
        hour += input / 100;
        System.out.println(hour*60 + min);
    }
}