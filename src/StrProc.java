

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
		
		for(int i=0; i<ds.getChatText().length(); i++)
		{
			if(BWTable.Table[ds.getChatText().charAt(i)].size()!=0) 
			{
				//BWTable.Table[ds.getChatText().charAt(i)] : 해당글자로시작하는 스트링들의 어레이리스트
				for(int j=0; j<BWTable.Table[ds.getChatText().charAt(i)].size(); j++) //해당 글자로 시작하는 어레이리스트의 사이즈만큼 돈다
				{
					if((ds.getChatText().length()-i) >= BWTable.Table[ds.getChatText().charAt(i)].get(j).length()) //남은 글자가 비교대상 사이즈보다 크거나같으면
					{
						int count=1;
						for(int k=1; k<BWTable.Table[ds.getChatText().charAt(i)].get(j).length(); k++) //j번째  단어의 길이만큼 반복
						{
							//BWTable.Table[ds.getChatText().charAt(i)].get(j) : 그 어레이리스트의 j번째 단어
							if(BWTable.Table[ds.getChatText().charAt(i)].get(j).charAt(k) != ds.getChatText().charAt(i+k) )
							{
								break;
							}
							else
								count++;
						}
						if (count== BWTable.Table[ds.getChatText().charAt(i)].get(j).length()) //모든글자가 맞음
						{
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
