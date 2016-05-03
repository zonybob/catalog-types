package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.geojson.LineString;
import org.geojson.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestMeta {

	@Test
	public void testMeta() throws Exception {

		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("meta1.json"));
		Meta meta = CatalogJsonUtils.readObject(json, Meta.class);

		Assert.assertTrue(meta.getGeom() instanceof Point);
		Assert.assertTrue(meta.getClassification().getMarking().contains("UNCLASS"));

	}

	@Test
	public void testMetaEvent() throws Exception {

		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("metaevent.json"));
		
		EventMessage message = CatalogJsonUtils.readObject(json, EventMessage.class);
		
		
		MetaEvent metaev = (MetaEvent) message.getEvent();
		
		Meta meta = metaev.getMeta();

        Assert.assertTrue(meta.getGeom() instanceof LineString);
		Assert.assertTrue(meta.getClassification().getMarking().contains("UNCLASS"));
		
		System.out.println(CatalogJsonUtils.writeObject(message));
	}

}
