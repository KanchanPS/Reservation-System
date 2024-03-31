package reservationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import reservationapp.entity.Route;

import java.util.List;


    public interface RouteRepository extends JpaRepository<Route, Long> {
        Route findByBusId(long busId);
        List<Route> findByFromLocationAndToLocationAndFromDate(String fromLocation,String toLocation,String fromDate);

    }



