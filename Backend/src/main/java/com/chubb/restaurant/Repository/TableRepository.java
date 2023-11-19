package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public interface TableRepository extends MongoRepository<Table,String> {
    List<Table> findByBookingDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Table> findByBookingDateTime(LocalDateTime bookingDateTime);
}
