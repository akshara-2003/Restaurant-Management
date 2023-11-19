package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.Table;
import com.chubb.restaurant.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/tableReservations")
@CrossOrigin(origins = "*")
public class TableController {
    @Autowired
    private TableService service;
    @GetMapping("/available")
    public ResponseEntity<List<Table>> getAvailableTables(@RequestParam LocalDateTime startDateTime,@RequestParam LocalDateTime endDateTime){
        List<Table> availableTables = service.getAvailableTables(startDateTime,endDateTime);
        return ResponseEntity.ok(availableTables);
    }
    @PostMapping("/book")
    public ResponseEntity<Table> bookTable(@RequestBody Table reservation){
        Table bookedTable=service.bookTable(reservation);
        return ResponseEntity.ok(bookedTable);
    }
    @DeleteMapping("/release/{id}")
    public ResponseEntity<Void> releaseTable(@PathVariable String id){
        service.releaseTable(id);
        return ResponseEntity.ok().build();
    }
}
