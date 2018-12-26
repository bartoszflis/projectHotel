package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Email
    @Column(nullable = false, length = 50)
    private String email;
    @NotBlank
    @Size(min = 3, message = "Minimum 3 znaki")
    private String firstName;
    @NotBlank
    @Size(min = 3, message = "Minimum 3 znaki")
    private String lastName;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations = new ArrayList<>();


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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
