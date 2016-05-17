/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.nasic.catalog.types.v0;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

/**
 *
 * @author bmcdonie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    private String filename;
    private DateTime validStart;
    private DateTime validEnd;
    private String hashSha256;
    private String type;
    private String compression;
    private String uri;
    private Long size;

    public Location() {
    }
    
    @JsonIgnore
    public boolean isValid() {
        return validEnd == null;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("valid_start")
    public DateTime getValidStart() {
        return validStart;
    }

    public void setValidStart(DateTime validStart) {
        this.validStart = validStart;
    }

    @JsonProperty("valid_end")
    public DateTime getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(DateTime validEnd) {
        this.validEnd = validEnd;
    }

    @JsonProperty("hash_sha256")
    public String getHashSha256() {
        return hashSha256;
    }

    public void setHashSha256(String hashSha256) {
        this.hashSha256 = hashSha256;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
