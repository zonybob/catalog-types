package mil.nasic.catalog.types;


import org.joda.time.DateTime;

public class MetaProducer
{

  private DateTime     time;
  private ProducerInfo producer;

  public MetaProducer()
  {
    super();
  }

  public MetaProducer(DateTime time, ProducerInfo producer)
  {
    super();
    this.time = time;
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

  public static class Builder
  {
    private DateTime             time     = new DateTime();
    private ProducerInfo.Builder producer = new ProducerInfo.Builder();

    public MetaProducer build()
    {
      return new MetaProducer(time, producer.build());
    }

    public MetaProducer.Builder time(DateTime time)
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
