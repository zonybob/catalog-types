package mil.nasic.catalog.types;


import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MetaProducer
{

  private ZonedDateTime     time;
  private ProducerInfo producer;

  public MetaProducer()
  {
    super();
  }

  public MetaProducer(ZonedDateTime time, ProducerInfo producer)
  {
    super();
    this.time = time;
    this.producer = producer;
  }

  public ZonedDateTime getTime()
  {
    return time;
  }

  public void setTime(ZonedDateTime time)
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

  public static class Builder
  {
    private ZonedDateTime             time     = ZonedDateTime.now(ZoneId.of("UTC"));
    private ProducerInfo.Builder producer = new ProducerInfo.Builder();

    public MetaProducer build()
    {
      return new MetaProducer(time, producer.build());
    }

    public MetaProducer.Builder time(ZonedDateTime time)
    {
      this.time = time;
      return this;
    }

    public MetaProducer.Builder producer(ProducerInfo.Builder producer)
    {
      this.producer = producer;
      return this;
    }

    public MetaProducer.Builder producername(String name)
    {
      producer.name(name);
      return this;
    }

    public MetaProducer.Builder producernode(String node)
    {
      producer.node(node);
      return this;
    }

    public MetaProducer.Builder producerversion(String version)
    {
      producer.version(version);
      return this;
    }

  }

}
