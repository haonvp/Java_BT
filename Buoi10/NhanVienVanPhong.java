import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien {
    private int soNgayLamViec;

    public NhanVienVanPhong() {
    }

    public NhanVienVanPhong(String maNV, String hoTen, int tuoi, double luongCoBan, int soNgayLamViec) {
        super(maNV, hoTen, tuoi, luongCoBan);
        this.soNgayLamViec = soNgayLamViec;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + soNgayLamViec * 100000;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhập số ngày làm việc: ");
        soNgayLamViec = sc.nextInt();
    }
}
