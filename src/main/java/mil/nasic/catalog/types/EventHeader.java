package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class EventHeader {

    private DateTime time;
    private String guid;
    private List<String> parent_id = new ArrayList();
    private ProducerInfo producer;
    private Map<String, Object> ext = new HashMap();

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public List<String> getParent_id() {
        return parent_id;
    }

    public void addParentId(String id) {
        parent_id.add(id);
    }

    public void setParent_id(List<String> parent_id) {
        this.parent_id = parent_id;
    }

    public ProducerInfo getProducer() {
        return producer;
    }

    public void setProducer(ProducerInfo producer) {
        this.producer = producer;
    }

    @JsonAnyGetter
    public Map<String, Object> getExt() {
        return ext;
    }

    @JsonAnySetter
    public void add(String key, Object value) {
        ext.put(key, value);
    }

}
