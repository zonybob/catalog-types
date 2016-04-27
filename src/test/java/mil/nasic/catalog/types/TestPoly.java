package mil.nasic.catalog.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

import junit.framework.Assert;

/**
 * No long using polymorphism for events, instead an Event can contain
 * "event qualifiers" by existance or non-existance of a property.
 * 
 * @author jcstewart
 *
 */
public class TestPoly {

	@Test
	public void testPoly() throws Exception {
		String json = IOUtils.toString(TestPoly.class.getResourceAsStream("poly.json"));
		
		EventHolder holder = CatalogJsonUtils.readObject(json, EventHolder.class);

		Assert.assertEquals(2, holder.events.size());

		for (BaseObj obj : holder.events) {
			if (obj instanceof SpecialObj) {
				SpecialObj spob = (SpecialObj) obj;
				Assert.assertEquals("sp", obj.getType());
				Assert.assertEquals("thingy", obj.getExt().get("another"));
				Assert.assertEquals(15, spob.getSpecial());
				Assert.assertEquals(13, spob.getBase());
			} else {
				Assert.assertEquals("stupid", obj.getType());
				Assert.assertEquals(12, obj.getBase());
				Assert.assertEquals("thing", obj.getExt().get("other"));
			}
		}

		String out = CatalogJsonUtils.writeObject(holder);
		Assert.assertFalse(out.contains("type"));

	}

	public static class EventHolder {
		private List<BaseObj> events = new ArrayList();

		public EventHolder() {
		}

		public List<BaseObj> getEvents() {
			return events;
		}

		public void addEvents(BaseObj ev) {
			events.add(ev);
		}
	}

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type", include = JsonTypeInfo.As.WRAPPER_OBJECT, defaultImpl = BaseObj.class)
	// @JsonSubTypes({ @Type(value = SpecialObj.class, name = "sp") })
	@JsonTypeIdResolver(BaseObjectTypeIdResolver.class)
	public static class BaseObj {
		private int base;
		private Map<String, Object> ext = new HashMap();

		private String type;

		public BaseObj() {
		}

		public int getBase() {
			return base;
		}

		public void setBase(int base) {
			this.base = base;
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
		public String getType() {
			return type;
		}

		@JsonProperty
		public void setType(String type) {
			this.type = type;
		}

	}

	public static class SpecialObj extends BaseObj {
		private int special;

		public int getSpecial() {
			return special;
		}

		public void setSpecial(int special) {
			this.special = special;
		}

	}

	public static class BaseObjectTypeIdResolver implements TypeIdResolver {

		private JavaType mBaseType;

		public BaseObjectTypeIdResolver() {
		}

		@Override
		public void init(JavaType baseType) {
			mBaseType = baseType;
		}

		@Override
		public Id getMechanism() {
			return Id.CUSTOM;
		}

		@Override
		public String idFromValue(Object obj) {
			return ((BaseObj) obj).getType();
		}

		@Override
		public String idFromBaseType() {
			return "na";
		}

		@Override
		public String idFromValueAndType(Object obj, Class<?> clazz) {
			return ((BaseObj) obj).getType();
		}

		@Override
		public JavaType typeFromId(String type) {
			Class<?> clazz = null;
			if ("sp".equals(type)) {
				clazz = SpecialObj.class;
			} else {
				clazz = BaseObj.class;
			}
			return TypeFactory.defaultInstance().constructSpecializedType(mBaseType, clazz);
		}

		@Override
		public JavaType typeFromId(DatabindContext context, String id) {

			return typeFromId(id);
		}

	}

}
