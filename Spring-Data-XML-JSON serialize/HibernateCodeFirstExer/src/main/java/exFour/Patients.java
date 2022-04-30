package exFour;

import exOne.BaseEntity;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "patients")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patients extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private Boolean medicalInsurance;


    public Patients() {
    }

    public Patients(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Lob
    @Column(length = 10000)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    @Column(name = "medical_insurance")
    public Boolean getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(Boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }
}
