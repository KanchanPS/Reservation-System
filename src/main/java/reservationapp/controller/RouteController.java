package reservationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservationapp.entity.Bus;
import reservationapp.entity.Route;
import reservationapp.repository.RouteRepository;
import reservationapp.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteService routeService;
    @PostMapping("/{busId}")
    public ResponseEntity<Route>addRoute(@PathVariable long busId, @RequestBody Route route){
         Route route1 = routeService.createRoute(busId, route);
         return new ResponseEntity<>(route1, HttpStatus.CREATED);

    }
    @GetMapping
    public List<Bus> SearchBuses(@RequestParam String fromLocation ,
                               @RequestParam String toLocation,
                               @RequestParam String fromDate){
        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        System.out.println(routes);

        return null;

    }
}
