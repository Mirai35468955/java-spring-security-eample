package io.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="dep_id")
    private int departmentId;


    // define constructors

    public Employee() {

    }

    public Employee(int id, String name, int departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }


//    public Employeenew(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }

    // define getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    // define tostring

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", departmentId=" + departmentId + "]";
    }
}
