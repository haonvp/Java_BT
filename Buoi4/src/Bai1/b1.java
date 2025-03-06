package Bai1;

import java.util.Scanner;

public class b1 {
    public static void countLetter(String letter) {
        letter = letter.trim().toLowerCase();
        String[] word = letter.split(" ");
        int[] count = new int[word.length];
        int dem = 1;
        for (int i = 0; i < word.length; i++) {
            dem = 1;
            if (count[i] == 0) {
                for (int j = i + 1; j < word.length; j++) {
                    if (word[i].equals(word[j])) {
                        dem++;
                        count[j] = -1;
                    }
                }
                count[i] = dem;
            }
        }
        System.out.println("Câu a. ");
        for (int i = 0; i < word.length; i++) {
            if (count[i] != -1) {
                System.out.println(word[i] + ": " + count[i] + " lần");
            }
        }
    }

    public static void uperLetter(String letter) {
        StringBuilder changeText = new StringBuilder();
        String[] word = letter.split(" ");
        for (int i = 0; i < word.length; i++) {
            changeText.append(word[i].substring(0, 1).toUpperCase()).append(word[i].substring(1)).append(" ");
        }
        System.out.println("Câu b. " + changeText);
    }

    public static void xoaNguyenAm(String letter) {
        StringBuilder result = new StringBuilder();
        char c = ' ';
        for (int i = 0; i < letter.length(); i++) {
            c = letter.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                result.append(c);
            }
        }
        System.out.println("Câu c. Sau khi xóa nguyên âm: " + result);
    }

    public static void main(String[] args) {
        System.out.println("Nhập văn bản: ");
        String letter = new Scanner(System.in).nextLine();
        countLetter(letter);
        System.out.println("*****************");
        uperLetter(letter);
        System.out.println("*****************");
        xoaNguyenAm(letter);
    }
}
