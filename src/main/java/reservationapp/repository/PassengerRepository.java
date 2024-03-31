package reservationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservationapp.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger ,Long> {

}


