package mil.nasic.catalog.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define the type of an event. This is used when serializing to
 * know the wrapping field name of the event.
 * 
 * @author jcstewart
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
public @interface EventType {
	String type();
}
