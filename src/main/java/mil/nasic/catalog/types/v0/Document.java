/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.nasic.catalog.types.v0;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author bmcdonie
 */
public class Document {

        private String id;

        private String dataType;

        private List<Location> locations;

        private JSONObject meta;

        public Document() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("data_type")
        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public List<Location> getLocations() {
            return locations;
        }

        public void setLocations(List<Location> locations) {
            this.locations = locations;
        }

        public JSONObject getMeta() {
            return meta;
        }

        public void setMeta(JSONObject meta) {
            this.meta = meta;
        }
        
        
        

    }

