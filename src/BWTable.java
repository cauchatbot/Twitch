import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BWTable{
	public ArrayList<String>[] Table;
	
	public BWTable()
	{
		this.Table = new ArrayList[65536];
		for(int i = 0; i<65536; i++){
			Table[i] = new ArrayList<String>();
		}
		try{
			File file = new File("C:\\Users\\jiho\\eclipse-workspace\\KeywordTest\\hangel.txt");

			FileReader filereader = new FileReader(file);

			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while((line = bufReader.readLine()) != null){
				Table[(int)(line.charAt(0))].add(line);
				//System.out.println(line);
			}
			bufReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("file not found");
	        // TODO: handle exception
	    }catch(IOException e){
	        System.out.println(e);
	    }
	}
}