import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	
	private  HashMap<String,Integer> wordCounter = new HashMap<String,Integer>(); 
	private String words;
	
	
	public void count(String dataFile)
	{
		//write words from the file into a hashmap and increment word counter everytime a duplicate is encountered
		try(Scanner input = new Scanner(Paths.get(dataFile)))
		{
			while(input.hasNext())
			{
				words = input.next().toLowerCase();
				
				if (wordCounter.containsKey(words) == true)
				{
					wordCounter.replace(words, wordCounter.get(words) + 1);
				}
				else if (wordCounter.containsKey(words) == false)
				{
					wordCounter.put(words, 1);
				}
				
			}
		}
	
		//Adding the potential errors that might occur with reading data from a file
		catch (FileNotFoundException e)
		{
			System.out.println("Sorry, file not found. Terminating...");
			System.exit(1);
		
		}
		
		catch (IOException e) 
		{
			System.out.println("Error processing file. Terminating...");
			System.exit(1);
		}
	}
	
	public void write(String outputFile)
	{

		try(Formatter output = new Formatter(outputFile))
		{
			
			for (Map.Entry mapElement : wordCounter.entrySet()) { 
	            String key = (String)mapElement.getKey(); 
	  
	            int value = ((int)mapElement.getValue());
	            
	            output.format("%s occurs %d times %n", key, value); 
	        } 
		}
		
		catch (SecurityException e)
		{
			System.out.println("Sorry, you do not have permission to write to the file. Terminating...");
			System.exit(1);
		}
		
		catch (FileNotFoundException e1) 
		{
			System.out.println("Sorry, file not found. Terminating...");
			System.exit(1);
		} 
		
		catch (FormatterClosedException e)
		{
			System.out.println("Error processing file. Terminating...");
			System.exit(1);
		}
		
		
	}
	
	
	
	
	

}
