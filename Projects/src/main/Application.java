package main;


import java.util.Scanner;
import employee.Employee;
import service.CredentialService;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the department from the following:");
        for (int i = 0; i < CredentialService.DEPARTMENTS.length; i++) {
            System.out.println((i + 1) + ". " + CredentialService.DEPARTMENTS[i]);
        }
        int departmentIndex = scanner.nextInt() - 1;
        String department = CredentialService.DEPARTMENTS[departmentIndex];

        
        String firstName = "Harshit";
        String lastName = "Choudary";
        
        Employee employee = new Employee(firstName, lastName);
        CredentialService credentialService = new CredentialService();
        credentialService.showCredentials(employee, department);
    }
}
