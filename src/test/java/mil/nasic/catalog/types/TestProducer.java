package mil.nasic.catalog.types;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import mil.nasic.catalog.types.CatalogJsonUtils;
import mil.nasic.catalog.types.ProducerInfo;

public class TestProducer {

	@Test
	public void testBasic() throws Exception {

		String json = "{ \"name\": \"testname\", \"node\": \"1.1.1.1\", \"version\": \"1.0\"}";

		ObjectMapper om = CatalogJsonUtils.getMapper();

		ProducerInfo pi = om.readValue(json, ProducerInfo.class);
		Assert.assertEquals("testname", pi.getName());
		Assert.assertEquals("1.1.1.1", pi.getNode());
		Assert.assertEquals("1.0", pi.getVersion());
	}

	@Test
	public void testExt() throws Exception {

		String json = "{ \"name\": \"testname\", \"node\": \"1.1.1.1\", \"version\": \"1.0\", \"extra\": \"stuff\"}";

		ObjectMapper om = CatalogJsonUtils.getMapper();

		ProducerInfo pi = om.readValue(json, ProducerInfo.class);
		Assert.assertEquals("testname", pi.getName());
		Assert.assertEquals("1.1.1.1", pi.getNode());
		Assert.assertEquals("1.0", pi.getVersion());
		Assert.assertEquals("stuff", pi.getExt().get("extra"));

		json = "{ \"name\": \"testname\", \"node\": \"1.1.1.1\", \"version\": \"1.0\", \"nested\": { \"more\" : \"stuff\" }  }";

		pi = om.readValue(json, ProducerInfo.class);
		Assert.assertEquals("testname", pi.getName());
		Assert.assertEquals("1.1.1.1", pi.getNode());
		Assert.assertEquals("1.0", pi.getVersion());
		Assert.assertTrue(pi.getExt().get("nested") instanceof Map);
		Map nest = (Map) pi.getExt().get("nested");
		Assert.assertEquals("stuff", nest.get("more"));
	}
}
