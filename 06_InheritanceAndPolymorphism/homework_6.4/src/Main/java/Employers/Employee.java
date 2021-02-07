package Employers;

import Company.Company;

public abstract class Employee implements Comparable {
    protected long salary = 0;
    public Company company;
    public boolean isFree;

    public long getSalary(){
        return salary;
    }
    public void setSalary(long salary){
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
        isFree = false;
    }

    public void getFired(){
        this.company = null;
        isFree = true;
    }

    int compareTo(Employee o) {
        return Long.compare(this.getSalary(), o.getSalary());
    }
}
