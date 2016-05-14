package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author jcstewart
 */
public class CatalogRecord {

    private String id;

    private String type;

    private Meta meta;

    private List<Location> locations = new ArrayList();

    private Map<String, Object> ext = new HashMap();

    public CatalogRecord() {
        super();
    }

    public CatalogRecord(String id, String type, Meta meta, List<Location> locations, Map<String, Object> ext) {
        super();
        this.id = id;
        this.type = type;
        this.meta = meta;
        this.locations = locations;
        this.ext = ext;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void addLocations(Location location) {
        locations.add(location);
    }

    @JsonAnyGetter
    public Map<String, Object> getExt() {
        return ext;
    }

    @JsonAnySetter
    public void add(String key, Object value) {
        ext.put(key, value);
    }

    @JsonIgnore
    public Location getLocationFor(String name, String uri) {
        for (Location location : locations) {
            if (name.equals(location.getName()) && uri.equals(location.getUri())) {
                return location;
            }
        }
        return null;
    }

}
