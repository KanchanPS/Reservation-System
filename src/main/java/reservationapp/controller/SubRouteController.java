package reservationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reservationapp.entity.SubRoute;
import reservationapp.service.SubRouteService;

@RestController
@RequestMapping("/api/v3/subroute")
public class SubRouteController {

    @Autowired
    private SubRouteService subRouteService;

    @PostMapping
    public ResponseEntity<SubRoute> addSubRoute(@RequestBody SubRoute subRoute) {
        SubRoute savedSubRoute = subRouteService.saveSubRoute(subRoute);
        return new ResponseEntity<>(savedSubRoute, HttpStatus.CREATED);
    }
}
