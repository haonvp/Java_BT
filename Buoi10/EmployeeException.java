public class EmployeeException extends Exception {
    public EmployeeException(String message) {
        super(message);
    }

    public static void validateAge() throws EmployeeException {
        throw new EmployeeException("Tuổi không hợp lệ ! Tuổi phải là số nguyên dương !");
    }
}
