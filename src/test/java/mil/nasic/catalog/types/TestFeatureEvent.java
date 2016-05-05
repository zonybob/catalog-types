package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestFeatureEvent {

	
	@Test
	public void testFeatureCollection() throws Exception{
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("features.json"));

		FeatureEvent em = CatalogJsonUtils.readObject(json, FeatureEvent.class);
		
		Assert.assertNotNull(em.getFeatures());
		Assert.assertNull(em.getFeature());
		
		
		System.out.println(CatalogJsonUtils.writeObject(em));

	}
	
	@Test
	public void testFeature() throws Exception{
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("feature.json"));

		FeatureEvent em = CatalogJsonUtils.readObject(json, FeatureEvent.class);
		
		Assert.assertNotNull(em.getFeature());
		Assert.assertNull(em.getFeatures());
		System.out.println(CatalogJsonUtils.writeObject(em));

	}
	
	@Test
	public void testFeatureEvent() throws Exception{
		String json = IOUtils.toString(TestEvent.class.getResourceAsStream("featureevent.json"));

		EventMessage em = CatalogJsonUtils.readObject(json, EventMessage.class);
		
		Assert.assertTrue(em.getEvent() instanceof FeatureEvent);
		FeatureEvent fe = (FeatureEvent) em.getEvent();
		Assert.assertNotNull(fe.getFeatures());
		Assert.assertNull(fe.getFeature());
		Assert.assertEquals("null island", fe.getFeatures().getFeatures().get(0).getProperty("name"));
		System.out.println(CatalogJsonUtils.writeObject(em));

	}
}
