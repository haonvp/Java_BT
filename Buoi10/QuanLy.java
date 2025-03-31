import java.util.Scanner;

public class QuanLy extends NhanVien {
    private double heSoChucVu;

    public QuanLy() {
    }

    public QuanLy(String maNV, String hoTen, int tuoi, double luongCoBan, double heSoChucVu) {
        super(maNV, hoTen, tuoi, luongCoBan);
        this.heSoChucVu = heSoChucVu;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoChucVu;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhập hệ số chức vụ: ");
        heSoChucVu = sc.nextDouble();
    }
}
