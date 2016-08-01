package mil.nasic.catalog.types;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Source
{
  private Map<String, Object> ext = new HashMap();
  private String              fileName;
  private String              fileFormat;
  private String              fileSource;
  private Long                fileSize;
  private String              productId;
  private String              sensor;
  private String              agency;
  private String              uri;
  private String              sha1Hash;
  private ZonedDateTime       deliveryTime;
  private ZonedDateTime       discoveredTime;

  @JsonAnySetter
  public void add(String key, Object value)
  {
    ext.put(key, value);
  }

  public String getAgency()
  {
    return agency;
  }

  public ZonedDateTime getDeliveryTime()
  {
    return deliveryTime;
  }

  public ZonedDateTime getDiscoveredTime()
  {
    return discoveredTime;
  }

  @JsonAnyGetter
  public Map<String, Object> getExt()
  {
    return ext;
  }

  public String getFileFormat()
  {
    return fileFormat;
  }

  public String getFileName()
  {
    return fileName;
  }

  public String getFileSource()
  {
    return fileSource;
  }

  public String getProductId()
  {
    return productId;
  }

  public String getSensor()
  {
    return sensor;
  }

  public String getUri()
  {
    return uri;
  }

  public void setAgency(String agency)
  {
    this.agency = agency;
  }

  public void setDeliveryTime(ZonedDateTime deliveryTime)
  {
    this.deliveryTime = deliveryTime;
  }

  public void setDiscoveredTime(ZonedDateTime discoveredTime)
  {
    this.discoveredTime = discoveredTime;
  }

  public void setFileFormat(String fileFormat)
  {
    this.fileFormat = fileFormat;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  public void setFileSource(String fileSource)
  {
    this.fileSource = fileSource;
  }

  public void setProductID(String productId)
  {
    this.productId = productId;
  }

  public void setSensor(String sensor)
  {
    this.sensor = sensor;
  }

  public void setUri(String uri)
  {
    this.uri = uri;
  }

  public Long getFileSize()
  {
    return fileSize;
  }

  public void setFileSize(Long fileSize)
  {
    this.fileSize = fileSize;
  }

  public String getSha1Hash()
  {
    return sha1Hash;
  }

  public void setSha1Hash(String sha1Hash)
  {
    this.sha1Hash = sha1Hash;
  }

}
