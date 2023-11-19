package com.chubb.restaurant.Service;


import com.chubb.restaurant.Model.Manager;
import com.chubb.restaurant.Repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository repository;
    public Manager addManger(Manager manager){
        return repository.save(manager);
    }
    public List<Manager> findAllManagers(){
        return repository.findAll();
    }
    public Manager findManagerById(String managerId)
    {
        return repository.findById(managerId).get();

    }
    public List<Manager> findManagerByManagerEmail(String managerEmail){
        return repository.findByManagerEmail(managerEmail);
    }
    public Manager findManagerByManagerEmailAndManagerPassword(String managerEmail,String managerPassword){
        return repository.findByManagerEmailAndManagerPassword(managerEmail,managerPassword);
    }
    public Manager updateManager(Manager manager){
        Manager oldmanager =repository.findById(manager.getManagerId()).get();
        oldmanager.setManagerEmail(manager.getManagerEmail());
        oldmanager.setManagerPassword(manager.getManagerPassword());
        return repository.save(oldmanager);
    }
    public String deleteManager(String managerId)
    {
        repository.deleteById(managerId);
        return managerId +"manager deleted";
    }
    }
