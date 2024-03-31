package reservationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservationapp.entity.Bus;
import reservationapp.entity.Passenger;
import reservationapp.entity.Route;
import reservationapp.entity.SubRoute;
import reservationapp.repository.BusRepository;
import reservationapp.repository.PassengerRepository;
import reservationapp.repository.RouteRepository;
import reservationapp.repository.SubRouteRepository;
import reservationapp.util.EmailService;
import reservationapp.util.PdfTicketGeneratorService;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private PdfTicketGeneratorService pdfTicketGeneratorService;

    @Autowired
    private EmailService emailService;



    //http://localhost:8080/api/reservation?busId=1&routeId=1
    @PostMapping
    public ResponseEntity<String> bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
           // @RequestParam long SeatNumber,
            @RequestBody Passenger passenger

    ) {

        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        boolean subRouteIsPresent = false;

        Optional<Bus> byId = busRepository.findById(busId);

        if (byId.isPresent()) {
            busIsPresent = true;
            Bus bus = byId.get();
        }

        Optional<Route> byRouteId = routeRepository.findById(routeId);
        if (byRouteId.isPresent()) {
            routeIsPresent = true;

            Bus bus = byId.get();


        }
        Optional<SubRoute> subRouteId = subRouteRepository.findById(routeId);
        if (byRouteId.isPresent()) {
            subRouteIsPresent = true;

            Bus bus = byId.get();

        }

        if(busIsPresent&&routeIsPresent||busIsPresent&&subRouteIsPresent){

            Passenger p = new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setBusId(passenger.getBusId());
            p.setRouteId(passenger.getRouteId());
            p.setId(passenger.getId());
             Passenger savedPassenger = passengerRepository.save(p);
             byte[] pdfBytes = pdfTicketGeneratorService.generateTicket(savedPassenger, byRouteId.get().getFromLocation(), byRouteId.get().getToLocation()
                    , byRouteId.get().getFromDate());
emailService.sendEmailWithAttachment(passenger.getEmail(),"Booking Confirmed....","your Reservation +id"+savedPassenger.getId(),pdfBytes,"ticket");

        }
        return new ResponseEntity<>("done", HttpStatus.CREATED);

    }
}