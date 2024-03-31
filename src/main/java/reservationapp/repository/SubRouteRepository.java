package reservationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservationapp.entity.SubRoute;

import java.util.List;

public interface SubRouteRepository extends JpaRepository<SubRoute,Long> {
    List<SubRoute> findByFromLocationAndToLocationAndFromDate(String fromLocation,String ToLocation,String FromDate);
}
