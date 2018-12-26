package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.User;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {


    @Query("select r from Reservation r where r.dateFrom = ?1")
    List<Reservation> findByDatesFrom(Date dateFrom);


    @Query("select r from Reservation r where r.dateTo = ?1")
    List<Reservation> findByDatesTo(Date dateTo);


}
