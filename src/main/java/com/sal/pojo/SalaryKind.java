package com.sal.pojo;

public class SalaryKind {
    private int salary_kind_id;
    private String salary_kind_name;

    public SalaryKind() {
    }

    public int getSalary_kind_id() {
        return salary_kind_id;
    }

    public void setSalary_kind_id(int salary_kind_id) {
        this.salary_kind_id = salary_kind_id;
    }

    public String getSalary_kind_name() {
        return salary_kind_name;
    }

    public void setSalary_kind_name(String salary_kind_name) {
        this.salary_kind_name = salary_kind_name;
    }

    @Override
    public String toString() {
        return "SalaryKind{" +
                "salary_kind_id=" + salary_kind_id +
                ", salary_kind_name='" + salary_kind_name + '\'' +
                '}';
    }
}
