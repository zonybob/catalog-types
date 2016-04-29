package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import org.junit.Assert;

public class TestFileErrorEvent {

	@Test
	public void testFileError() throws Exception {
		String json = IOUtils.toString(TestIdentifiedEvent.class.getResourceAsStream("fileerr.json"));

		EventMessage ev = CatalogJsonUtils.readObject(json, EventMessage.class);

		Assert.assertTrue(ev.getEvent() instanceof FileErrorEvent);
		FileErrorEvent errev = (FileErrorEvent) ev.getEvent();
		Assert.assertEquals("uri", errev.getFileError().getUri());
		Assert.assertEquals("errmsg", errev.getFileError().getMessage());
		Assert.assertEquals("ext", errev.getExt().get("extension"));
	}
}
