import Company.Company;
import Employers.Employee;
import Employers.Manager;
import Employers.Operator;
import Employers.TopManager;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company google = new Company();
        google.setYearIncome(google.generateIncome());
        generateTestedStaff(google);

        Company yandex = new Company();
        yandex.setYearIncome(yandex.generateIncome());
        generateTestedStaff(yandex);

        ArrayList<Employee> employeeList = google.getTopSalaryStaff(5);
        for (int i = employeeList.size(); i > 0; i--){
            System.out.println(employeeList.get(i-1).getSalary() + " руб.");
        }

    }

    private static void generateTestedStaff(Company company){
        company.hire(generateManagers());
        company.hire(generateOperators());
        company.hire(generateTopManagers());
        }

    private static List<Employee> generateOperators(){
        List<Employee> operatorList = new ArrayList<>();
        for (int i = 0; i < 180; i++){
            operatorList.add(Operator.generateOperator());
        }
        return operatorList;
    }

    private static List<Employee> generateManagers(){
        List<Employee> managerList = new ArrayList<>();
        for (int i = 0; i < 80 ; i++){
            managerList.add(Manager.generateManager());
        }
        return managerList;
    }

    private static List<Employee> generateTopManagers(){
        List<Employee> topManagerList= new ArrayList<>();
        for (int i = 0; i < 10; i++){
            topManagerList.add(TopManager.generateTopManager());
        }
        return topManagerList;
    }
}
