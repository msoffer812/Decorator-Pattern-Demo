package assignment6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		String cont = "";
		Scanner in = new Scanner(System.in);
		List<String> nonTakenDecoratorTags;
		/*
		 * I use input validation methods so often just put it all in a class
		 */
		InputValidator input = new InputValidator(in);
		do {
			nonTakenDecoratorTags = getList();
			IHTML tag = getTag(input);
			String addDecoratorTag = input.getStringInput("press 1 to add another decorator tag, any other key otherwise:");
			while(addDecoratorTag.equals("1") && nonTakenDecoratorTags.size()>0) {
				tag = addDecoratorTag(tag, input, nonTakenDecoratorTags);
				addDecoratorTag = input.getStringInput("press 1 to add another decorator tag, any other key otherwise:");
			}
			System.out.println(tag.getTag());
			cont = input.getStringInput("Press 1 to decorate a new tag, any other key to exit");
		}while(cont.equals("1"));
		System.out.println("Goodbye");
		in.close();
		System.exit(0);
	}
	
	public static List<String> getList() {
		List<String> decoratorTags = new ArrayList<>();
		decoratorTags.add("em");
		decoratorTags.add("strong");
		decoratorTags.add("i");
		decoratorTags.add("u");
		decoratorTags.add("small");
		decoratorTags.add("a");
		return decoratorTags;
	}
	
	public static IHTML addDecoratorTag(IHTML tag, InputValidator input, List<String> nonTakenTags){
		String menu = getTagMenu(nonTakenTags);
		int choice = input.getIntInput(menu, 1, nonTakenTags.size()) - 1;
		int aIndex = nonTakenTags.indexOf("a");
		
		if(choice == aIndex) {
			nonTakenTags.remove(choice);
			String link = input.getStringInput("Enter the link for the href:");
			IHTML newTag = new ATagDecorator(tag, "a", link);
			return newTag;
		}
		String tagName = nonTakenTags.get(choice);
		nonTakenTags.remove(choice);
		
		return new TagDecorator(tag, tagName);
	}
	
	public static String getTagMenu(List<String> nonTakenTags) {
		int count = 1;
		StringBuilder menu = new StringBuilder();
		for(String tag: nonTakenTags) {
			menu.append(count + ". ");
			menu.append(tag);
			menu.append("\n");
			count++;
		}
		return menu.toString();
	}
	
	public static IHTML getTag(InputValidator input) {
		int choice= input.getIntInput("Choose a tag type: \n1.div\n2.p\n3.h\n4.input", 1, 4);
		return getTagSpecs(input, choice);
	}
	
	public static IHTML getTagSpecs(InputValidator input, int tag) {
		String text = input.getStringInput("Enter the text you want to be in the tag:");
		
		String name = input.getStringInput("Press 1 to add a name, any other key otherwise:");
		if(name.equals("1")) {
			name = input.getStringInput("Enter the name value: ");
		}
		
		String id = input.getStringInput("Press 1 to add an id, any other key otherwise:");
		if(id.equals("1")) {
			id = input.getStringInput("Enter the id value: ");
		}
		
		Tag htmlTag = null;
		if(tag == 1 || tag == 2) {
			if(tag == 1) {
				htmlTag = new Tag("div", text);
			}else if(tag == 2) {
				htmlTag = new Tag("p", text);
			}
			setTagSpecs(id, name, htmlTag);
			return htmlTag;
		}
		if(tag == 3) {
			return getHSpecs(input, name, id, text);
		}
		
		return getInputSpecs(input, name, id, text);
	}
	
	public static IHTML getHSpecs(InputValidator input, String name, String id, String text) {
		int type = input.getIntInput("Enter an h value from 1 to 6:", 1, 6);
		HTag tag = new HTag(text, type);
		setTagSpecs(id, name, tag);
		return tag;
	}
	
	public static Tag getInputSpecs(InputValidator input, String name, String id, String text) {
		InputTag tag = new InputTag(text);
		setTagSpecs(id, name, tag);
		
		String event = input.getStringInput("Press 1 to add an event, any other key otherwise:");
		if(event.equals("1")) {
			String eventType = input.getStringInput("Enter the event type: ");
			event = input.getStringInput("Enter the event type: ");
			tag.setEvent(eventType, event);
		}
		
		String type = input.getStringInput("Press 1 to add an type, any other key otherwise:");
		if(type.equals("1")) {
			type = input.getStringInput("Enter the type value: ");
			tag.setType(type);
		}
		
		String value = input.getStringInput("Press 1 to add an value, any other key otherwise:");
		if(value.equals("1")) {
			value = input.getStringInput("Enter the value value: ");
			tag.setValue(value);
		}
		return tag;
	}
	public static void setTagSpecs(String id, String name, Tag tag) {
		if(id.length() > 0) {
			tag.setID(id);
		}
		if(name.length()>0) {
			tag.setName(name);
		}
	}
}
