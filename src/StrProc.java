

public class StrProc
{
	//���̺� �޾ƿ���
	
	public StrProc(tempDS ds)
	{
		
	}
}


class tempDS
{
	private String userID;
	private String userNickName;
	private String chatText;
	private Boolean isBadword;
	
	public tempDS(String userID, String userNickName, String chatText, Boolean isBadword)
	{
		this.userID = userID;
		this.userNickName = userNickName;
		this.chatText = chatText;
		this.isBadword = isBadword;
	}
	public void checkBadword()
	{
		for(int i=0; i<chatText.length(); i++)
		{
			//���� BWtable.table[chatText[i]].length()!=0�̸�
			//	BWtable.table[chatText[i]] �� ArrayList�ȿ��� chatText+1��° ���ں��� ��
			//		�� :
			//					for(int j=0; j<ArrayList.size(); j++)
			//					{
			//						if(ArrayList.get(j).length<chatText.length()-i)
			//						{
			//							
			//
			
			
		}
	}
}
