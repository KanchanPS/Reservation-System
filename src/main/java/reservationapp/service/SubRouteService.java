package reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservationapp.entity.SubRoute;
import reservationapp.repository.SubRouteRepository;

@Service
public class SubRouteService {
    @Autowired
    private SubRouteRepository subRouteRepository;


    public SubRoute saveSubRoute(SubRoute subRoute) {

        return subRouteRepository.save(subRoute);
    }
}

