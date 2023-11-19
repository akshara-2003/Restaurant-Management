package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingDetailsRepository extends MongoRepository<BookingDetails,String> {

}
