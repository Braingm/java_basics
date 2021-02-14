package Employers;

import Company.Company;

public interface Employee {
    int MINIMAL_SALARY = 18000;

    long getSalary();

    void setSalary(long salary);

    Company getCompany();

    void setCompany(Company company);

    default int compareTo(Employee o){
        if (this.getSalary() > o.getSalary())
            return 1;
        if (this.getSalary() < o.getSalary())
            return -1;
        return 0;
    }
}
