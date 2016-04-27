package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestEvent {

	@Test
	public void testBasic() throws Exception {
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("fileev1.json"));

		Event ev = CatalogJsonUtils.readObject(json, Event.class);

		Assert.assertNotNull(ev.getHeader());
		Assert.assertNotNull(ev.getHeader().getProducer());
		Assert.assertNotNull(ev.getHeader().getProducer().getName());

		Assert.assertNotNull(ev.getFileIdentified());
		Assert.assertNotNull(ev.getFileIdentified().getFile());

	}

	@Test
	public void testSplit() throws Exception {
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("compoundevent.json"));

		Event ev = CatalogJsonUtils.readObject(json, Event.class);

		Assert.assertNotNull(ev.getHeader());
		Assert.assertNotNull(ev.getHeader().getProducer());
		Assert.assertNotNull(ev.getHeader().getProducer().getName());

		Assert.assertNotNull(ev.getFileIdentified());
		Assert.assertNotNull(ev.getFileIdentified().getFile());
		
		Assert.assertEquals(2, ev.splitEvent().size());
		
		Assert.assertTrue(ev.hasExtensionMeta());
		Assert.assertFalse(ev.hasExtensionMetaError());
		
		String jsonOut = CatalogJsonUtils.writeObject(ev);
		System.out.println(jsonOut);

	}

}
