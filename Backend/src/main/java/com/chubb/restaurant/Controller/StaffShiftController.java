package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Model.Staff;
import com.chubb.restaurant.Service.StaffShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/staff")

public class StaffShiftController {
    @Autowired
    private StaffShiftService service;
    @PutMapping("/editStaff/{staffId}")
    public ResponseEntity<?> updateItem(@PathVariable String staffId, @RequestBody Staff newStaff){
        return service.editShift(staffId,newStaff);
    }
}
