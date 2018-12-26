package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Occupants;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.RoomType;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    //    @Query("SELECT r FROM Room r LEFT JOIN r.reservations re WHERE r.type = ?1 AND r.occupants = ?2" +
//            " AND NOT (re.dateTo > ?3 OR re.dateFrom < ?4)"
//            )



    @Query("SELECT DISTINCT r FROM Room r LEFT JOIN r.reservations re WHERE r.type = ?1 AND r.occupants = ?2" +
            " AND (re.id IS NULL OR (" +
            " (" +
            " SELECT COUNT(r) FROM Room r LEFT JOIN r.reservations re " +
            " WHERE (?3 <= re.dateTo AND ?4 >= re.dateFrom)" +
            " ) = 0" +
            " ))"
    )
    List<Room> getAvailableRooms(RoomType type, Occupants occupants
            , Date dateFrom, Date dateTo

    );


    @Query("SELECT DISTINCT r FROM Room r LEFT JOIN r.reservations re WHERE  (re.id IS NULL OR (" +
            " (" +
            " SELECT COUNT(r) FROM Room r LEFT JOIN r.reservations re " +
            " WHERE (?1 <= re.dateTo AND ?2 >= re.dateFrom)" +
            " ) = 0" +
            " ))"
    )
    List<Room> getOtherAvailableRooms(
            Date dateFrom, Date dateTo

    );




/*
    SELECT DISTINCT r.id FROM room r LEFT JOIN reservation re
    ON r.id=re.room_id
    WHERE re.id IS NULL OR (
   (
   SELECT COUNT(*) FROM room r JOIN reservation re ON r.id=re.room_id
    WHERE ('2018-07-24' <= re.dateTo AND '2018-07-27' >= re.dateFrom)
   ) = 0
           );

*/
Room findByNumber (long number);


}

