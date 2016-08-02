package mil.nasic.catalog.types;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	private String name;
	private String uri;
	private Long fileSize;

	private ZonedDateTime validStart;
	private ZonedDateTime validEnd;

	private String compression;
	private String md5;
	private String sha1;

	private Map<String, Object> ext = new HashMap();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@JsonAnyGetter
	public Map<String, Object> getExt() {
		return ext;
	}

	@JsonAnySetter
	public void add(String key, Object value) {
		ext.put(key, value);
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public ZonedDateTime getValidStart() {
		return validStart;
	}

	public void setValidStart(ZonedDateTime validStart) {
		this.validStart = validStart;
	}

	public ZonedDateTime getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(ZonedDateTime validEnd) {
		this.validEnd = validEnd;
	}

	public String getCompression() {
		return compression;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

}
