
package reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservationapp.entity.Bus;
import reservationapp.payload.BusDto;
import reservationapp.repository.BusRepository;


@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
   // @Transactional
    public void addBus(BusDto busDto) {
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());
        bus.setId(busDto.getId());

        Bus savedBus = busRepository.save(bus);

    }

}

