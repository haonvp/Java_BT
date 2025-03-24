import java.util.Scanner;

public class Student extends Person implements RegisCourse {
    private String[] course;
    private int sizeCourse;
    private String[] courseList = {"Math", "English", "History", "Science"};

    public Student(int id, String name) {
        super(id, name);
        this.course = new String[10];
        this.sizeCourse = 0;
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập ID học viên: ");
                this.id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID phải là số nguyên ! Xin nhập lại.");
            }
        }

        System.out.print("Nhập tên học viên: ");
        this.name = sc.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.println("Học viên ID: " + id + ", Tên: " + name);
        System.out.println("Môn học đã đăng ký: ");
        if (sizeCourse == 0) {
            System.out.println("Chưa đăng ký môn học nào.");
        } else {
            for (int i = 0; i < sizeCourse; i++) {
                System.out.println("- " + course[i]);
            }
            System.out.println();
        }
    }

    private boolean checkValueCourse(String courseName) {
        for (String course : courseList) {
            if (course.equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerCourse(String courseName) throws RegisterException {
        if (!checkValueCourse(courseName)) {
            throw new IllegalStateException("Môn học " + courseName + " không hợp lệ (Math, English, History, Science).");
        }

        for (int i = 0; i < sizeCourse; i++) {
            if (course[i].equalsIgnoreCase(courseName)) {
                throw new RegisterException(courseName);
            }
        }

        if (sizeCourse == course.length) {
            String[] newCourse = new String[course.length * 2];
            for (int i = 0; i < course.length; i++) {
                newCourse[i] = course[i];
            }
            course = newCourse;
        }

        course[sizeCourse] = courseName;
        sizeCourse++;
        System.out.println("Đăng ký môn học " + courseName + " thành công.");
    }
}
