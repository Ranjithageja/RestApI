package com.example.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bus.BusservInter.BusManagementServ;
import com.example.bus.model.BusManagement;
import com.example.bus.repository.BusManagementRepo;

/*@Service-  allows developers to add business functionalities.
 * here we have to implement the 'BusDetailsservice' interface by 
 * giving definitions to the method declaration of 'BusDetails service'
 */
/*bus repository class acts as an attribute by calling the method like save,find all,
 * find by id, update by id and delete by id 
 */

@Service
public class BusManagementServiceImpl implements BusManagementServ{
	BusManagementRepo busRepo;
	

	public BusManagementServiceImpl(BusManagementRepo busRepo) {
		this.busRepo = busRepo;
	}
	public BusManagement saveBus(BusManagement bus) {
		return busRepo.save(bus
				);
	}

	/*  get BusDetailsfrom db- display all the details from the database by find all method*/
	
	@Override
	public List<BusManagement> getBusFromDb() {
		return busRepo.findAll();
	}

	/* get BusDetails by id -display the particular details of the id in which we want to see
	 * Optional - provides methods for getting the values.
	 *  You can check isPresent() for the presence of the value and then make a call to get() */

	@Override//5
	public BusManagement getBusManagementById(int busId) {
		Optional<BusManagement> bus = busRepo.findById(busId);
		if(bus.isPresent()) {
			return bus.get();
		}
		else {
			return null;
		}
	}

	/*Update BusDetails- update the BusDetails of the id if we want to change the values of attribute
	 *Optional - provides methods for getting the values.
	 *  You can check isPresent() for the presence of the value  update the value by set () and  get()*/

	@Override
	public BusManagement updateBusDetails(BusManagement newVal, int busId) {
		Optional<BusManagement> bus = busRepo.findById(busId);
		if(bus.isPresent()) {
			BusManagement existingBus = bus.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingBus.setDriverName(newVal.getDriverName());
			existingBus.setBusType(newVal.getBusType());
			busRepo.save(existingBus);
			return existingBus;
		}
		else {
			return null;
		}
	}
	

	/*Delete BusDetails by id- Delete the hotel details of the id. 
	 * Optional - provides methods for getting the values.
	 *  You can check isPresent() for the presence of the value and delete  */

	@Override
	public void deleteBusById(int busId) {
		Optional<BusManagement> bus = busRepo.findById(busId);
		if(bus.isPresent()) {
			busRepo.deleteById(busId);
		}	
	}
}
	


