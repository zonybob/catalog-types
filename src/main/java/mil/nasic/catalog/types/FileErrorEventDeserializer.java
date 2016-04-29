package mil.nasic.catalog.types;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Provides wrapping of the file error info
 * @author jcstewart
 *
 */
public class FileErrorEventDeserializer extends JsonDeserializer<FileErrorEvent> {

	@Override
	public FileErrorEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		FileErrorInfo err = oc.treeToValue(node, FileErrorInfo.class);

		FileErrorEvent ferr = new FileErrorEvent();
		ferr.setFileError(err);

		return ferr;
	}
}