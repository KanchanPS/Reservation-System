package reservationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reservationapp.entity.Bus;
import reservationapp.entity.Route;
import reservationapp.entity.SubRoute;
import reservationapp.payload.BusDto;
import reservationapp.payload.SearchListOfBusesDto;
import reservationapp.repository.BusRepository;
import reservationapp.repository.RouteRepository;
import reservationapp.repository.SubRouteRepository;
import reservationapp.service.BusService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;

    @Autowired
    private RouteRepository routeRepository;

    @PostMapping
    public ResponseEntity<String> addBus(@RequestBody BusDto busDto) // throws Exception
    {
        busService.addBus(busDto);
        return new ResponseEntity<>("Bus details added", HttpStatus.CREATED);

    }
    //http://localhost:8080/api/v1/bus?fromLocation=&toLocation&fromDate
@GetMapping
public List<?> getAllBuss(
        @RequestParam String fromLocation,
        @RequestParam String toLocation,
        @RequestParam String fromDate) {

    List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
    List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);

    //  List<Bus> buses = new ArrayList<>();
    List<SearchListOfBusesDto> buses = new ArrayList<>();

    if (routes != null) {

        for (Route route : routes) {
            Bus bus = busRepository.findById(route.getBusId()).get();
            // buses.add(bus);
            SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
            buses.add(searchListOfBusesDto);
        }
        return buses;
    }

        if (subRoutes != null) {

            for (SubRoute route : subRoutes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
                buses.add(searchListOfBusesDto);
            }
            return buses;
        }

        return  null;

    }
     SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus, Route route) {
        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getId());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());
        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusesDto.setFromDate(route.getToDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setToTime(route.getToTime());
        return  searchListOfBusesDto;
    }



    SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus, SubRoute route) {
        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getId());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());
        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusesDto.setFromDate(route.getToDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setToTime(route.getToTime());
        return  searchListOfBusesDto;


    }

    }

