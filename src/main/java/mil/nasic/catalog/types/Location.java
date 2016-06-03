package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    private String name;

    private String uri;
    
    @JsonProperty(value="file_size")
    private Long fileSize;


    private Map<String, Object> ext = new HashMap();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    @JsonAnyGetter
    public Map<String, Object> getExt() {
        return ext;
    }

    @JsonAnySetter
    public void add(String key, Object value) {
        ext.put(key, value);
    }

    public Long getFileSize()
    {
      return fileSize;
    }

    public void setFileSize(Long fileSize)
    {
      this.fileSize = fileSize;
    }

}
