-- 1. Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS QL_SINHVIEN;

-- 2. Tạo bảng
USE ql_sinhvien;
CREATE TABLE IF NOT EXISTS SinhVien (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ho_ten VARCHAR(50) NOT NULL,
    ngay_sinh DATE,
    gioi_tinh VARCHAR(3),
    dia_chi VARCHAR(100),
    email VARCHAR(50) UNIQUE,
    diem_trung_binh DECIMAL(4,2)
);
CREATE TABLE IF NOT EXISTS MonHoc (
	id_mon INTEGER PRIMARY KEY AUTO_INCREMENT,
    ten_mon VARCHAR(50) NOT NULL,
    so_tin_chi INTEGER
);
CREATE TABLE IF NOT EXISTS DiemThi (
	id_diem INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_sinhvien INTEGER,
    id_mon INTEGER,
    FOREIGN KEY (id_sinhvien) REFERENCES SinhVien(id),
    FOREIGN KEY (id_mon) REFERENCES MonHoc(id_mon),
    diem DECIMAL(4,2)
);

-- 3. Thêm dữ liệu vào bảng
INSERT INTO SinhVien(ho_ten, ngay_sinh, gioi_tinh, dia_chi, email, diem_trung_binh) VALUES
('Nguyen Van A', '2002-03-15', 'Nam', '12 Lý Thường Kiệt, Q.10, TP.HCM', 'vana@gmail.com', 7.50),
('Tran Thi B', '2002-05-20', 'Nữ', '89 Nguyễn Trãi, Q.1, TP.HCM', 'thib@gmail.com', 8.20),
('Le Van C', '2001-11-10', 'Nam', '23 Lê Duẩn, Hải Châu, Đà Nẵng', 'vanc@gmail.com', 6.75),
('Pham Thi D', '2003-01-22', 'Nữ', '45 Trần Phú, TP. Nha Trang, Khánh Hòa', 'thid@gmail.com', 9.10),
('Hoang Van E', '2002-07-30', 'Nam', '101 Xô Viết Nghệ Tĩnh, Q. Bình Thạnh, TP.HCM', 'vane@gmail.com', 5.95);

INSERT INTO MonHoc(ten_mon, so_tin_chi) VALUES
('Toán cao cấp', 3),
('Lập trình C', 4),
('Cơ sở dữ liệu', 3);

INSERT INTO DiemThi(id_sinhvien, id_mon, diem) VALUES
(1, 1, 7.5),
(1, 2, 8.0),
(1, 3, 7.0),

(2, 1, 9.0),
(2, 2, 8.5),
(2, 3, 7.5),

(3, 1, 6.0),
(3, 2, 6.5),
(3, 3, 7.0),

(4, 1, 9.5),
(4, 2, 9.0),
(4, 3, 8.5),

(5, 1, 5.5),
(5, 2, 6.0),
(5, 3, 6.5);

-- 4. Cập nhật dữ liệu
-- Cập nhật điểm trung bình của một sinh viên trong bảng SinhVien
UPDATE SinhVien SET diem_trung_binh= 8.0 WHERE id = 1;

-- Cập nhật điểm thi của một sinh viên trong bảng DiemThi.
UPDATE DiemThi SET diem = 9.0 WHERE id_sinhvien = 1 AND id_mon = 2;

-- 5. Truy vấn
SELECT * FROM sinhvien;

SELECT * FROM monhoc;

-- Hiển thị tên sinh viên, môn học và điểm thi của sinh viên
SELECT sv.ho_ten, mh.ten_mon, dt.diem
FROM sinhvien sv
JOIN diemthi dt ON sv.id = dt.id_sinhvien
JOIN monhoc mh ON mh.id_mon = dt.id_mon;

-- Tìm tất cả các sinh viên có điểm trung bình lớn hơn 8.0
SELECT *
FROM sinhvien sv
WHERE sv.diem_trung_binh > 8.0;

-- Liệt kê các môn học mà sinh viên có điểm thi dưới 5.0
SELECT mh.ten_mon
FROM monhoc mh
JOIN diemthi dt ON mh.id_mon = dt.id_mon
WHERE dt.diem < 5.0;

-- Đếm số lượng sinh viên có điểm thi môn học trên 6.0
SELECT COUNT(*)
FROM sinhvien sv
JOIN diemthi dt ON dt.id_sinhvien = sv.id
WHERE dt.diem > 6.0;

-- 6. Sử dụng các toán tử và biểu thức so sánh
-- Tìm tất cả sinh viên có điểm trung bình từ 7.0 đến 8.5 và giới tính là "Nam".
SELECT *
FROM sinhvien
WHERE diem_trung_binh BETWEEN 7.0 AND 8.5
	AND gioi_tinh='Nam';

-- Liệt kê tất cả sinh viên có email chứa "gmail.com" hoặc "yahoo.com"
SELECT *
FROM sinhvien
WHERE email LIKE '%gmail.com%' OR email LIKE '%yahoo.com%';

-- Sử dụng toán tử AND/OR để tìm sinh viên có điểm trung bình lớn hơn 6.5 và có ít nhất một môn thi điểm dưới 5.0
SELECT sv.ho_ten, sv.diem_trung_binh, dt.diem
FROM sinhvien sv
JOIN diemthi dt ON sv.id = dt.id_sinhvien
WHERE sv.diem_trung_binh > 6.5 AND dt.diem < 5.0;

-- 7. Sử dụng GROUP BY và COUNT
-- Đếm số lượng sinh viên có điểm thi môn học lớn hơn 6.0, nhóm theo môn học.
SELECT mh.ten_mon, COUNT(dt.id_sinhvien) AS sl_sinhvien
FROM DiemThi dt
JOIN MonHoc mh ON dt.id_mon = mh.id_mon
WHERE dt.diem > 6.0
GROUP BY mh.ten_mon;

-- Tính số sinh viên thi lại (điểm dưới 5.0) cho từng môn học.
SELECT mh.ten_mon, COUNT(dt.id_sinhvien) AS so_sinhvien_thi_lai
FROM diemthi dt
JOIN monhoc mh ON dt.id_mon = mh.id_mon
WHERE dt.diem < 5.0
GROUP BY mh.ten_mon;
