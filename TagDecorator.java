package assignment6;

public class TagDecorator implements IHTML{
	protected IHTML tag;
	protected String decoratorTag;
	
	public TagDecorator(IHTML tag, String decoratorTag) {
		this.tag = tag;
		this.decoratorTag = decoratorTag;
	}
	
	@Override
	public String getTag() {
		return "<" + decoratorTag + ">" + tag.getTag() + "</" + decoratorTag + ">";
	}
}
