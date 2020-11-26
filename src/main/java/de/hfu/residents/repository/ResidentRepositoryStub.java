package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {
	
	private ArrayList<Resident> residentList = new ArrayList<Resident>();
	
	public void add(Resident resident) {
		residentList.add(resident);
	}

	@Override
	public List<Resident> getResidents() {
		return residentList;
	}
	
	

}
