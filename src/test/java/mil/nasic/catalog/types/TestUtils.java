package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import org.junit.Assert;

public class TestUtils {

	@Test
	public void testJsonFormsEqual()throws Exception{
		
		String json = IOUtils.toString(TestMeta.class.getResourceAsStream("meta1.json"));
		Meta meta = CatalogJsonUtils.readObject(json, Meta.class);
		String json2 = IOUtils.toString(TestMeta.class.getResourceAsStream("meta2.json"));
		Meta meta2 = CatalogJsonUtils.readObject(json, Meta.class);
		
		Assert.assertTrue(CatalogJsonUtils.areJsonFormsEqual(meta, meta2));
	}
}
