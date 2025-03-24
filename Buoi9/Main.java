import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm học viên mới");
            System.out.println("2. Xem thông tin học viên");
            System.out.println("0. Thoát");

            int choose;
            try {
                System.out.print("Chức năng: ");
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Chọn chức năng không hợp lệ !");
                continue;
            }

            switch (choose) {
                case 1:
                    Student st = new Student(0, "");
                    st.inputInfo();
                    System.out.println("Thêm học viên mới thành công !");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }
}
