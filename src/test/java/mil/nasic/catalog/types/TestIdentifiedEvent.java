package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import org.junit.Assert;

public class TestIdentifiedEvent {

	@Test
	public void testBasic() throws Exception {

		String json = IOUtils.toString(TestIdentifiedEvent.class.getResourceAsStream("fileev1.json"));
		
		Event ev = CatalogJsonUtils.readObject(json, Event.class);
		
		Assert.assertNotNull(ev.getHeader());
		Assert.assertNotNull(ev.getHeader().getProducer());
		Assert.assertNotNull(ev.getHeader().getProducer().getName());
		
		Assert.assertNotNull(ev.getFileIdentified());
		Assert.assertNotNull(ev.getFileIdentified().getFile());
		
		Assert.assertEquals("FRM", ev.getFileIdentified().getDataType());
	}
}
