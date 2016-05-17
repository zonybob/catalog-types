/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.nasic.catalog.types.v0;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

/**
 *
 * @author bmcdonie
 */
public class Events {
    
    private Location locationAdded;
    private Location locationRemoved;
    private String fileIdentified;
    private JSONObject metadataExtracted;

    public Events() {
    }

    @JsonProperty("location_added")
    public Location getLocationAdded() {
        return locationAdded;
    }

    public void setLocationAdded(Location locationAdded) {
        this.locationAdded = locationAdded;
    }

    @JsonProperty("location_removed")
    public Location getLocationRemoved() {
        return locationRemoved;
    }

    public void setLocationRemoved(Location locationRemoved) {
        this.locationRemoved = locationRemoved;
    }

    @JsonProperty("file_identified")
    public String getFileIdentified() {
        return fileIdentified;
    }

    public void setFileIdentified(String fileIdentified) {
        this.fileIdentified = fileIdentified;
    }

    @JsonProperty("meta_extracted")
    public JSONObject getMetadataExtracted() {
        return metadataExtracted;
    }

    public void setMetadataExtracted(JSONObject metadataExtracted) {
        this.metadataExtracted = metadataExtracted;
    }
    
    
    
}
