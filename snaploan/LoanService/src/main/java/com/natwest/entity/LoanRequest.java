package com.natwest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.ArrayList;


@Entity
@Table(name = "LoanRequestTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoanRequest {

    @Id
    @Column(name = "Serial No.")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long requestedId;


    @NotBlank
    @Size(min = 3, max = 10, message = "username should be 3 to 10 characters")
    private String userName;


    @Column(unique = true)
    private String email;


    @Range(min = 100000, max = 1000000, message = "Loan amount should be between 100000 and 1000000")
    private Double loanAmount;


    @Range(min = 300, max = 900, message = "You have entered wrong cibil score. Enter between 300 to 900")
    private int cibilScore;


    @Range(min = 1, max = 7, message = "You have entered incorrect time span. Enter time span between 1 to 7 years")
    private int timeSpan;


    @Column(unique = true)
    private String aadharNo;


    private ArrayList<Double> userSalary;


    @NotBlank
    private String maritalStatus;


    @NotBlank
    private String occupation;


    @Min( value = 50000, message = "Minimum income to apply for loan is 50000")
    private BigDecimal income;


    @NotBlank
    private String address;


    private String status;


}
