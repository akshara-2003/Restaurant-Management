package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.Manager;
import com.chubb.restaurant.Service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @PostMapping
    public Manager addManger(@RequestBody Manager manager){
        return managerService.addManger(manager);
    }
    @GetMapping("")
    public List<Manager> findAllManagers(){
        return managerService.findAllManagers();
    }
    @GetMapping("/{managerId}")
    public Manager findManagerById(@PathVariable String managerId)
    {
        return managerService.findManagerById(managerId);

    }
    @GetMapping("/email/{managerEmail}")
    public List<Manager> findManagerByEmail(@PathVariable String managerEmail){
        return managerService.findManagerByManagerEmail(managerEmail);
    }
    @GetMapping("/email/{managerEmail}/password/{password}")
    public Manager findManagerByEmailAndPassword(@PathVariable String managerEmail,@PathVariable String managerPassword){
        return managerService.findManagerByManagerEmailAndManagerPassword(managerEmail,managerPassword);
    }
    @PutMapping
    public Manager updateManager(@RequestBody Manager manager){
        return managerService.updateManager(manager);
    }
    @DeleteMapping("/{managerId}")
    public String deleteManager(@PathVariable String managerId)
    {
        return managerService.deleteManager(managerId);
    }
}
