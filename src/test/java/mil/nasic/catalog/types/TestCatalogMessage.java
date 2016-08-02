
package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.geojson.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestCatalogMessage {
    @Test
    public void testICRecord() throws Exception {

        String json = IOUtils.toString(TestCatalogMessage.class.getResourceAsStream("catalogmessage.json"));
        MessageEnvelope evM = CatalogJsonUtils.readObject(json, MessageEnvelope.class);
        
        CatalogMessage catEvent = (CatalogMessage) evM.getMessages().get("catalog");

        Assert.assertTrue(catEvent.getMeta().getGeom() instanceof Point);

    }
}
