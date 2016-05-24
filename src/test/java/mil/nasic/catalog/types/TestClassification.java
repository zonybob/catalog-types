package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.geojson.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestClassification {

	@Test
	public void testICRecord() throws Exception {

		String json = IOUtils.toString(TestCatalogRecord.class.getResourceAsStream("class.json"));

		Classification cls = CatalogJsonUtils.readObject(json, Classification.class);

		Assert.assertNotNull(cls);

		Assert.assertEquals("UNCLASSIFIED//TK//REL TO USA, GBR", cls.getMarking());
		Assert.assertEquals("U", cls.getClassification());
		Assert.assertEquals("USA", cls.getOwnerProducer());

		Assert.assertEquals(1, cls.getClassificationReason().size());
		Assert.assertEquals("1.4(b)", cls.getClassificationReason().get(0));

		Assert.assertEquals(1, cls.getClassifiedBy().size());
		Assert.assertEquals("John Doe, Position Title", cls.getClassifiedBy().get(0));
		
		Assert.assertEquals(2010, cls.getDeclassDate().getYear());

		Assert.assertEquals(1, cls.getSciControls().size());
		Assert.assertEquals("ST", cls.getSciControls().get(0));

		Assert.assertEquals(1, cls.getDisseminationControls().size());
		Assert.assertEquals("USA", cls.getDisseminationControls().get(0));

		Assert.assertEquals(3, cls.getFgiSourceOpen().size());
		Assert.assertEquals("AUS", cls.getFgiSourceOpen().get(0));
		
		Assert.assertEquals(2, cls.getRealeasableTo().size());
		Assert.assertEquals("AUS", cls.getRealeasableTo().get(0));
	}
}
