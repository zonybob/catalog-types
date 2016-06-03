package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Tasking
{
  private String requirement;

  private Map<String, Object> ext  = new HashMap();

  public String getRequirement()
  {
    return requirement;
  }

  public void setRequirement(String requirement)
  {
    this.requirement = requirement;
  }

  @JsonAnyGetter
  public Map<String, Object> getExt()
  {
    return ext;
  }

  @JsonAnySetter
  public void add(String key, Object value)
  {
    ext.put(key, value);
  }

}
