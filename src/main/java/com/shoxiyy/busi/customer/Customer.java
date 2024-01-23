package com.shoxiyy.busi.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank
//    @NotEmpty(message = "First name cannot be empty.")
    private String firstName;
//    @NotBlank
//    @NotEmpty(message = "Last name cannot be empty.")
    private String lastName;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfCreation = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Customer leader;
    private URL practiceWebsite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfGrantedAccess;
    private String accessGrantedBy;
    private boolean accessGranted;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Customer getLeader() {
        return leader;
    }

    public void setLeader(Customer leader) {
        this.leader = leader;
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

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public URL getPracticeWebsite() {
        return practiceWebsite;
    }

    public void setPracticeWebsite(URL practiceWebsite) {
        this.practiceWebsite = practiceWebsite;
    }

    public Date getDateOfGrantedAccess() {
        return dateOfGrantedAccess;
    }

    public void setDateOfGrantedAccess(Date dateOfGrantedAccess) {
        this.dateOfGrantedAccess = dateOfGrantedAccess;
    }

    public String getAccessGrantedBy() {
        return accessGrantedBy;
    }

    public void setAccessGrantedBy(String accessGrantedBy) {
        this.accessGrantedBy = accessGrantedBy;
    }

    public boolean isAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(boolean accessGranted) {
        this.accessGranted = accessGranted;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}