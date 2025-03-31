import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyImpl implements IQuanLy {
    private List<NhanVien> dsNhanVien = new ArrayList<>();

    @Override
    public void khoiTaoNhanVienMacDinh() {
        dsNhanVien.add(new NhanVienVanPhong("NV001", "Nguyễn Văn A", 30, 5000000, 20));
        dsNhanVien.add(new KySu("KS002", "Trần Thị B", 28, 7000000, "Công nghệ thông tin"));
        dsNhanVien.add(new QuanLy("QL003", "Lê Quang C", 35, 10000000, 1.50));
    }

    @Override
    public void themNhanVien() {
        NhanVien nv = null;
        Scanner sc = new Scanner(System.in);
        int loai;
        System.out.println("Chọn loại nhân viên ( 1: Nhân viên văn phòng - 2: Kỹ sư - 3: Quản lý");
        while (true) {
            if (sc.hasNextInt()) {
                loai = sc.nextInt();
                sc.nextLine();
                if (loai >= 1 && loai <= 3) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
        }

        switch (loai) {
            case 1:
                nv = new NhanVienVanPhong();
                break;
            case 2:
                nv = new KySu();
                break;
            case 3:
                nv = new QuanLy();
                break;
        }

        while (true) {
            nv.nhapThongTin(sc);
            if (!checkNhanVien(nv.maNV)) {
                System.out.println("Vui lòng nhập lại");
            } else {
                break;
            }
        }

        dsNhanVien.add(nv);
    }

    public boolean checkNhanVien(String maNVIp) {
        try {
            for (NhanVien nv : dsNhanVien) {
                if (nv.maNV.equalsIgnoreCase(maNVIp)) {
                    throw new EmployeeException("Mã nhân viên " + maNVIp + " đã tồn tại !!!");
                }
            }
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void hienThiDanhSach() {
        if (dsNhanVien.isEmpty()) {
            System.out.println("Không có nhân viên nào trong danh sách !");
            return;
        }
        for (NhanVien nv : dsNhanVien) {
            nv.hienThiThongTin();
            System.out.println();
        }
    }

    @Override
    public double tinhTongLuong() {
        double tongLuong = 0;
        for (NhanVien nv : dsNhanVien) {
            tongLuong += nv.tinhLuong();
        }
        return tongLuong;
    }

    @Override
    public void timLuongCaoNhat() {
        dsNhanVien.stream().max(Comparator.comparing(NhanVien::tinhLuong)).ifPresent(NhanVien::hienThiThongTin);
    }

    @Override
    public void timTheoMaNV(String maNV) {
        dsNhanVien.stream().filter(nv -> nv.maNV.equalsIgnoreCase(maNV)).findFirst().ifPresentOrElse(NhanVien::hienThiThongTin,
                () -> System.out.println("Không tìm thấy nhân viên có mã: " + maNV));
    }

    @Override
    public void sapXepTheoTen() {
        dsNhanVien.sort(Comparator.comparing(NhanVien::getHoTen));
        hienThiDanhSach();
    }

    @Override
    public void sapXepTheoLuongGiamDan() {
        dsNhanVien.sort(Comparator.comparing(NhanVien::getTinhLuong).reversed());
        hienThiDanhSach();
    }
}
