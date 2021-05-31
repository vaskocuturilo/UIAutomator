package com.example.uiautomator.model;

import com.google.gson.annotations.SerializedName;

public class Rain{

	@SerializedName("1h")
	private double jsonMember1h;

	public double getJsonMember1h(){
		return jsonMember1h;
	}
}