package Employers;

import Company.Company;

public abstract class Staff implements Employee {
    protected static int MINIMAL_SALARY = 18000;

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
            System.out.println("Ошибка найма");
            return;
        }
        this.company = company;
        isFree = false;
    }

    public void getFired() {
        company.fire(this);
        isFree = true;
    }

}
