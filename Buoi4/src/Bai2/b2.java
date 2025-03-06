package Bai2;

import java.util.Scanner;

public class b2 {
    public static boolean checkNumber(String number) {
        number = number.trim();
        if (number.startsWith("+84")) {
            if (number.substring(3).length() != 9) {
                return false;
            }
            return true;
        } else if (number.startsWith("84")) {
            if (number.substring(2).length() != 9) {
                return false;
            }
            return true;
        } else if (number.startsWith("0")) {
            if (number.substring(1).length() == 9 ||
                    (number.charAt(4) == '.' && number.charAt(8) == '.') ||
                    (number.charAt(4) == '-' && number.charAt(8) == '-')) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Nhập sđt: ");
        String number = new Scanner(System.in).nextLine();
        if (checkNumber(number)) {
            System.out.println("Hợp lệ");
        } else {
            System.out.println("Không hợp lệ");
        }
    }
}
