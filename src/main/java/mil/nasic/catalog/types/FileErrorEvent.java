package mil.nasic.catalog.types;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class FileErrorEvent extends Event {

	@JsonUnwrapped
	private FileErrorInfo fileError;

	public FileErrorInfo getFileError() {
		return fileError;
	}

	public void setFileError(FileErrorInfo fileError) {
		this.fileError = fileError;
	}

}