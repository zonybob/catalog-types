/*
 * Copyright 2015 Joel Stewart  [email] joel@stewbeans.com
 *
 * This work is Licensed under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * Joel Stewart licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mil.nasic.catalog.types;

import org.apache.commons.io.IOUtils;
import org.geojson.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestNewDataEvent {
    @Test
    public void testICRecord() throws Exception {

        String json = IOUtils.toString(TestCatalogRecord.class.getResourceAsStream("newdataevent.json"));
        EventMessage evM = CatalogJsonUtils.readObject(json, EventMessage.class);
        
        NewDataEvent ev = (NewDataEvent) evM.getEvent();

        Assert.assertTrue(ev.getCatalog().getMeta().getGeom() instanceof Point);

    }
}
