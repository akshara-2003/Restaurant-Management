package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Model.Staff;
import com.chubb.restaurant.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StaffShiftService {
    @Autowired
    public StaffRepository repository;

    public ResponseEntity<?> editShift(String staffId, Staff staff){
        Staff oldStaff = repository.findById(staffId).orElse(null);;
        if(oldStaff!=null) {
            oldStaff.setStaffName(staff.getStaffName());
            oldStaff.setSalary(staff.getSalary());
            oldStaff.setRating(staff.getRating());
            oldStaff.setShift(staff.getShift());
            repository.save(oldStaff);
            return ResponseEntity.ok(oldStaff);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
