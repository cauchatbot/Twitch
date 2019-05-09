

public class StrProc
{
	//테이블 받아오기
	
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
			//만약 BWtable.table[chatText[i]].length()!=0이면
			//	BWtable.table[chatText[i]] 의 ArrayList안에서 chatText+1번째 글자부터 비교
			//		비교 :
			//					for(int j=0; j<ArrayList.size(); j++)
			//					{
			//						if(ArrayList.get(j).length<chatText.length()-i)
			//						{
			//							
			//
			
			
		}
	}
}
