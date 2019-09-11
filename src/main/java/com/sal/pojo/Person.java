package com.sal.pojo;

public class Person {
    private int person_id;
    private String person_name;
    private int for_department_id;
    private int for_position_id;
    private String department_name;
    private String position_name;

    public Person() {
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public int getFor_department_id() {
        return for_department_id;
    }

    public void setFor_department_id(int for_department_id) {
        this.for_department_id = for_department_id;
    }

    public int getFor_position_id() {
        return for_position_id;
    }

    public void setFor_position_id(int for_position_id) {
        this.for_position_id = for_position_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", person_name='" + person_name + '\'' +
                ", for_department_id=" + for_department_id +
                ", for_position_id=" + for_position_id +
                ", department='" + department_name + '\'' +
                ", position='" + position_name + '\'' +
                '}';
    }
}
