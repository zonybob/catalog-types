package mil.nasic.catalog.types;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import mil.nasic.catalog.types.CatalogJsonUtils;
import mil.nasic.catalog.types.MergeUtils;
import mil.nasic.catalog.types.Meta;

public class TestMerging {
	
	@Test
	public void MergeTest(){
		String metaStr = "";
		try {
			metaStr = IOUtils.toString(TestMerging.class.getResourceAsStream("/testMeta.json"));
		} catch (IOException e) {
			Assert.assertTrue(false);
		}
		
		Meta meta1 = null;
		Meta meta2 = null;
		try {
			meta1 = CatalogJsonUtils.readObject(metaStr, Meta.class);
			meta2 = CatalogJsonUtils.readObject(metaStr, Meta.class);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		try {
			System.out.println(CatalogJsonUtils.writeObject(meta1));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		Meta meta3 = null;
		try {
			meta3 = (Meta) MergeUtils.merge(meta1, meta2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		String test = null;
		try {
			test = CatalogJsonUtils.writeObject(meta3);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		System.out.println(test);
	}
}
