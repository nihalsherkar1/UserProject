package com.user.entity;

import jakarta.persistence.*;



@NamedStoredProcedureQueries(
        {
                @NamedStoredProcedureQuery(
                        name = "User.getUsersByDepartment",
                        procedureName = "GetUsersByDepartment",
                        parameters = {
                                @StoredProcedureParameter(name = "dept", type = String.class  ,mode = ParameterMode.IN)
                        },
                        resultClasses = User.class
                ),
                @NamedStoredProcedureQuery(
                        name = "User.getAllUsers",
                        procedureName = "GetAllUsers",

                        resultClasses = User.class
                )
        }
)

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String salary;
    private String department;

    public User() {
    }

    public User(Integer id, String userName, String salary, String department) {
        this.id = id;
        this.userName = userName;
        this.salary = salary;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", salary='" + salary + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
