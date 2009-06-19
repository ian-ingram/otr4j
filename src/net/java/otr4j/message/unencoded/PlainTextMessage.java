package net.java.otr4j.message.unencoded;

import java.util.Vector;

import net.java.otr4j.message.MessageType;

public final class PlainTextMessage extends DiscoveryMessageBase {

	private PlainTextMessage() {
		super(MessageType.PLAINTEXT);
	}

	public String cleanText;
	
	public PlainTextMessage (String msgText) {
		this();
		Vector<Integer> versions = new Vector<Integer>();
		
		String cleanText = msgText;
		if (msgText.contains(WhiteSpaceTag.BASE))
		{
			cleanText = cleanText.replace(WhiteSpaceTag.BASE, "");
			// We have a base tag
			if (msgText.contains(WhiteSpaceTag.V1))
			{
				cleanText = cleanText.replace(WhiteSpaceTag.V1, "");
				versions.add(1);
			}
			
			if (msgText.contains(WhiteSpaceTag.V2))
			{
				cleanText = cleanText.replace(WhiteSpaceTag.V2, "");
				versions.add(2);
			}
		}
		
		this.versions = versions;
		this.cleanText = cleanText;
	}
}