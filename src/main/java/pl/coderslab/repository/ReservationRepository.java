package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Guest;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.User;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {


    @Query("select r from Reservation r where r.dateFrom = :dateFrom")
    List<Reservation> findByDatesFrom(@Param("dateFrom")Date dateFrom);


    @Query("select r from Reservation r where r.dateTo = :dateTo")
    List<Reservation> findByDatesTo(@Param("dateTo") Date dateTo);

//    @Query("select r from Reservation r where r.guest = :guest")
//    List<Reservation> findByGuest(@Param("guest") Guest guest);

    Reservation findFirstByGuestOrderByDateFrom(Guest guest);


}
