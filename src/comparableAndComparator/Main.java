package comparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

import static comparableAndComparator.Employee.ageCamparator;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new Employee(1, "Mikey", 25, 1000);
        employees[1] = new Employee(20, "Arun", 32, 2000);
        employees[2] = new Employee(50, "Washington", 29, 5000);
        employees[3] = new Employee(1, "Joe", 18, 5000);

        Arrays.sort(employees);
        System.out.println("Default Sorting of Employess list:\n" + Arrays.toString(employees));
        Arrays.sort(employees, Employee.salaryCamparator);
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees, Employee.nameCamparator);
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees, ageCamparator);
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees, new EmployeeCamparatorByIdAndName());
        System.out.println(Arrays.toString(employees));
    }


}
