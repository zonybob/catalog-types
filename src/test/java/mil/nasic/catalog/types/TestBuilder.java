package mil.nasic.catalog.types;

import org.junit.Test;

public class TestBuilder {

	@Test
	public void testBuildHeader() throws Exception{
		// apps can set this up once, and keep it around for building headers.
		ProducerInfo.Builder pi = new ProducerInfo.Builder();
		pi.name("test producer");
		pi.node("10.10.10.10");
		pi.version("1.0.0.0.0");

		// An easy event header..
		EventHeader.Builder ehb1 = new EventHeader.Builder();
		//all we really need to set is the pi
		// a time and a unique GUID are already set.
		ehb1.producer(pi);
		
		EventHeader eh1 = ehb1.build();
		System.out.println(CatalogJsonUtils.writeObject(eh1));
		
		//IF some later event wants to set that previous one as its trigger
		EventHeader.Builder ehb2 = new EventHeader.Builder();
		ehb2.producer(pi);
		ehb2.parent_id_from(eh1);
		
		EventHeader eh2 = ehb2.build();
		System.out.println(CatalogJsonUtils.writeObject(eh2));

	}
}
