package com.sal.pojo;

public class Salary {
    private int salary_id;
    private int person_id;
    private int for_person_id;
    private int for_salary_kind_id;
    private double amount;
    private String year;
    private String month;
    private String person_name;
    private String salary_kind_name;
    private String department_name;
    private String position_name;

    public Salary() {
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(int salary_id) {
        this.salary_id = salary_id;
    }

    public int getFor_person_id() {
        return for_person_id;
    }

    public void setFor_person_id(int for_person_id) {
        this.for_person_id = for_person_id;
    }

    public int getFor_salary_kind_id() {
        return for_salary_kind_id;
    }

    public void setFor_salary_kind_id(int for_salary_kind_id) {
        this.for_salary_kind_id = for_salary_kind_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getSalary_kind_name() {
        return salary_kind_name;
    }

    public void setSalary_kind_name(String salary_kind_name) {
        this.salary_kind_name = salary_kind_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary_id=" + salary_id +
                ", for_person_id=" + for_person_id +
                ", for_salary_kind_id=" + for_salary_kind_id +
                ", amount=" + amount +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", person_name='" + person_name + '\'' +
                ", salary_kind_name='" + salary_kind_name + '\'' +
                '}';
    }

}
