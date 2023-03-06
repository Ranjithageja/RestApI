package com.example.bus.model;

import java.util.Scanner;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicUpdate
public class BusManagement {

	/* scanner object private to this class is created to accept userInput */
	private static final Scanner scan=new Scanner(System.in);
	public BusManagement() {

	}

	private String startingPoint;
	private String endingPoint;
	private String driverName;
	private Long driverNumber;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="Bus_number",length=10,unique=true)
	private int  busId;
	public int  getBusId() {
		return busId;
	}

	/*public void setBusId(Integer busId) {
		this.busId = busId;
	}*/

	private String busNumber;
	private String busType;
	
	public String getStartingpoint() {
		return startingPoint;
	}

	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getEndingPoint() {
		return endingPoint;
	}
	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Long getDriverNumber() {
		return driverNumber;
	}
	
	public void setDriverNumber(Long driverNumber) {
		this.driverNumber = driverNumber;
	}
	
   public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;

}

	@Override
	public String toString() {
		return "BusManagement [startingpoint=" + startingPoint + ", endingPoint=" + endingPoint + ", driverName="
				+ driverName + ", driverNumber=" + driverNumber + ", busNumber=" + busNumber + ", busType=" + busType
				+ ",busId=" + busId +"]";
	}
}
