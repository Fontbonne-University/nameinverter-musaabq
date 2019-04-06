package nameInverter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class nameInverterTest {

	NameInverter nameMethods;
	
	@Before
	public void setUp() throws Exception {
		nameMethods = new NameInverter();
	}

	private void assertInverted(String invertedName, String originalName) {
		assertEquals(invertedName, nameMethods.invertName(originalName));
	}
	
	public void givenNull_returnsEmptyString() {
		assertInverted(null, "");
	}

	@Test public void givenEmptyString_returnEmptyString() {
		assertInverted("", "");
	}
	
	@Test public void givenSimpleName_returnSimpleName() {
		assertInverted("Name", "Name");
	}
	
	@Test
	public void givenFirstLast_returnLastFirst() {
		assertInverted("First, Last", "Last First");
	}
	@Test
	public void givenASimpleNameWithSpaces_returnSimpleNameWithoutSpaces() {
		assertInverted("Name", " Name ");
	}
	@Test
	public void givenFirstLastWithExtraSpaces_returnLastFirst() {
		assertInverted("First, Last", " Last First ");
	}
	
	@Test
	public void ignoreHonorific() {
		assertInverted("First, Last", "Mr. Last First");
	}
	@Test
	public void postNominals_stayAtEnd() {
		assertInverted("First, Last Sr.", "Last First Sr.");
		assertInverted("First, Last BS. Phd.", "Last First BS. Phd.");
		
	}
	
	@Test
	public void integration() {
		assertInverted("First, Last I Sr. Phd.", "  Dr. Last First I Sr. Phd.");
	}

}