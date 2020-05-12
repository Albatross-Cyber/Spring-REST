package com.vojtechruzicka.springfoxexample.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@ApiModel(description = "Class representing a employee tracked by the application.")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    @ApiModelProperty(notes = "${employee.id}", example = "1", required = true, position = 0)
    private int id;

    @ApiModelProperty(notes = "${employee.firstname}", example = "John", required = true, position = 1)
    @Column(name="first_name")
    private String firstName;

    @ApiModelProperty(notes = "${employee.lastlame}", example = "Doe", required = true, position = 2)
    @Column(name="last_name")
    private String lastName;

    @ApiModelProperty(notes = "${employee.email}", example = "John.Doe@luv2code.com", required = true ,position = 3)
    @Column(name="email")
    private String email;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
