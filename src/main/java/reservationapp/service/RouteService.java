package reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservationapp.entity.Bus;
import reservationapp.entity.Route;
import reservationapp.exception.ResourceNotFound;
import reservationapp.repository.BusRepository;
import reservationapp.repository.RouteRepository;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;


    public Route createRoute(long busId,Route route){

         Bus b =busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not added")
        );


         Route r = routeRepository.findByBusId(route.getBusId());

        if(r!=null){
             throw new ResourceNotFound("Route was already added");
         }
         
        if(r==null){
            routeRepository.save(route);
            return route;
        }
        return null;
    }
}
