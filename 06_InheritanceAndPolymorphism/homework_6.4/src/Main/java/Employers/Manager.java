package Employers;

import Company.Company;

public class Manager extends Staff{

    public Manager(long salary){
        setSalary(salary);
    }

    public Manager(long salary, Company company){
        setSalary(salary);
        company.hire(this);
    }

    private static int generateEarnedMoney(){
        return (int) ((Math.random() * (140000 - 115000)) + 115000);
    }

    public static Manager generateManager(){
        long fixedSalary = (long) ((Math.random() * (150000 - MINIMAL_SALARY)) + MINIMAL_SALARY);
        long bonusSalary = (long) (generateEarnedMoney() * 0.05);
        return new Manager(fixedSalary + bonusSalary);
    }
}
