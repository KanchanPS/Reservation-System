package reservationapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

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
    @Column(name="bus_id", unique= true, nullable = false)
    private long busId;


//    @OneToOne
//    @JoinColumn(name ="bus_id",referencedColumnName = "id")
//    private Bus bus;
//
//   @OneToMany(mappedBy = "route",fetch=FetchType.LAZY)
//    private List<SubRoute> subRoutes;
//



    // public long BusId;

}
