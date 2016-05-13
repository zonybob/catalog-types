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

		Assert.assertEquals("123456789", em.getHeader().getGuid());
		Assert.assertEquals(2, em.getHeader().getParent_id().size());

	}

	@Test
	public void testExtension() throws Exception {
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("extension.json"));

		EventMessage em = CatalogJsonUtils.readObject(json, EventMessage.class);

		Assert.assertNotNull(em.getHeader());
		Assert.assertNotNull(em.getHeader().getProducer());
		Assert.assertNotNull(em.getHeader().getProducer().getName());

		Assert.assertTrue(em.getEvent() instanceof ExtensionEvent);
		ExtensionEvent extEv = (ExtensionEvent) em.getEvent();
		Assert.assertEquals("extrastuff", extEv.getTypeName());
		Assert.assertEquals("ext system 1", em.getEvent().getExt().get("file_source"));

	}

	@Test
	public void testCustom() throws Exception {
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("extension.json"));
		EventMessage em = CatalogJsonUtils.readObject(json, EventMessage.class);

		CustomEvent ev = new CustomEvent();
		EventTypeRegistry.registerClass(ev.getClass());
		em.setEvent(ev);

		String ser = CatalogJsonUtils.writeObject(em);
		Assert.assertTrue(ser.contains("custom"));

		EventMessage read = CatalogJsonUtils.readObject(ser, EventMessage.class);
		Assert.assertTrue(em.getEvent() instanceof CustomEvent);

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
