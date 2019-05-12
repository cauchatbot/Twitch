

public class StrProc
{
	tempDS ds;
	BWTable BWTable;
	
	public StrProc(tempDS ds, BWTable BWTable)
	{
		this.ds = ds;
		this.BWTable = BWTable;
	}
	
	private void checkBadword()
	{
		ds.setIsBadword(false);
		
		for(int i=0; i<ds.getChatText().length(); i++) //repeat for input string size times
		{
			if(BWTable.Table[(int)(ds.getChatText().charAt(i))].size()!=0) //Is there a bad word which have input(i) for first character?
			{
				for(int j=0; j<BWTable.Table[(int)(ds.getChatText().charAt(i))].size(); j++) // repeat for Table[input(i)]'s size times
				{
					if((ds.getChatText().length()-i) >= BWTable.Table[(int)(ds.getChatText().charAt(i))].get(j).length())
						//the left characters are not enough to become a selected bad word.
					{
						int count=1;
						for(int k=1; k<BWTable.Table[(int)(ds.getChatText().charAt(i))].get(j).length(); k++)
							//compare input strings with selected bad word
						{
							if(BWTable.Table[(int)(ds.getChatText().charAt(i))].get(j).charAt(k) != ds.getChatText().charAt(i+k) )
							{
								break;
							}
							else
								count++;
						}
						if (count== BWTable.Table[(int)(ds.getChatText().charAt(i))].get(j).length())
						{
							System.out.println(BWTable.Table[(int)(ds.getChatText().charAt(i))].get(j)); //searched bad word
							ds.setIsBadword(true);
							return;
						}
					}
				}
			}
		}
	}
}


class tempDS
{
	private String userID;
	private String userNickName;
	private String chatText;
	private Boolean isBadword;
	
	public tempDS(String userID, String userNickName, String chatText)
	{
		this.userID = userID;
		this.userNickName = userNickName;
		this.chatText = chatText;
		this.isBadword = false;
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
	public Boolean getIsBadword()
	{
		return isBadword;
	}
	public void setIsBadword(boolean isBadword)
	{
		this.isBadword=isBadword;
	}
}
