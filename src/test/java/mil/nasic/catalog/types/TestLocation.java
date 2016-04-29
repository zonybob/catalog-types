package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestLocation {
	@Test
	public void testLocationEvent() throws Exception {

		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("locationadd.json"));

		EventMessage message = CatalogJsonUtils.readObject(json, EventMessage.class);

		LocationAddEvent addEv = (LocationAddEvent) message.getEvent();

		Location loc = addEv.getLocation();
		Assert.assertEquals("stage", loc.getName());
		Assert.assertEquals("file:///somepath/file.ext", loc.getUri());
		
		System.out.println(CatalogJsonUtils.writeObject(message));
	}

}
