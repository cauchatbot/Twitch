##기능 설명

DataTable
	- 채팅을 필터링하기 위해 필요한 데이터를 생성하는 클래스이다.
	- BWTable(욕설), namedList(유명인 / 타스트리머), myList(내 방에 있는 named), safeURLList(채팅에서 언급 가능한 URL 목록)의 ArrayList를 갖고 있다.
	- BWTable은 ArrayList<String>[], 그 이외의 리스트들은 ArrayList<String> 형이다. 이는 많은 keyword에 대한 정보를 갖고있는 BWTable에서의 탐색을 다른 것에 비해 빠르게 하기 위함이다.
	- 데이터들은 각각의 텍스트파일에 저장되어 있으며 File I/O의 방식으로 관리된다.
	-  각각의 리스트에 대한 추가, 삭제 기능이 구현되어 있다.

##Methods
	DataProc.getDataTable.SetBWTable();
	DataProc.getDataTable.SetNamedList();
	DataProc.getDataTable.SetSafeURLList();
		 : "BADWORD.txt", "NAMED.txt", "URL.txt"를 줄 단위로 읽어와 어레이리스트를 작성한다.
	
	DataProc.getDataTable.AddToBWTable(Vector<String> newWords);
	DataProc.getDataTable.AddToNamedList(Vector<String> newUser);
	DataProc.getDataTable.AddToURLList(Vector<String> newURL);
		: 각각의 리스트에 String들이 있는지 확인하고, 없을 시 추가한다. / 텍스트파일에도 추가한다.

	DataProc.getDataTable.DeleteFromBWTable(Vector<String> deleteWords);
	DataProc.getDataTable.DeleteFromNamedList(Vector<String> deleteUser);
	DataProc.getDataTable.DeleteFromURLList(Vector<String> deleteURL);
		: 각각의 리스트에 String들이 있는지 확인하고, 있을 시 삭제한다. / 텍스트파일에서도 삭제한다.


##사용 방법
	예시 1) DataProc.getDataTable.SetBWTable(); // "BADWORD.txt"의 정보를 받아들여 BWTable을 생성한다.
	예시 2) DataProc.getDataTable.AddToNamedList(newUser); // newUser의 스트링 벡터를 인자로 해, 이들이 기존의 리스트에 있나 확인하고 중복되지 않을 시 이들을 저장하고 추가된 정보를 포함한 네임드리스트를 재생성한다.
	예시 3) DataProc.getDataTable.DeleteFromURLList(deleteURL); // deleteURL의 스트링 벡터를 인자로 해, 이들이 기존의 리스트에 있나 확인하고 있을 시 이들을 텍스트파일과 safeURLList에서 삭제한다.


##텍스트파일 형식
	- 이용되는 텍스트파일들은 UTF-8 형식으로 인코딩 되어있는 텍스트 파일의 사용을 권장한다.
	- 텍스트파일의 맨 마지막 줄은 내용이 없어야 한다.
	- 텍스트파일에 대한 수동적인 수정은 권장되지 않는다. (프로그램 상의 Add / Delete 기능 이용을 권장한다.)