package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TestCatalogRecord {
	@Test
	public void testICRecord() throws Exception {

		String json = IOUtils.toString(TestCatalogRecord.class.getResourceAsStream("record1.json"));
		CatalogRecord rec = CatalogJsonUtils.readObject(json, CatalogRecord.class);

		// Assert.assertEquals("123456789", rec.getId());
		//
		// IdentifiedEvent ev = (IdentifiedEvent)
		// rec.getHistory().getEvents().get(0);
		// Assert.assertEquals("ABC directory monitor",
		// ev.getHeader().getProducer().getName());
		// Assert.assertEquals(9999999l, ev.getFile().getFile_size());
		// Assert.assertEquals(2009,
		// ev.getFile().getDiscovered_time().getYear());
		//
		// Assert.assertNotNull(rec.getMeta());
		// Assert.assertNotNull(rec.getMeta().getGeom());
		// Assert.assertEquals(3, rec.getMeta().getGeom().size());
		// Assert.assertTrue(rec.getMeta().getClassification().getMarking().contains("UNCLASS"));
		//
		// Assert.assertNotNull(rec.getStatus());
		// Assert.assertNull(rec.getStatus().getStatus());

	}
}
