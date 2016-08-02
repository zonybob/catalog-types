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

		Assert.assertNotNull(meta.getSource().getDeliveryTime());
		Assert.assertNotNull(meta.getMetaProducer().getProducer().getVersion());

		Assert.assertEquals("extension goes here", meta.getTasking().getExt().get("ext"));

	}

}
