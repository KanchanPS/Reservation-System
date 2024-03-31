package reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reservationapp.entity.Route;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SubRouteDto {

    private long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;


    private Route route;
}
