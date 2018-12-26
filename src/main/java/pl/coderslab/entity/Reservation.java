package pl.coderslab.entity;


import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 //  cascadetypemerge
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Guest guest;
    @ManyToOne
    private Room room;
    @NotNull

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @NotNull

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    private Date created = new Date();
    private boolean cancelled;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }





}
