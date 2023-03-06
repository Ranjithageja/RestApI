package com.example.bus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus.model.BusManagement;
import com.example.bus.service.BusManagementServiceImpl;

@RestController
@RequestMapping("/BusDetails.com")

public class BusManagementController {
	
	public BusManagementServiceImpl busServ;
	
	public  BusManagementController(BusManagementServiceImpl busServ) {
		this.busServ = busServ;
	}
	@PostMapping("/saveBus")
    public ResponseEntity<BusManagement> saveBus(@RequestBody BusManagement bus ){
		return new ResponseEntity<BusManagement>(busServ.saveBus(bus), HttpStatus.CREATED);
	}


	@PutMapping("/updateBus/{busId}")
	public ResponseEntity<BusManagement> updateBusDetailsById(@PathVariable("busId") int id,
			@RequestBody BusManagement bus){
		return new ResponseEntity<BusManagement>(busServ.updateBusDetails(bus, id), HttpStatus.OK);

	}
	@GetMapping("/readAllBus")
	public List<BusManagement> getAllBus(){
		return busServ.getBusFromDb();
	}

	//localhost:8080/readBus/5
	@GetMapping("/readBus/{id}")
	public ResponseEntity<BusManagement>  getBusManagementById(@PathVariable("id")  int busId){
		return new ResponseEntity<BusManagement>(busServ.getBusManagementById(busId), HttpStatus.OK);
	}

	@DeleteMapping("/deleteBus/{id}")
	public ResponseEntity<String> deleteBusManagementById(@PathVariable("id")  int busId){
		busServ.deleteBusById(busId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
}


