package mil.nasic.catalog.types;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The EventType registry is where to register a class as an event. Java does
 * not make it easy to get all classes on a class path for an annotation. There
 * are utilities such as scannotations or reflections, but even these do not
 * work in all situations (such as dynamic class loading from a server url).
 * Therefor, each class must be individually registered.
 * 
 * @author jcstewart
 *
 */
public class EventTypeRegistry {

	private static final Logger log = LoggerFactory.getLogger(EventTypeRegistry.class);

	private static final Map<String, Class<? extends Event>> typeMap = new HashMap();
	
	//register package types
	static{
		registerClass(CatalogEvent.class);		
		registerClass(FeatureEvent.class);
		registerClass(FileErrorEvent.class);
		registerClass(FileIdentifiedEvent.class);
		registerClass(LocationAddEvent.class);
		registerClass(LocationRemoveEvent.class);
		registerClass(MetaEvent.class);
		registerClass(MetaErrorEvent.class);
		registerClass(NewDataEvent.class);
	}

	public static void registerClass(Class<? extends Event> eventClass) {
		typeMap.put(findType(eventClass), eventClass);
	}

	public static Class<? extends Event> getClassForType(String type) {
		return typeMap.get(type);
	}

	public static String findType(Class<? extends Event> eventClass) {
		EventType type = (EventType) eventClass.getAnnotation(EventType.class);
		if (type == null) {
			throw new IllegalArgumentException(eventClass.getName() + " has no EventType annotation");
		}
		return type.type();
	}

}
