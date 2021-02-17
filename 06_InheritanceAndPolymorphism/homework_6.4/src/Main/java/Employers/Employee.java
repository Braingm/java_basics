package Employers;

import Company.Company;

public interface Employee {

    long getSalary();

    void setSalary(long salary);

    Company getCompany();

    void setCompany(Company company);

    default int compareTo(Employee o){
        return Long.compare(this.getSalary(), o.getSalary());
    }
}
