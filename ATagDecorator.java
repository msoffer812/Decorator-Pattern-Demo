package assignment6;

public class ATagDecorator extends TagDecorator{
	protected String link;
	
	public ATagDecorator(IHTML tag, String decoratorTag, String link) {
		super(tag, decoratorTag);
		this.link = " href=\"" + link + "\"";
	}
	
	@Override
	public String getTag() {
		return "<" + decoratorTag + link + ">" + tag.getTag() + "</" + decoratorTag + ">";
	}
}
