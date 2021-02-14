package Employers;

import Company.Company;

public class TopManager extends Staff{

    public TopManager(long salary){
        setSalary(salary);
    }

    public TopManager(long salary, Company company){
        setSalary(salary);
        company.hire(this);
    }

    @Override
    public long getSalary() {
        if (this.getCompany().getIncome() >= 10000000){
            return (long) (salary * 2.5);
        }
        return salary;
    }

    public static TopManager generateTopManager(){
        long salary = (long) ((Math.random() * (200000 - MINIMAL_SALARY)) + MINIMAL_SALARY);
        return new TopManager(salary);
    }
}
