package mil.nasic.catalog.types;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CatalogJsonUtils {

    private static ObjectMapper mapper;

    private static synchronized void init() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.disable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
        }
    }

    public static ObjectMapper getMapper() {
        if (mapper == null) {
            init();
        }
        return mapper;
    }

    public static <T> T readObject(String json, Class<T> clazz) throws JsonProcessingException, IOException {
        return getMapper().readValue(json, clazz);
    }

    public static <T> T readObject(InputStream in, Class<T> clazz) throws JsonProcessingException, IOException {
        return getMapper().readValue(in, clazz);
    }

    public static String writeObject(Object o) throws JsonProcessingException, IOException {
        return getMapper().writeValueAsString(o);
    }

    public static void writeObject(Object o, OutputStream os) throws JsonProcessingException, IOException {
        // mapper will flush
        getMapper().writeValue(os, o);
    }

    public static boolean areJsonFormsEqual(Object o1, Object o2) throws JsonProcessingException, IOException {
        String sr1 = getMapper().writeValueAsString(o1);
        String sr2 = getMapper().writeValueAsString(o2);

        JsonNode n1 = mapper.readTree(sr1);
        JsonNode n2 = mapper.readTree(sr2);

        return n1.equals(n2);
    }

    /**
     * Iterates all the fields in the json in apply, and adds them to the
     * original json.
     * 
     * @param orig
     * @param apply
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */

    public static String mergeJson(String orig, String update) throws JsonProcessingException, IOException {
        return mergeJson(orig, update, false);
    }

    public static String mergeJson(String orig, String update, boolean applyNulls) throws JsonProcessingException, IOException {
        ObjectNode origNode = (ObjectNode) getMapper().readTree(orig);
        ObjectNode updateNode = (ObjectNode) getMapper().readTree(update);

        return getMapper().writeValueAsString(mergeJsonNode(origNode, updateNode, applyNulls));
    }

    /**
     * 
     * @param mainNode
     * @param updateNode
     * @return
     */
    public static JsonNode mergeJsonNode(ObjectNode mainNode, ObjectNode updateNode) {
        return mergeJsonNode(mainNode, updateNode, false);
    }

    /**
     * 
     * @param mainNode
     * @param updateNode
     * @param applyNulls
     * @return
     */
    public static JsonNode mergeJsonNode(ObjectNode mainNode, ObjectNode updateNode, boolean applyNulls) {

        Iterator<String> fieldNames = updateNode.fieldNames();
        while (fieldNames.hasNext()) {

            String fieldName = fieldNames.next();
            JsonNode newNode = updateNode.get(fieldName);
            JsonNode currNode = mainNode.get(fieldName);

            if (newNode.isNull() && !applyNulls) {
                continue;
            }

            if (currNode == null) {
                mainNode.set(fieldName, newNode);
                continue;
            }

            if (currNode instanceof ObjectNode) {
                if (!(newNode instanceof ObjectNode)) {
                    // may not update an Object to anything else, other than
                    // null
                    if (!newNode.isNull()) {
                        throw new IllegalArgumentException("cannot update " + currNode.getClass().getName() + " to "
                                + newNode.getClass().getName());
                    }
                    mainNode.set(fieldName, NullNode.getInstance());
                    continue;
                }

                mergeJsonNode((ObjectNode) currNode, (ObjectNode) newNode, applyNulls);
                continue;
            }

            // in this implementation, all other changes are permitted
            // although changing a value to a container could have consequences
            mainNode.set(fieldName, newNode);

        }

        return mainNode;
    }

}
