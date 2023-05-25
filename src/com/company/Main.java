package com.company;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(((\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3})(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("ip-addresses.txt"))) {
                bw.write(matcher.group());
            } catch (IOException e) {
                System.out.println("Ошибка");
            }
        } else {
            System.out.println("Не выявлено совпадение");
        }
    }
}