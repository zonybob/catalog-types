package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import org.junit.Assert;

public class TestFileIdentifiedMessage {

	@Test
	public void testBasic() throws Exception {

		String json = IOUtils.toString(TestFileIdentifiedMessage.class.getResourceAsStream("fileev1.json"));

		MessageEnvelope ev = CatalogJsonUtils.readObject(json, MessageEnvelope.class);

		Assert.assertNotNull(ev.getHeader());
		Assert.assertNotNull(ev.getHeader().getProducer());
		Assert.assertNotNull(ev.getHeader().getProducer().getName());

		FileIdentifiedMessage fiev = (FileIdentifiedMessage) ev.getMessages().get("fileIdentified");
		Assert.assertEquals("FRM", fiev.getDataType());
	}
}
