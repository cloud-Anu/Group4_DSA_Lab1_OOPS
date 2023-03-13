package service;
import java.security.SecureRandom;
import java.util.Random;
import employee.Employee;

public class CredentialService {
    private static final String COMPANY_NAME = "abc.com";
    public static final String[] DEPARTMENTS = {"Technical", "Admin", "Human Resource", "Legal"};
    private static final int PASSWORD_LENGTH = 8;
    private static final String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

    private static final Random RANDOM = new SecureRandom();

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = RANDOM.nextInt(PASSWORD_CHARS.length());
            password.append(PASSWORD_CHARS.charAt(index));
        }
        return password.toString();
    }

    public String generateEmailAddress(Employee employee, String department) {
        String firstName = employee.getFirstName().toLowerCase();
        String lastName = employee.getLastName().toLowerCase();
        return firstName + lastName + "@" + department.toLowerCase() + "." + COMPANY_NAME;
    }

    public void showCredentials(Employee employee, String department) {
        String email = generateEmailAddress(employee, department);
        String password = generatePassword();
        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + email);
        System.out.println("Password ---> " + password);
    }
}
