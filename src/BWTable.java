package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class BWTable{
	public ArrayList<String>[] Table;
	
	public BWTable(){
		this.Table = new ArrayList[65536];
		for(int i = 0; i<65536; i++){
			Table[i] = new ArrayList<String>();
		}
		File file = new File("hangel.txt");
		try{
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while((line = bufReader.readLine()) != null){
				Table[(int)(line.charAt(0))].add(line);
			}
			bufReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("file not found");
	        // TODO: handle exception
	    }catch(IOException e){
	        System.out.println(e);
	    }
	}
	
	public void AddWords(Vector<String> newWords)
	{
		this.Table = new ArrayList[65536];
		for(int i = 0; i<65536; i++){
			Table[i] = new ArrayList<String>();
		}
		
		File file = new File("hangel.txt");
		FileWriter writer = null;
				
		try{
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while((line = bufReader.readLine()) != null){
				Table[(int)(line.charAt(0))].add(line);
			}
			bufReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("file not found");
	        // TODO: handle exception
	    }catch(IOException e){
	        System.out.println(e);
	    }
	    
	    
	    for(int i = 0; i < newWords.size(); i++){
	    	int index = Table[newWords.get(i).charAt(0)].indexOf(newWords.get(i));
	    	if(index == -1){
				try{
//					System.out.println("중복되지 않음");
					writer = new FileWriter(file, true);
					writer.write(newWords.get(i) + "\n");
					Table[newWords.get(i).charAt(0)].add(newWords.get(i));
					writer.flush();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				finally{
					try{
						if(writer != null) writer.close();
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
			}
		}
		
		public void DeleteWords(Vector<String> deleteWords)
		{
			this.Table = new ArrayList[65536];
			for(int i = 0; i<65536; i++){
				Table[i] = new ArrayList<String>();
			}
		
			File file = new File("hangel.txt");
			
				
			try{
				FileReader filereader = new FileReader(file);
				BufferedReader bufReader = new BufferedReader(filereader);
				String line = "";
				while((line = bufReader.readLine()) != null){
					Table[(int)(line.charAt(0))].add(line);
				}
				bufReader.close();
			}catch (FileNotFoundException e) {
				System.out.println("file not found");
	    	    // TODO: handle exception
	   	 }catch(IOException e){
	    	    System.out.println(e);
	   	 }
	    
	    for(int i = 0; i < deleteWords.size(); i++){
	    	int index = Table[deleteWords.get(i).charAt(0)].indexOf(deleteWords.get(i));
	    	if(index != -1){
					Table[deleteWords.get(i).charAt(0)].remove(deleteWords.get(i));	
			}
		}
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("hangel.txt", true));
			for(int i = 0; i < 65536; i++){
   	 	  	  for(int j = 0; j < Table[i].size(); j++){
           		writer.write(Table[i].get(j));
            	writer.newLine();
            	writer.flush();
				}
			}
			writer.close();
		}
		catch(IOException e){
		}
		
	}
	
	
	/****사용예시
	public static void main(String args[]){
		Vector<String> test = new Vector<String>(3);
		test.add("테스트1");
		test.add("테스트2");
		BWTable aTable = new BWTable();
		//aTable.AddWords(test);
		aTable.DeleteWords(test);
		
		for(int i = 0; i < 65536; i++){
			for(int j = 0; j< aTable.Table[i].size(); j++){
				System.out.println(aTable.Table[i].get(j));
			}
		}
	}
	
	*********/
}