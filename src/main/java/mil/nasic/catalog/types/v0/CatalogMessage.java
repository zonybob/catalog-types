/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.nasic.catalog.types.v0;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;

/**
 *
 * @author bmcdonie
 */
public class CatalogMessage {

	private List<Header> headers;

	private Events events;

	private Document document;

	private String version;

	public CatalogMessage() {
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public static CatalogMessage fromString(String json) throws IOException {
		return new ObjectMapper().registerModules(new JsonOrgModule(), new JodaModule()).readValue(json,
				CatalogMessage.class);
	}

	public static CatalogMessage fromStream(InputStream is) throws IOException {
		return new ObjectMapper().registerModules(new JsonOrgModule(), new JodaModule()).readValue(is,
				CatalogMessage.class);
	}

	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().registerModules(new JsonOrgModule(), new JodaModule()).writeValueAsString(this);
	}

	@JsonIgnore
	public URL getStagePathToDataFile() throws MalformedURLException, ParseException {
		Location loc = this.getDocument().getLocations().stream()
				.filter(l -> l.getType().equals("stage") && l.isValid()).findFirst().orElse(null);
		if (loc != null) {
			return new URL(loc.getUri());
		} else {
			throw new ParseException("Unable to parse valid stage location from message", -1);
		}

	}

	public void addHeader(Header h) {
		if (headers == null) {
			headers = new ArrayList<>();
		}
		headers.add(h);
	}

	@JsonIgnore
	public Header getLastHeader() {
		return headers.isEmpty() ? null : headers.get(headers.size() - 1);
	}
}
