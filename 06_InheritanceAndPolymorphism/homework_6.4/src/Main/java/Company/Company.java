package Company;

import Employers.Employee;
import Employers.Staff;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Company {
    private List<Employee> employers = new ArrayList<>();
    private long yearIncome = 0;

    public void hire(Employee employee) {
        employers.add(employee);
        employee.setCompany(this);
    }

    public void hire(List<Employee> employers) {
        for (Employee e : employers){
            this.employers.add(e);
            e.setCompany(this);
        }
    }

    public boolean fire(Staff employee) {
        if (employers.remove(employee)) {
            employee.getFired();
            return true;
        }
        return false;
    }

    public long getIncome() {
        return yearIncome;
    }

    public void setYearIncome(long yearIncome) {
        this.yearIncome = yearIncome;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        employers.sort(Employee::compareTo);
        return new ArrayList<>(employers.subList(employers.size() - (count + 1), employers.size() - 1));
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        employers.sort(Employee::compareTo);
        return new ArrayList<>(employers.subList(0, count - 1));
    }

    public long generateIncome(){
        long result =(long) (random() * 100_000_000);
         setYearIncome(result);
        return result;
    }

}
