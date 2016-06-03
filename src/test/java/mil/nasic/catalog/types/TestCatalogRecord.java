package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.geojson.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestCatalogRecord {
    @Test
    public void testICRecord() throws Exception {

        String json = IOUtils.toString(TestCatalogRecord.class.getResourceAsStream("record1.json"));
        CatalogRecord rec = CatalogJsonUtils.readObject(json, CatalogRecord.class);

        Assert.assertTrue(rec.getMeta().getGeom() instanceof Point);
        Assert.assertEquals( "something", rec.getDataType());
        
        Assert.assertEquals("0.2", rec.getSchemaVersion());

    }
}
