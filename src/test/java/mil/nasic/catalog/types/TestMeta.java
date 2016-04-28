package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import mil.nasic.catalog.types.CatalogJsonUtils;
import mil.nasic.catalog.types.Meta;

public class TestMeta {

	@Test
	public void testMeta() throws Exception {

		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("meta1.json"));
		Meta meta = CatalogJsonUtils.readObject(json, Meta.class);

		Assert.assertEquals(3, meta.getGeom().size());
		Assert.assertTrue(meta.getClassification().getMarking().contains("UNCLASS"));

	}

	@Test
	public void testMetaEvent() throws Exception {

		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("metaevent.json"));
		
		EventMessage message = CatalogJsonUtils.readObject(json, EventMessage.class);
		
		
		MetaEvent metaev = (MetaEvent) message.getEvent();
		
		Meta meta = metaev.getMeta();

		Assert.assertEquals(3, meta.getGeom().size());
		Assert.assertTrue(meta.getClassification().getMarking().contains("UNCLASS"));

		
		System.out.println(CatalogJsonUtils.writeObject(message));
	}

}
