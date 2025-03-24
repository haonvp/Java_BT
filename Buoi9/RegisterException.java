public class RegisterException extends Exception {
    public RegisterException(String courseName) {
        super("Môn học " + courseName + "đã được đăng ký trước đó rồi !");
    }
}
