package mil.nasic.catalog.types;

import org.junit.Test;

import org.junit.Assert;

public class TestLocationRemove {

	@Test
	public void testLocationRemove() throws Exception {
		Location l1 = new Location();
		l1.setName("l1");
		l1.setUri("uri1");

		Location l2 = new Location();
		l2.setName("l2");
		l2.setUri("uri2");

		LocationRemoveMessage message = new LocationRemoveMessage();
		message.addLocation(l1);
		message.addLocation(l2);

		Header.Builder hb = new Header.Builder();
		hb.producername("p1").producernode("n1").producerversion("v1");

		MessageEnvelope me = new MessageEnvelope();
		
		me.setHeader(hb.build());
		me.addMessage(message.NAME, message);
		
		String json = CatalogJsonUtils.writeObject(me);
		
		MessageEnvelope read = CatalogJsonUtils.readObject(json, MessageEnvelope.class);
		
		Assert.assertTrue( read.getMessages().get(LocationRemoveMessage.NAME) instanceof LocationRemoveMessage);
		LocationRemoveMessage readrm = (LocationRemoveMessage) read.getMessages().get(LocationRemoveMessage.NAME);
		
		Assert.assertEquals(2, readrm.getLocations().size());
		
	}

}
