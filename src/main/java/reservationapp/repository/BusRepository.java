package reservationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservationapp.entity.Bus;

public interface BusRepository extends JpaRepository<Bus ,Long> {
}
