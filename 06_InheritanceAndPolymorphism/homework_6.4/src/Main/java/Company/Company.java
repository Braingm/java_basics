package Company;

import Employers.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employers = new ArrayList<>();
    private long yearIncome = 0;

    public boolean hire(Employee employee){
        return employers.add(employee);
    }

    public boolean hire(List<Employee> employers){
        return this.employers.addAll(employers);
    }

    public boolean fire(Employee employee){
        if (employers.remove(employee)){
           employee.getFired();
           return true;
        }
        return false;
    }

    public long getIncome(){
        return yearIncome;
    }
    protected void setYearIncome(long yearIncome){
        this.yearIncome = yearIncome;
    }

    protected List<Employee> getTopSalaryStaff(int count){
        employers.sort(Employee::compareTo);
        return employers.subList(employers.size() - (count + 1),employers.size()-1);
    }

    protected List<Employee> getLowestSalaryStaff(int count){
        employers.sort(Employee::compareTo);
        return employers.subList(0, count-1);
    }

}
