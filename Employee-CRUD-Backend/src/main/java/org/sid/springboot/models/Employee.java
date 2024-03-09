package org.sid.springboot.models;

import jakarta.persistence.*;
import lombok.*;
//Lambok pour creer constructeur & getters setters

@Data	
@AllArgsConstructor 
@NoArgsConstructor 

//Hibernate

@Entity
@Table(name="employees")

public class Employee {
	
@Id //clé primaire
@GeneratedValue(strategy=GenerationType.IDENTITY) //autoincrement
private long id ;

@Column(name="first_name")
private String firstname;

@Column(name="last_name")
private String lastname;

private String emailId;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}



}
