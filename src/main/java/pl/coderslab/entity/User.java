package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
    private boolean enabled = true;
    @Enumerated(EnumType.STRING)
    private UserType type;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = hashPassword(password);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(password));
        return String.format("%032x", new BigInteger(1, md5.digest()));
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
}
