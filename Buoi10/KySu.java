import java.util.Scanner;

public class KySu extends NhanVien {
    private String chuyenMon;

    public KySu() {
    }

    public KySu(String maNV, String hoTen, int tuoi, double luongCoBan, String chuyenMon) {
        super(maNV, hoTen, tuoi, luongCoBan);
        this.chuyenMon = chuyenMon;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + 2000000;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        sc.nextLine();
        System.out.print("Nhập chuyên môn: ");
        chuyenMon = sc.nextLine();
    }
}
