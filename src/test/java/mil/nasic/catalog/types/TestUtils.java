package mil.nasic.catalog.types;

import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.Assert;

public class TestUtils {

    @Test
    public void testJsonFormsEqual() throws Exception {

        String json = IOUtils.toString(TestMeta.class.getResourceAsStream("meta1.json"));
        Meta meta = CatalogJsonUtils.readObject(json, Meta.class);
        String json2 = IOUtils.toString(TestMeta.class.getResourceAsStream("meta2.json"));
        Meta meta2 = CatalogJsonUtils.readObject(json, Meta.class);

        Assert.assertTrue(CatalogJsonUtils.areJsonFormsEqual(meta, meta2));
    }

    @Test
    public void testMerge() throws Exception {
        String json1 = IOUtils.toString(TestMeta.class.getResourceAsStream("merge1.json"));
        String json2 = IOUtils.toString(TestMeta.class.getResourceAsStream("merge2.json"));

        String result = CatalogJsonUtils.mergeJson(json1, json2);

        JsonNode node = CatalogJsonUtils.getMapper().readTree(result);

        Assert.assertEquals("replaced", node.get("replace").asText());
        Assert.assertEquals("leavealone", node.get("leavealone").asText());
        Assert.assertFalse(node.get("makenull").isNull());
        Assert.assertFalse(node.get("makeobjnull").isNull());
        Assert.assertEquals("added", node.get("added").asText());

        JsonNode added = node.get("addedobj");
        Assert.assertEquals("added", added.get("added").asText());

        JsonNode nested = node.get("nestedchanges");

        Assert.assertEquals("replaced", nested.get("replace").asText());
        Assert.assertEquals("leavealone", nested.get("leavealone").asText());
        Assert.assertFalse(nested.get("makenull").isNull());
        Assert.assertFalse(nested.get("makeobjnull").isNull());
        Assert.assertEquals("added", nested.get("added").asText());
        added = nested.get("addedobj");
        Assert.assertEquals("added", added.get("added").asText());
    }
    
    @Test
    public void testMergeApplyNull() throws Exception {
        String json1 = IOUtils.toString(TestMeta.class.getResourceAsStream("merge1.json"));
        String json2 = IOUtils.toString(TestMeta.class.getResourceAsStream("merge2.json"));

        String result = CatalogJsonUtils.mergeJson(json1, json2, true);

        JsonNode node = CatalogJsonUtils.getMapper().readTree(result);

        Assert.assertEquals("replaced", node.get("replace").asText());
        Assert.assertEquals("leavealone", node.get("leavealone").asText());
        Assert.assertTrue(node.get("makenull").isNull());
        Assert.assertTrue(node.get("makeobjnull").isNull());
        Assert.assertEquals("added", node.get("added").asText());

        JsonNode added = node.get("addedobj");
        Assert.assertEquals("added", added.get("added").asText());

        JsonNode nested = node.get("nestedchanges");

        Assert.assertEquals("replaced", nested.get("replace").asText());
        Assert.assertEquals("leavealone", nested.get("leavealone").asText());
        Assert.assertTrue(nested.get("makenull").isNull());
        Assert.assertTrue(nested.get("makeobjnull").isNull());
        Assert.assertEquals("added", nested.get("added").asText());
        added = nested.get("addedobj");
        Assert.assertEquals("added", added.get("added").asText());
    }


    @Test
    public void testMergeFailObjToVal() throws Exception {
        String json1 = IOUtils.toString(TestMeta.class.getResourceAsStream("merge1.json"));
        String json2 = IOUtils.toString(TestMeta.class.getResourceAsStream("merge3.json"));

        IllegalArgumentException expect = null;
        try {
            String result = CatalogJsonUtils.mergeJson(json1, json2, true);
        } catch (IllegalArgumentException e) {
            expect = e;
        }
        Assert.assertNotNull(expect);
    }

   
}
