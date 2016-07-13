package mil.nasic.catalog.types;

import java.util.HashMap;
import java.util.Map;

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
public class MessageTypeRegistry {

	private static final Logger log = LoggerFactory.getLogger(MessageTypeRegistry.class);

	private static final Map<String, Class> typeMap = new HashMap();

	// register package types
	static {
		registerClass(CatalogMessage.class);
		registerClass(FileIdentifiedMessage.class);
		registerClass(NewDataMessage.class);
		registerClass(LocationAddMessage.class);
		registerClass(LocationRemoveMessage.class);

	}

	public static void registerClass(Class eventClass) {
		typeMap.put(findType(eventClass), eventClass);
	}

	public static Class getClassForType(String type) {
		return typeMap.get(type);
	}

	public static String findType(Class eventClass) {
		MessageType type = (MessageType) eventClass.getAnnotation(MessageType.class);
		if (type == null) {
			throw new IllegalArgumentException(eventClass.getName() + " has no EventType annotation");
		}
		return type.type();
	}

}
