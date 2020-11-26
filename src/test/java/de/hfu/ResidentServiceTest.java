package de.hfu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

import java.util.Date;

public class ResidentServiceTest {
	
	
	@Test
	public void getUniqueResidentTest() {
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Weigheim" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Weingarten" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Berlin" , new Date(1956-11-05) );
		
		ResidentRepositoryStub testRepository = new ResidentRepositoryStub();
		
		testRepository.add(resident1);
		testRepository.add(resident2);
		testRepository.add(resident3);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(testRepository);
		Resident filterResident = new Resident();
		filterResident.setGivenName("Günter");
		
		try {
			assertEquals(resident2, service.getUniqueResident(filterResident));
		} catch (ResidentServiceException e) {
			assert false;
		}
	}
	
	@Test(expected = ResidentServiceException.class)
	public void getUniqueResidentExceptionNotUniqueTest() throws ResidentServiceException {
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Weigheim" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Weingarten" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Berlin" , new Date(1956-11-05) );
		
		ResidentRepositoryStub testRepository = new ResidentRepositoryStub();
		
		testRepository.add(resident1);
		testRepository.add(resident2);
		testRepository.add(resident3);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(testRepository);
		
		Resident filterResident = new Resident();
		filterResident.setGivenName("Papenheimer");
		
		service.getUniqueResident(filterResident);
	}
	
	@Test(expected = ResidentServiceException.class)
	public void getUniqueResidentExceptionWildcardTest() throws ResidentServiceException {
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Weigheim" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Weingarten" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Berlin" , new Date(1956-11-05) );
		
		ResidentRepositoryStub testRepository = new ResidentRepositoryStub();
		
		testRepository.add(resident1);
		testRepository.add(resident2);
		testRepository.add(resident3);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(testRepository);
		
		Resident filterResident = new Resident();
		filterResident.setGivenName("*");
		
		service.getUniqueResident(filterResident);
	}
	
	@Test
	public void getFilteredResidentsListForWildcardTest() {
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Weigheim" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Weingarten" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Berlin" , new Date(1956-11-05) );
		
		ResidentRepositoryStub testRepository = new ResidentRepositoryStub();
		
		testRepository.add(resident1);
		testRepository.add(resident2);
		testRepository.add(resident3);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(testRepository);
		
		Resident filterResident = new Resident();
		filterResident.setFamilyName("*");
		
		assertEquals(testRepository.getResidents(),service.getFilteredResidentsList(filterResident));
	}
	
	@Test
	public void getFilteredResidentsListByDateTest() {
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Weigheim" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Weingarten" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Berlin" , new Date(1956-11-05) );
		
		ResidentRepositoryStub testRepository = new ResidentRepositoryStub();
		
		testRepository.add(resident1);
		testRepository.add(resident2);
		testRepository.add(resident3);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(testRepository);
		
		Resident filterResident = new Resident();
		filterResident.setDateOfBirth(new Date(1983-05-17));
		
        assertEquals(service.getFilteredResidentsList(filterResident).get(0),resident1);
	}
	
	@Test
	public void getFilteredResidentsListByCity() {
		
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Weigheim" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Weingarten" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Berlin" , new Date(1956-11-05) );
		
		ResidentRepositoryStub testRepository = new ResidentRepositoryStub();
		
		testRepository.add(resident1);
		testRepository.add(resident2);
		testRepository.add(resident3);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(testRepository);
		
		Resident filterResident = new Resident();
		filterResident.setStreet("Siegesstraße 43");
		
		assertEquals(service.getFilteredResidentsList(filterResident).get(0), resident3);
		
	}

} 
