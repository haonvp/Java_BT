import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected int tuoi;
    protected double luongCoBan;
    private static final DecimalFormat df = new DecimalFormat("#,###");

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, int tuoi, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luongCoBan = luongCoBan;
    }

    public abstract double tinhLuong();

    public void hienThiThongTin() {
        System.out.println("Mã nhân viên: " + maNV);
        System.out.println("Tên nhân viên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Lương cơ bản: " + df.format(luongCoBan) + " VNĐ");
        System.out.println("Tổng lãnh: " + df.format(tinhLuong()) + " VNĐ");
    }

    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        tuoi = sc.nextInt();
        System.out.print("Nhập lương cơ bản: ");
        luongCoBan = sc.nextDouble();
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getTinhLuong() {
        return tinhLuong();
    }
}
