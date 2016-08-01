package mil.nasic.catalog.types;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Meta
{

  private Source              source;
  private ZonedDateTime       start;
  private ZonedDateTime       end;
  private List<String>        tags = new ArrayList();
  private GeoJsonObject       geom;
  private Classification      classification;
  private MetaProducer        metaProducer;
  private Tasking             tasking;

  public Tasking getTasking()
  {
    return tasking;
  }

  public void setTasking(Tasking tasking)
  {
    this.tasking = tasking;
  }

  private Map<String, Object> ext  = new HashMap();

  public Source getSource()
  {
    return source;
  }

  public void setSource(Source source)
  {
    this.source = source;
  }

  public ZonedDateTime getStart()
  {
    return start;
  }

  public void setStart(ZonedDateTime start)
  {
    this.start = start;
  }

  public ZonedDateTime getEnd()
  {
    return end;
  }

  public void setEnd(ZonedDateTime end)
  {
    this.end = end;
  }

  public List<String> getTags()
  {
    return tags;
  }

  public void addTags(String tag)
  {
    tags.add(tag);
  }

  public GeoJsonObject getGeom()
  {
    return geom;
  }

  public void setGeom(GeoJsonObject geom)
  {
    this.geom = geom;
  }

  public Classification getClassification()
  {
    return classification;
  }

  public void setClassification(Classification classification)
  {
    this.classification = classification;
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

  public MetaProducer getMetaProducer()
  {
    return metaProducer;
  }

  public void setMetaProducer(MetaProducer metaProducer)
  {
    this.metaProducer = metaProducer;
  }

}
