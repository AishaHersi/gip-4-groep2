package be.ucll.gip4group2.Player;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    String identificationNumber;
    @NotNull
    String name;
    @NotNull
    String prename;
    @NotNull
    String email;
    @NotNull
    String phone;
    @NotNull
    String birthDate;
    @NotNull
    String gender;
    @NotNull
    String address;

    public String getIdentificationNumber() {
        return identificationNumber;
    }
    public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPreName() {
        return prename;
    }
    public void setPreName(String prename) {
        this.prename = prename;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate;}

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) { this.address = address;}

    public Person(){}

    public Person(String identificationNumber,
                  String name,
                  String prename,
                  String email,
                  String phone,
                  String birthDate,
                  String gender,
                  String address) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.prename = prename;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }
}
