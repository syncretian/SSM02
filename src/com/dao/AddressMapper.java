package com.dao;

import java.util.List;

import com.model.Address;

public interface AddressMapper {

	public Address selectAddressById(Integer aid);
	
	public List<Address> selectAllAddress();
}
