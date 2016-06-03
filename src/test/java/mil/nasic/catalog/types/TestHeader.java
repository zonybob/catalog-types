package mil.nasic.catalog.types;

import org.junit.Test;

public class TestHeader {

	@Test
	public void testBuildHeader() throws Exception{
		// apps can set this up once, and keep it around for building headers.
		ProducerInfo.Builder pi = new ProducerInfo.Builder();
		pi.name("test producer");
		pi.node("10.10.10.10");
		pi.version("1.0.0.0.0");

		// An easy event header..
		Header.Builder ehb1 = new Header.Builder();
		//all we really need to set is the pi
		// a time and a unique GUID are already set.
		ehb1.producer(pi);
		
		Header eh1 = ehb1.build();
		System.out.println(CatalogJsonUtils.writeObject(eh1));
		
		//IF some later event wants to set that previous one as its trigger
		Header.Builder ehb2 = new Header.Builder();
		ehb2.producer(pi);
		
		
		Header eh2 = ehb2.build();
		System.out.println(CatalogJsonUtils.writeObject(eh2));

	}
}
