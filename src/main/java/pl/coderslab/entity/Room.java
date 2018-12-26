package pl.coderslab.entity;



import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Occupants occupants;
    @NotNull
    @NumberFormat
    private Long roomPrice;
    @NotNull
    @NumberFormat
    private Long number;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Occupants getOccupants() {
        return occupants;
    }

    public void setOccupants(Occupants occupants) {
        this.occupants = occupants;
    }

    public Long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Long roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

//    @Override
//    public String toString() {
//        return "Room{" +
//                "id=" + id +
//                ", occupants=" + occupants +
//                ", RoomPrice=" + roomPrice +
//                ", number=" + number +
//                ", type=" + type +
//                '}';
//    }
}
