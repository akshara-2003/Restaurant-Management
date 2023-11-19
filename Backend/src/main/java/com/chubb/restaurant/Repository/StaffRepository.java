package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.Staff;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StaffRepository extends MongoRepository<Staff, String> {
    List<Staff> findByStaffEmail(String staffEmail);

    Staff findByStaffEmailAndStaffPassword(String staffEmail, String staffPassword);

    List<Staff> findByStaffName(String staffName);

    List<Staff> findByShift(String shift);

    List<Staff> findByStatus(String status);

    List<Staff> findBySalary(String salary);

    List<Staff> findByShiftAndStatus(String shift, String status);
}
