package reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchListOfBusesDto {

    private Long BusId;

    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;


    private long RouteId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;

}