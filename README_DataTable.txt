##��� ����

DataTable
	- ä���� ���͸��ϱ� ���� �ʿ��� �����͸� �����ϴ� Ŭ�����̴�.
	- BWTable(�弳), namedList(������ / Ÿ��Ʈ����), myList(�� �濡 �ִ� named), safeURLList(ä�ÿ��� ��� ������ URL ���)�� ArrayList�� ���� �ִ�.
	- BWTable�� ArrayList<String>[], �� �̿��� ����Ʈ���� ArrayList<String> ���̴�. �̴� ���� keyword�� ���� ������ �����ִ� BWTable������ Ž���� �ٸ� �Ϳ� ���� ������ �ϱ� �����̴�.
	- �����͵��� ������ �ؽ�Ʈ���Ͽ� ����Ǿ� ������ File I/O�� ������� �����ȴ�.
	-  ������ ����Ʈ�� ���� �߰�, ���� ����� �����Ǿ� �ִ�.

##Methods
	DataProc.getDataTable.SetBWTable();
	DataProc.getDataTable.SetNamedList();
	DataProc.getDataTable.SetSafeURLList();
		 : "BADWORD.txt", "NAMED.txt", "URL.txt"�� �� ������ �о�� ��̸���Ʈ�� �ۼ��Ѵ�.
	
	DataProc.getDataTable.AddToBWTable(Vector<String> newWords);
	DataProc.getDataTable.AddToNamedList(Vector<String> newUser);
	DataProc.getDataTable.AddToURLList(Vector<String> newURL);
		: ������ ����Ʈ�� String���� �ִ��� Ȯ���ϰ�, ���� �� �߰��Ѵ�. / �ؽ�Ʈ���Ͽ��� �߰��Ѵ�.

	DataProc.getDataTable.DeleteFromBWTable(Vector<String> deleteWords);
	DataProc.getDataTable.DeleteFromNamedList(Vector<String> deleteUser);
	DataProc.getDataTable.DeleteFromURLList(Vector<String> deleteURL);
		: ������ ����Ʈ�� String���� �ִ��� Ȯ���ϰ�, ���� �� �����Ѵ�. / �ؽ�Ʈ���Ͽ����� �����Ѵ�.


##��� ���
	���� 1) DataProc.getDataTable.SetBWTable(); // "BADWORD.txt"�� ������ �޾Ƶ鿩 BWTable�� �����Ѵ�.
	���� 2) DataProc.getDataTable.AddToNamedList(newUser); // newUser�� ��Ʈ�� ���͸� ���ڷ� ��, �̵��� ������ ����Ʈ�� �ֳ� Ȯ���ϰ� �ߺ����� ���� �� �̵��� �����ϰ� �߰��� ������ ������ ���ӵ帮��Ʈ�� ������Ѵ�.
	���� 3) DataProc.getDataTable.DeleteFromURLList(deleteURL); // deleteURL�� ��Ʈ�� ���͸� ���ڷ� ��, �̵��� ������ ����Ʈ�� �ֳ� Ȯ���ϰ� ���� �� �̵��� �ؽ�Ʈ���ϰ� safeURLList���� �����Ѵ�.


##�ؽ�Ʈ���� ����
	- �̿�Ǵ� �ؽ�Ʈ���ϵ��� UTF-8 �������� ���ڵ� �Ǿ��ִ� �ؽ�Ʈ ������ ����� �����Ѵ�.
	- �ؽ�Ʈ������ �� ������ ���� ������ ����� �Ѵ�.
	- �ؽ�Ʈ���Ͽ� ���� �������� ������ ������� �ʴ´�. (���α׷� ���� Add / Delete ��� �̿��� �����Ѵ�.)