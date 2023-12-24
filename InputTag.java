package assignment6;

public class InputTag extends Tag{
	public InputTag(String text) {
		super("input", text);
	}
	public void setType(String val) {
		attributes.put("type", " type=\"" + val + "\"");
		adjustAttributesAsString();
	}
	public void setEvent(String type, String val) {
		attributes.put("event", type + "=\"" + val + "\"");
		adjustAttributesAsString();
	}
	public void setValue(String val) {
		attributes.put("value", " value=\"" + val + "\"");
		adjustAttributesAsString();
	}
}
