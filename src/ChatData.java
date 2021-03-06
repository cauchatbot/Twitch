
public class ChatData
{
	private String userID;
	private String userNickName;
	private String chatText;
	private boolean isBadword;
	private boolean isNamed;
	private boolean havetoDisplay_Named;
	
	public ChatData(String userID, String userNickName, String chatText)
	{
		this.userID = userID;
		this.userNickName = userNickName;
		this.chatText = chatText;
		this.isBadword = false;
		this.isNamed = false;
		this.havetoDisplay_Named = false;
	}
	public String getChatText()
	{
		return chatText;
	}
	public String getUserID()
	{
		return userID;
	}
	public String getUserNickName()
	{
		return userNickName;
	}
	public boolean getIsBadword()
	{
		return isBadword;
	}
	public void setIsBadword(boolean isBadword)
	{
		this.isBadword=isBadword;
	}
	public void setIsNamed(boolean isNamed)
	{
		this.isNamed = isNamed;
	}
	public boolean getIsNamed()
	{
		return isNamed;
	}
	public void setHavetoDisplay_Named(boolean tf)
	{
		this.havetoDisplay_Named = tf;
	}
	public boolean getHavetoDisplay_Named()
	{
		return havetoDisplay_Named;
	}
}
