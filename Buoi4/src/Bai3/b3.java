package Bai3;

import java.util.Scanner;
import java.util.Arrays;

public class b3 {
    public static void tongSo(int[] number) {
        int chan = 0;
        int le = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                chan += number[i];
            } else {
                le += number[i];
            }
        }
        System.out.println("\nTổng số chẵn: " + chan);
        System.out.println("Tổng số lẻ: " + le);
    }

    public static boolean soNguyenTo(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int[] sapXepChanGiam(int[] number) {
        int tam;
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                count++;
            }
        }
        int[] chan = new int[count];
        int index = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                chan[index++] = number[i];
            }
        }
        for (int i = 0; i < chan.length; i++) {
            for (int j = i + 1; j < chan.length; j++) {
                if (chan[i] < chan[j]) {
                    tam = chan[i];
                    chan[i] = chan[j];
                    chan[j] = tam;
                }
            }
        }
        return chan;
    }

    public static int[] sapXepleTang(int[] number) {
        int tam;
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 != 0) {
                count++;
            }
        }
        int[] le = new int[count];
        int index = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 != 0) {
                le[index++] = number[i];
            }
        }
        for (int i = 0; i < le.length; i++) {
            for (int j = i + 1; j < le.length; j++) {
                if (le[i] > le[j]) {
                    tam = le[i];
                    le[i] = le[j];
                    le[j] = tam;
                }
            }
        }
        return le;
    }

    public static void main(String[] args) {
        System.out.println("Nhập số phần tử: ");
        int n = new Scanner(System.in).nextInt();
        int[] number = new int[n];
        System.out.println("Nhập dãy số: ");
        for (int i = 0; i < n; i++) {
            number[i] = new Scanner(System.in).nextInt();
        }
        System.out.print("Dãy số đã nhập: ");
        for (int i = 0; i < n; i++) {
            System.out.print(number[i] + " ");
        }

        tongSo(number);

        System.out.print("Số nguyên tố: ");
        for (int i = 0; i < number.length; i++) {
            if (soNguyenTo(number[i])) {
                System.out.print(number[i] + " ");
            }
        }

        int[] sxChanGiam = {};
        sxChanGiam = sapXepChanGiam(number);
        System.out.println("\nDãy số chẵn giảm dần: " + Arrays.toString(sxChanGiam));
        int[] sxLeTang = {};
        sxLeTang = sapXepleTang(number);
        System.out.println("Dãy số lẻ tăng dần: " + Arrays.toString(sxLeTang));
    }
}
