import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###");
        IQuanLy ql = new QuanLyImpl();
        ql.khoiTaoNhanVienMacDinh();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n***QUẢN LÝ NHÂN VIÊN***");
            System.out.println("1 Thêm nhân viên");
            System.out.println("2 Danh sách nhân viên");
            System.out.println("3 Tổng lương nhân viên");
            System.out.println("4 Lương nhân viên cao nhất");
            System.out.println("5 Tìm kiếm nhân viên");
            System.out.println("6 Danh sách nhân viên sắp xếp theo tên thứ tự từ A -> Z");
            System.out.println("7 Danh sách nhân viên sắp xếp theo lương giảm dần");
            System.out.println("0 Thoát chương trình");
            System.out.print("Chọn: ");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    System.out.println("\n==========NHẬP THÔNG TIN NHÂN VIÊN==========");
                    ql.themNhanVien();
                    break;
                case 2:
                    System.out.println("\n==========THÔNG TIN NHÂN VIÊN==========");
                    ql.hienThiDanhSach();
                    break;
                case 3:
                    System.out.print("\n==========TỔNG LƯƠNG PHẢI TRẢ CHO NHÂN VIÊN==========");
                    System.out.println("\nSố tiền: " + df.format(ql.tinhTongLuong()));
                    break;
                case 4:
                    System.out.println("\n==========NHÂN VIÊN CÓ LƯƠNG CAO NHẤT==========");
                    ql.timLuongCaoNhat();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n==========TÌM KIẾM NHÂN VIÊN==========");
                    System.out.print("- Nhập mã nhân viên cần tìm: ");
                    String maNV = sc.nextLine();
                    ql.timTheoMaNV(maNV);
                    break;
                case 6:
                    System.out.println("\n==========DANH SÁCH NHÂN VIÊN XẾP THEO TÊN TỪ A -> Z==========");
                    ql.sapXepTheoTen();
                    break;
                case 7:
                    System.out.println("\n==========DANH SÁCH NHÂN VIÊN XẾP THEO LƯƠNG GIẢM DẦN==========");
                    ql.sapXepTheoLuongGiamDan();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
