package reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reservationapp.entity.Route;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {


    private long id;

    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;

   // private RouteDto route;

   // private List<SubRouteDto> subRoutes;
}
