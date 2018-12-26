package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    public Guest findFirstByEmail(String email);


}
