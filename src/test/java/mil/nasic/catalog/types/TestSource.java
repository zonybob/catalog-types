package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestSource
{
  @Test
  public void testSource() throws Exception
  {

    String json = IOUtils.toString(TestMeta.class.getResourceAsStream("source.json"));
    Source source = CatalogJsonUtils.readObject(json, Source.class);

    Assert.assertEquals("NRO", source.getAgency());
    Assert.assertNotNull(source.getDeliveryTime());
    Assert.assertNotNull(source.getDiscoveredTime());
    Assert.assertEquals("ext", source.getFileFormat());
    Assert.assertEquals("ext system 1", source.getFileSource());
    Assert.assertEquals("9959064.s1-nitf.c6ce70f8-8579-4d04-9950-b010aaae56a1.nitf", source.getFileName());
    Assert.assertEquals("file:///path/to/ingest/9959064.s1-nitf.c6ce70f8-8579-4d04-9950-b010aaae56a1.nitf", source.getUri());
    Assert.assertEquals(999999, source.getFileSize().longValue());
    Assert.assertEquals("2fd4e1c67a2d28fced849ee1bb76e7391b93eb12", source.getSha1Hash());

  }
}
