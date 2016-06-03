package mil.nasic.catalog.types;

import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestMessageEnvelope
{
  @Test
  public void testMinimal() throws Exception
  {
    String json = IOUtils.toString(TestMessageEnvelope.class.getResourceAsStream("messageEnvelopeMin.json"));
    MessageEnvelope me = CatalogJsonUtils.readObject(json, MessageEnvelope.class);
    Assert.assertNotNull(me);
  }

  @Test
  public void testBasic() throws Exception
  {
    String json = IOUtils.toString(TestMessageEnvelope.class.getResourceAsStream("messageEnvelope.json"));
    MessageEnvelope me = CatalogJsonUtils.readObject(json, MessageEnvelope.class);
    Assert.assertNotNull(me);
    Assert.assertEquals("0.2", me.getVersion());
    Assert.assertEquals("hello", me.getMessages().get("message1"));
    Object message2 = me.getMessages().get("message2");
    Assert.assertNotNull(message2);
    Assert.assertTrue(message2 instanceof Map);
    Map m2 = (Map) message2;
    Assert.assertEquals("world", m2.get("text"));
    Assert.assertNotNull(me.getHeader());

    //    time":"2016-06-02T15:54:46.649Z","producer":{"name":"test producer","node":"10.10.10.10","version":"1.0.0.0.0"}
    Assert.assertEquals("test producer", me.getHeader().getProducer().getName());
    Assert.assertNotNull(me.getMessages().get("message2"));
  }

  @Test
  public void testHistory() throws Exception
  {
    String json = IOUtils.toString(TestMessageEnvelope.class.getResourceAsStream("messageEnvelopeHistory.json"));
    MessageEnvelope me = CatalogJsonUtils.readObject(json, MessageEnvelope.class);
    Assert.assertNotNull(me);
    Assert.assertEquals("0.2", me.getHistory().get(0).getVersion());

  }

}
