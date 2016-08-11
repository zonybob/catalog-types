package mil.nasic.catalog.types;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeUtils {

	public static Object merge(Object precedent, Object secondary) throws Exception {
		if (precedent.getClass() != secondary.getClass())
			return null;
		
		ObjectNode head = buildTree(precedent.getClass());
		
		Object newObj = mergeObjects(head, precedent, secondary);
		
		return newObj;
	}
	
	private static Object mergeObjects(ObjectNode on, Object precedent, Object secondary) throws Exception{
		if(precedent == null)
			return secondary;
		else if(secondary == null)
			return precedent;
		if(on.getChildren() == null)
			return (precedent != null ? precedent : secondary);
		
		Object parent = precedent;
		
		List<ObjectNode> children = on.getChildren();
		Iterator<ObjectNode> lstIt = children.iterator();
		
		while (lstIt.hasNext()){
			ObjectNode curObjectNode = lstIt.next();
			if (curObjectNode.getGetter() == null || curObjectNode.getSetter() == null)
				return precedent;
			curObjectNode.getSetter().invoke(parent, (mergeObjects(curObjectNode, curObjectNode.getGetter().invoke(precedent), curObjectNode.getGetter().invoke(secondary))));
		}
		
		return parent;
	}
	
	private static ObjectNode buildTree(Class<?> curClass){
		ObjectNode head = new ObjectNode();
		head.setMyClass(curClass);
		
		//System.out.println("CLASS = "+curClass.getName());
		
		Field[] fields = curClass.getDeclaredFields();
		for (Field curField : fields){
			Method getter = getMethodByPrefix("get", curClass.getMethods(), curField);
			Method setter = getMethodByPrefix("set", curClass.getMethods(), curField);
			if(getter == null || setter == null)
				continue;
			//System.out.println(curField.getName());
			ObjectNode curObjectNode = buildTree(curField.getType());
			curObjectNode.setGetter(getter);
			curObjectNode.setSetter(setter);
			curObjectNode.setMe(curField);
			head.addChild(curObjectNode);
		}
		
		return head;
	}
	
	private static Method getMethodByPrefix(String prefix, Method[] methods, Field curField){
		Method method = null;
		for (Method curMethod : methods) {
			if (curMethod.getName().startsWith(prefix.toLowerCase())
					&& curMethod.getName().length() == (curField.getName().length() + 3)) {
				if (curMethod.getName().toLowerCase().endsWith(curField.getName().toLowerCase())) {
					method = curMethod;
					break;
				}
			}
		}
		return method;
	}

	private static class ObjectNode {
		private Method getter;
		private Method setter;
		private Field me;
		private Class<?> myClass;
		private List<ObjectNode> children;

		public Method getGetter() {
			return getter;
		}

		public void setGetter(Method getter) {
			this.getter = getter;
		}

		public Method getSetter() {
			return setter;
		}

		public void setSetter(Method setter) {
			this.setter = setter;
		}

		public Field getMe() {
			return me;
		}

		public void setMe(Field me) {
			this.me = me;
		}

		public Class<?> getMyClass() {
			return myClass;
		}

		public void setMyClass(Class<?> myClass) {
			this.myClass = myClass;
		}

		public List<ObjectNode> getChildren() {
			return children;
		}

		public void setChildren(List<ObjectNode> children) {
			this.children = children;
		}
		
		public void addChild(ObjectNode child){
			if (this.children == null)
				this.children = new LinkedList<ObjectNode>();
			this.children.add(child);
		}
		
		public void printNode(String indent){
			System.out.println("Test");
		}
	}
}
