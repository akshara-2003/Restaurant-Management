package com.chubb.restaurant.Service;


import com.chubb.restaurant.Model.Staff;
import com.chubb.restaurant.Repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;
    public Staff addStaff(Staff staff){
        return repository.save(staff);
    }
    public List<Staff> findAllStaff(){
        return repository.findAll();
    }
    public Staff findStaffById(String staffId)
    {
        return repository.findById(staffId).get();

    }
    public List<Staff> findStaffByEmail(String staffEmail){
        return repository.findByStaffEmail(staffEmail);
    }
    public Staff findStaffByEmailAndPassword(String staffEmail,String staffPassword){
        return repository.findByStaffEmailAndStaffPassword(staffEmail,staffPassword);
    }
    public List<Staff> findStaffByName(String staffName){
        return repository.findByStaffName(staffName);
    }
    public List<Staff> findStaffByShift(String shift){
        return repository.findByShift(shift);
    }
    public List<Staff> findStaffByRating(String rating){
        return repository.findByStaffName(rating);
    }
    public List<Staff> findStaffByStatus(String status){
        return repository.findByStatus(status);
    }
    public List<Staff> findStaffBySalary(String salary){
        return repository.findBySalary(salary);
    }
    public List<Staff> findStaffByShiftAndStatus(String shift,String status){
        return repository.findByShiftAndStatus(shift,status);
    }
    public Staff updateStaff(Staff staff){
        Staff oldstaff =repository.findById(staff.getStaffId()).get();
        oldstaff.setStaffEmail(staff.getStaffEmail());
        oldstaff.setStaffPassword(staff.getStaffPassword());
        oldstaff.setStaffName(staff.getStaffName());
        oldstaff.setSalary(staff.getSalary());
        oldstaff.setRating(staff.getRating());
        oldstaff.setShift(staff.getShift());
        oldstaff.setStatus(staff.getStatus());
        return repository.save(oldstaff);
    }
    public String deleteStaff(String staffId){
        repository.deleteById(staffId);
        return staffId +"staff deleted";
    }
}
