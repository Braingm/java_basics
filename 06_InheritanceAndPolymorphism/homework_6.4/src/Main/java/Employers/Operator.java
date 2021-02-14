package Employers;

import Company.Company;

public class Operator extends Staff {

    public Operator(long salary){
        setSalary(salary);
    }

    public Operator(long salary, Company company){
        setSalary(salary);
        company.hire(this);
    }

    public static Operator generateOperator(){
        long salary = (long) ((Math.random() * (120000 - MINIMAL_SALARY)) + MINIMAL_SALARY);
        return new Operator(salary);
    }
 }
