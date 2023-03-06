package com.example.bus.BusservInter;

import java.util.List;

import com.example.bus.model.BusManagement;
/* here we declare some of the methods like save BusDetails,get BusDetails ,
 * get BusDetails by id, updating and delete details by id*/

public interface BusManagementServ {
	BusManagement saveBus(BusManagement bus);
	List<BusManagement>  getBusFromDb();

	BusManagement getBusManagementById(int busId);
	BusManagement updateBusDetails(BusManagement bus, int busId);
	void deleteBusById(int busId);
}


