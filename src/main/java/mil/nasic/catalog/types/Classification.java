package mil.nasic.catalog.types;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author jcstewart
 * @version 0.2
 */
public class Classification {

	private String marking;

	private String classification;

	private String ownerProducer;

	@JsonInclude(Include.NON_EMPTY)
	private List<String> classificationReason = new ArrayList();
	@JsonInclude(Include.NON_EMPTY)
	private List<String> classifiedBy = new ArrayList();
	private ZonedDateTime declassDate;
	@JsonInclude(Include.NON_EMPTY)
	private List<String> sciControls = new ArrayList();
	@JsonInclude(Include.NON_EMPTY)
	private List<String> disseminationControls = new ArrayList();
	@JsonInclude(Include.NON_EMPTY)
	private List<String> fgiSourceOpen = new ArrayList();
	@JsonInclude(Include.NON_EMPTY)
	private List<String> realeasableTo = new ArrayList();

	private Map<String, Object> ext = new HashMap();

	public Classification() {
		super();
	}

	public Classification(String marking, String classification, String ownerProducer, String classificationReason,
			String classifiedBy, ZonedDateTime declassDate, String sciControls, String disseminationControls,
			String fgiSourceOpen, String realeasableTo, Map<String, Object> ext) {
		super();
		this.marking = marking;
		this.classification = classification;
		this.ownerProducer = ownerProducer;
		this.classificationReason.add(classificationReason);
		this.classifiedBy.add(classifiedBy);
		this.declassDate = declassDate;
		this.sciControls.add(sciControls);
		this.disseminationControls.add(disseminationControls);
		this.fgiSourceOpen.add(fgiSourceOpen);
		this.realeasableTo.add(realeasableTo);
		this.ext = ext;
	}

	public Classification(String marking, String classification, String ownerProducer,
			List<String> classificationReason, List<String> classifiedBy, ZonedDateTime declassDate,
			List<String> sciControls, List<String> disseminationControls, List<String> fgiSourceOpen,
			List<String> realeasableTo, Map<String, Object> ext) {
		super();
		this.marking = marking;
		this.classification = classification;
		this.ownerProducer = ownerProducer;
		this.classificationReason = classificationReason;
		this.classifiedBy = classifiedBy;
		this.declassDate = declassDate;
		this.sciControls = sciControls;
		this.disseminationControls = disseminationControls;
		this.fgiSourceOpen = fgiSourceOpen;
		this.realeasableTo = realeasableTo;
		this.ext = ext;
	}

	public Classification(String marking) {
		super();
		this.marking = marking;
	}

	public String getMarking() {
		return marking;
	}

	public void setMarking(String marking) {
		this.marking = marking;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getOwnerProducer() {
		return ownerProducer;
	}

	public void setOwnerProducer(String ownerProducer) {
		this.ownerProducer = ownerProducer;
	}

	public ZonedDateTime getDeclassDate() {
		return declassDate;
	}

	public void setDeclassDate(ZonedDateTime declassDate) {
		this.declassDate = declassDate;
	}

	public List<String> getClassificationReason() {
		return classificationReason;
	}

	public void addClassificationReason(String classificationReason) {
		this.classificationReason.add(classificationReason);
	}

	public List<String> getClassifiedBy() {
		return classifiedBy;
	}

	public void addClassifiedBy(String classifiedBy) {
		this.classifiedBy.add(classifiedBy);
	}

	public List<String> getSciControls() {
		return sciControls;
	}

	public void addSciControl(String sciControl) {
		this.sciControls.add(sciControl);
	}

	public List<String> getDisseminationControls() {
		return disseminationControls;
	}

	public void addDisseminationControl(String dissemControl) {
		this.disseminationControls.add(dissemControl);
	}

	public List<String> getFgiSourceOpen() {
		return fgiSourceOpen;
	}

	public void addFgiSourceOpen(String fgiSourceOpen) {
		this.fgiSourceOpen.add(fgiSourceOpen);
	}

	public List<String> getRealeasableTo() {
		return realeasableTo;
	}

	public void addRealeasableTo(String relTo) {
		this.realeasableTo.add(relTo);
	}

	@JsonAnyGetter
	public Map<String, Object> getExt() {
		return ext;
	}

	@JsonAnySetter
	public void add(String key, Object value) {
		ext.put(key, value);
	}

	public static class Builder {
		private String marking;

		private String classification;

		private String ownerProducer;

		@JsonInclude(Include.NON_EMPTY)
		private List<String> classificationReason = new ArrayList();
		@JsonInclude(Include.NON_EMPTY)
		private List<String> classifiedBy = new ArrayList();
		private ZonedDateTime declassDate;
		@JsonInclude(Include.NON_EMPTY)
		private List<String> sciControls = new ArrayList();
		@JsonInclude(Include.NON_EMPTY)
		private List<String> disseminationControls = new ArrayList();
		@JsonInclude(Include.NON_EMPTY)
		private List<String> fgiSourceOpen = new ArrayList();
		@JsonInclude(Include.NON_EMPTY)
		private List<String> realeasableTo = new ArrayList();

		private Map<String, Object> ext = new HashMap();

		public Builder marking(String marking) {
			this.marking = marking;
			return this;
		}

		public Builder classification(String classification) {
			this.classification = classification;
			return this;
		}

		public Builder ownerProducer(String ownerProducer) {
			this.classification = ownerProducer;
			return this;
		}

		public Builder classificationReason(List<String> classificationReason) {
			this.classificationReason = classificationReason;
			return this;
		}

		public Builder classifiedBy(List<String> classifiedBy) {
			this.classifiedBy = classifiedBy;
			return this;
		}

		public Builder declassDate(ZonedDateTime declassDate) {
			this.declassDate = declassDate;
			return this;
		}

		public Builder sciControls(List<String> sciControls) {
			this.sciControls = sciControls;
			return this;
		}

		public Builder disseminationControls(List<String> disseminationControls) {
			this.disseminationControls = disseminationControls;
			return this;
		}

		public Builder fgiSourceOpen(List<String> fgiSourceOpen) {
			this.fgiSourceOpen = fgiSourceOpen;
			return this;
		}

		public Builder realeasableTo(List<String> realeasableTo) {
			this.realeasableTo = realeasableTo;
			return this;
		}
		
		public Builder add(String key, Object value) {
			ext.put(key, value);
			return this;
		}

		public Classification build() {
			return new Classification(marking, classification, ownerProducer, classificationReason, classifiedBy,
					declassDate, sciControls, disseminationControls, fgiSourceOpen, realeasableTo, ext);
		}
	}

}
