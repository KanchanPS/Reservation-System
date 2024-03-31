package reservationapp.entity;

import javax.persistence.*;

import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    private long busId;

    @Column(name = "route_id", nullable = false)
    private long routeId;
}

//    @ManyToOne
//    @JoinColumn(name = "route_id")
//    private Route route;
//}
