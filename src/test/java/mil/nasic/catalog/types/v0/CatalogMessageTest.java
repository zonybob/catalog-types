/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.nasic.catalog.types.v0;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bmcdonie
 */
public class CatalogMessageTest {
    
    public CatalogMessageTest() {
    }

    @Test
    public void testLocations() throws IOException {
        CatalogMessage cm = CatalogMessage.fromStream(CatalogMessageTest.class.getResourceAsStream("catalogmessage.json"));
        assertNotNull(cm);
        assertFalse(cm.getDocument().getLocations().stream().anyMatch(l -> l.getCompression() == null));
    }

}
