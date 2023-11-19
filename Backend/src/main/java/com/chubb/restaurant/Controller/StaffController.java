package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.Staff;
import com.chubb.restaurant.Service.ManagerService;
import com.chubb.restaurant.Service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping
    public Staff addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }
    @GetMapping("")
    public List<Staff> findAllStaff(){
        return staffService.findAllStaff();
    }
    @GetMapping("/{staffId}")
    public Staff findStaffById(@PathVariable String staffId)
    {
        return staffService.findStaffById(staffId);
    }
    @GetMapping("/email/{staffEmail}")
    public List<Staff> findStaffByEmail(@PathVariable String staffEmail){
        return staffService.findStaffByEmail(staffEmail);
    }
    @GetMapping("/email/{staffEmail}/password/{staffPassword}")
    public Staff findStaffByEmailAndPassword(@PathVariable String staffEmail,@PathVariable String staffPassword){
        return staffService.findStaffByEmailAndPassword(staffEmail,staffPassword);
    }
    @GetMapping("/name/{staffName}")
    public List<Staff> findStaffByName(@PathVariable String staffName){
        return staffService.findStaffByName(staffName);
    }
    @GetMapping("/shift/{shift}")
    public List<Staff> findStaffByShift(@PathVariable String shift){
        return staffService.findStaffByShift(shift);
    }
    @GetMapping("/rating/{rating}")
    public List<Staff> findStaffByRating(@PathVariable String rating){
        return staffService.findStaffByRating(rating);
    }
    @GetMapping("/status/{status}")
    public List<Staff> findStaffByStatus(@PathVariable String status){
        return staffService.findStaffByStatus(status);
    }
    @GetMapping("/salary/{salary}")
    public List<Staff> findStaffBySalary(@PathVariable String salary){
        return staffService.findStaffBySalary(salary);
    }
    @GetMapping("/shift/{shift}/status/{status}")
    public List<Staff> findStaffByShiftAndStatus(@PathVariable String shift,@PathVariable String status){
        return staffService.findStaffByShiftAndStatus(shift,status);
    }
    @PutMapping
    public Staff updateStaff(@RequestBody Staff staff){
        return staffService.updateStaff(staff);
    }
    @DeleteMapping("/{staffId}")
    public String deleteStaff(@PathVariable String staffId){
        return staffService.deleteStaff(staffId);
    }
}
