package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonProperty;

@EventType(type = "file_identified")
public class FileIdentifiedEvent extends Event {

	@JsonProperty("data_type")
	private String dataType;

	private FileInfo file;
	
	public FileIdentifiedEvent(){
		
	}

	public FileInfo getFile() {
		return file;
	}

	public void setFile(FileInfo file) {
		this.file = file;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
