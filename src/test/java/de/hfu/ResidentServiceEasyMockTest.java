package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Test;
import java.util.Date;
import java.util.ArrayList;
import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ResidentServiceEasyMockTest {

	@Test
	public void easyMockTest() throws ResidentServiceException{
		
		Resident resident1 = new Resident("Josef", "Maier", "Kronstraße 1", "Durchhausen" , new Date(1983-05-17) );
		Resident resident2 = new Resident("Günter", "Papenheimer", "Weinstraße 231", "Durchhausen" , new Date(1999-02-27) );
		Resident resident3 = new Resident("Jaqueline", "Guldi", "Siegesstraße 43", "Durchhausen" , new Date(1956-11-05) );
		
		ArrayList<Resident> repositoryList = new ArrayList<Resident>();
		
		repositoryList.add(resident1);
		repositoryList.add(resident2);
		repositoryList.add(resident3);
		
		ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
		expect(residentRepositoryMock.getResidents()).andReturn(repositoryList);
		
		replay(residentRepositoryMock);
		
		BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryMock);
        
        Resident filterResident = new Resident();
        filterResident.setGivenName("Josef");
        
        assertThat(baseResidentService.getUniqueResident(filterResident), equalTo(resident1));
        
        verify(residentRepositoryMock);
		
	}
}
