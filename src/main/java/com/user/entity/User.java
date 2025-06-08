package com.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String salary;
    private String department;


}
