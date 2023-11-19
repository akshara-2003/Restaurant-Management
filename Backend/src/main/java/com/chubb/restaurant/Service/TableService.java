package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.Table;
import com.chubb.restaurant.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {
    @Autowired
    private TableRepository repository;

    public List<Table> getAvailableTables(LocalDateTime startDateTime,LocalDateTime endDateTime){
        return repository.findByBookingDateTimeBetween(startDateTime,endDateTime);
    }

    public Table bookTable(Table reservation){
        int tableNumber = findNextAvailableTable(reservation.getBookingDateTime());
        reservation.setTableBooked(true);
        return repository.save(reservation);
    }

    public void  releaseTable(String reservationId){
        repository.deleteById(reservationId);
    }

    private int findNextAvailableTable(LocalDateTime bookingDateTime){
        List<Table> bookedTables = repository.findByBookingDateTime(bookingDateTime);

        for(int i=1;i<=100;i++){
            int j = i;
            boolean isTableAvailable = bookedTables.stream().noneMatch(reservation->reservation.getTableNumber()== j);
            if(isTableAvailable){
                return i;
            }
        }
        throw new RuntimeException("No available tables found");
    }
}
