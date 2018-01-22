package com.vehicle.domain.object;

/**  VehicleDomain Contains Vehicle related information */

public class VehicleDomain {
	private String Make;
	private String Colour;
	private String RegNo;

	public String getRegNo() {
		return RegNo;
	}
	public void setRegNo(String regNo) {
		RegNo = regNo;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}

}
