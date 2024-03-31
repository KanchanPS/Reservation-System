package reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reservationapp.entity.Bus;
import reservationapp.entity.SubRoute;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;


    private Bus bus;


    private List<SubRoute> subRoutes;


    }

