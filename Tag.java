package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tag implements IHTML{
	protected String tagName;
	protected String text;
	protected Map<String, String> attributes;
	StringBuilder attributesAsString;
	
	public Tag(String tagName, String text) {
		this.tagName = tagName;
		this.text = text;
		attributes = new HashMap<>();
	}
	
	public void setName(String val) {
		attributes.put("name", " name=\"" + val + "\"");
		adjustAttributesAsString();
	}
	
	protected void adjustAttributesAsString() {
		attributesAsString = new StringBuilder();
		for(String attr : attributes.values()) {
			attributesAsString.append(attr);
		}
	}
	public void setID(String val) {
		attributes.put("id", " id=\"" + val + "\"");
		adjustAttributesAsString();
	}
	
	@Override
	public String getTag() {
		return "<" + tagName + attributesAsString.toString() + ">" + text + "</" + tagName + ">";
	}
}
