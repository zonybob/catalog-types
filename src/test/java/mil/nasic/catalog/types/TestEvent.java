package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestEvent {

	@Test
	public void testBasic() throws Exception {
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("fileev1.json"));

		EventMessage em = CatalogJsonUtils.readObject(json, EventMessage.class);

		Assert.assertNotNull(em.getHeader());
		Assert.assertNotNull(em.getHeader().getProducer());
		Assert.assertNotNull(em.getHeader().getProducer().getName());

		Assert.assertTrue(em.getEvent() instanceof FileIdentifiedEvent);

	}

	@Test
	public void testCompoundError() throws Exception {
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("compoundevent.json"));
		IllegalArgumentException expect = null;
		try {
			EventMessage ev = CatalogJsonUtils.readObject(json, EventMessage.class);
		} catch (IllegalArgumentException e) {
			expect = e;
		}
		Assert.assertNotNull(expect);

	}

}
