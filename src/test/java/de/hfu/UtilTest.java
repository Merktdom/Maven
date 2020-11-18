package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testIstErstesHalbjahr() {
		assertTrue("Januar ist im ersten Halbjahr", Util.istErstesHalbjahr(1));
		assertFalse("Dezember liegt nicht im ersten Halbjahr", Util.istErstesHalbjahr(12));
		assertTrue("Juni sollte noch im ersten Halbjahr liegen", Util.istErstesHalbjahr(6));
	}
}
