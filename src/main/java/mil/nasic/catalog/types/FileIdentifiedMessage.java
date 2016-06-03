package mil.nasic.catalog.types;

@MessageType(type = "fileIdentified")
public class FileIdentifiedMessage 
{

  private String dataType;

  private Source source;

  public FileIdentifiedMessage()
  {

  }

  public Source getSource()
  {
    return source;
  }

  public void setSource(Source source)
  {
    this.source = source;
  }

  public String getDataType()
  {
    return dataType;
  }

  public void setDataType(String dataType)
  {
    this.dataType = dataType;
  }

}
