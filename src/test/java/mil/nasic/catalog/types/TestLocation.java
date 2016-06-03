package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestLocation {
	@Test
	public void testLocationEvent() throws Exception {

		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("record1.json"));

		CatalogRecord rec = CatalogJsonUtils.readObject(json, CatalogRecord.class);

		Assert.assertEquals("loc1", rec.getLocations().get(0).getName());
		
        Assert.assertEquals(12345, rec.getLocations().get(0).getFileSize().longValue());
		
	}

}
