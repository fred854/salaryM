package com.sal.pojo;

public class DepartmentSalary {
    Integer department_id;
    String department_name;
    Double avg_salary;

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Double getAvg_salary() {
        return avg_salary;
    }

    public void setAvg_salary(Double avg_salary) {
        this.avg_salary = avg_salary;
    }

    @Override
    public String toString() {
        return "DepartmentSalary{" +
                "department_name='" + department_name + '\'' +
                ", avg_salary=" + avg_salary +
                '}';
    }
}
