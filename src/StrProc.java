

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
				//BWTable.Table[ds.getChatText().charAt(i)] : �ش���ڷν����ϴ� ��Ʈ������ ��̸���Ʈ
				for(int j=0; j<BWTable.Table[ds.getChatText().charAt(i)].size(); j++) //�ش� ���ڷ� �����ϴ� ��̸���Ʈ�� �����ŭ ����
				{
					if((ds.getChatText().length()-i) >= BWTable.Table[ds.getChatText().charAt(i)].get(j).length()) //���� ���ڰ� �񱳴�� ������� ũ�ų�������
					{
						int count=1;
						for(int k=1; k<BWTable.Table[ds.getChatText().charAt(i)].get(j).length(); k++) //j��°  �ܾ��� ���̸�ŭ �ݺ�
						{
							//BWTable.Table[ds.getChatText().charAt(i)].get(j) : �� ��̸���Ʈ�� j��° �ܾ�
							if(BWTable.Table[ds.getChatText().charAt(i)].get(j).charAt(k) != ds.getChatText().charAt(i+k) )
							{
								break;
							}
							else
								count++;
						}
						if (count== BWTable.Table[ds.getChatText().charAt(i)].get(j).length()) //�����ڰ� ����
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
