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
public class CatalogRecord
{

  private String              id;

  @JsonProperty(value = "data_type")
  private String              dataType;

  private Meta                meta;

  private List<Location>      locations = new ArrayList();

  private Map<String, Object> ext       = new HashMap();

  public CatalogRecord()
  {
    super();
  }

  public CatalogRecord(String id, String dataType, Meta meta, List<Location> locations, Map<String, Object> ext)
  {
    super();
    this.id = id;
    this.dataType = dataType;
    this.meta = meta;
    this.locations = locations;
    this.ext = ext;
  }

  @JsonAnySetter
  public void add(String key, Object value)
  {
    ext.put(key, value);
  }

  public void addLocations(Location location)
  {
    locations.add(location);
  }

  public String getDataType()
  {
    return dataType;
  }

  @JsonAnyGetter
  public Map<String, Object> getExt()
  {
    return ext;
  }

  public String getId()
  {
    return id;
  }

  @JsonIgnore
  public Location getLocationFor(String name, String uri)
  {
    for (Location location : locations)
    {
      if (name.equals(location.getName()) && uri.equals(location.getUri()))
      {
        return location;
      }
    }
    return null;
  }

  public List<Location> getLocations()
  {
    return locations;
  }

  public Meta getMeta()
  {
    return meta;
  }

  public void setDataType(String dataType)
  {
    this.dataType = dataType;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public void setLocations(List<Location> locations)
  {
    this.locations = locations;
  }

  public void setMeta(Meta meta)
  {
    this.meta = meta;
  }

}
