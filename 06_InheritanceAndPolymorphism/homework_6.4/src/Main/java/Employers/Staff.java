package Employers;

import Company.Company;

public abstract class Staff implements Employee {

    public boolean isFree = true;
    protected long salary = 0;
    private Company company;

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        if (!isFree) {
            this.company.fire(this);
        }
        this.company = company;
        isFree = false;
    }

    public void getFired() {
        company.fire(this);
        isFree = true;
    }

}
