package mil.nasic.catalog.types;

import java.util.UUID;

import org.joda.time.DateTime;

public class Header
{

  private DateTime     time;
  private String       id;
  private ProducerInfo producer;

  public Header()
  {
    super();
  }

  public Header(DateTime time, String id, ProducerInfo producer)
  {
    super();
    this.time = time;
    this.id = id;
    this.producer = producer;
  }

  public DateTime getTime()
  {
    return time;
  }

  public void setTime(DateTime time)
  {
    this.time = time;
  }

  public ProducerInfo getProducer()
  {
    return producer;
  }

  public void setProducer(ProducerInfo producer)
  {
    this.producer = producer;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public static class Builder
  {
    private DateTime             time     = new DateTime();
    private String               id       = UUID.randomUUID().toString();
    private ProducerInfo.Builder producer = new ProducerInfo.Builder();

    public Header build()
    {
      return new Header(time, id, producer.build());
    }

    public Header.Builder id(String id)
    {
      id = id;
      return this;
    }

    public Header.Builder time(DateTime time)
    {
      this.time = time;
      return this;
    }

    public Header.Builder producer(ProducerInfo.Builder producer)
    {
      this.producer = producer;
      return this;
    }

    public Header.Builder producername(String name)
    {
      producer.name(name);
      return this;
    }

    public Header.Builder producernode(String node)
    {
      producer.node(node);
      return this;
    }

    public Header.Builder producerversion(String version)
    {
      producer.version(version);
      return this;
    }

  }

}
