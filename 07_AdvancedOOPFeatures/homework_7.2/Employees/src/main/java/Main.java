import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) throws Exception {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
         return staff.stream().filter(e -> e.getWorkStart().after(new Date(year-1900,Calendar.JANUARY,1)))
                .max(Comparator.comparing(Employee::getSalary)).get();
    }
}