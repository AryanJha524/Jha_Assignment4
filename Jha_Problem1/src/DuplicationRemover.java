import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.nio.file.Paths;


public class DuplicationRemover {
	
	//creating the instance variable to store unique words
	private Set<String> uniqueWords = new HashSet<String>();
	private String word;
	
	public void remove (String dataFile)
	{
		try(Scanner input = new Scanner(Paths.get(dataFile)))
		{
			//adding words to set while file still has words to it
			while (input.hasNext())
			{
				//we use the lower case version of words to prevent duplication due to case
				uniqueWords.add(input.next().toLowerCase());
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
		//creating a formatter object to output to a file
		try(Formatter output = new Formatter(outputFile))
		{
			//Looping through all the elements in our Set of Strings and storing them in the file
			for (String words: uniqueWords)
			{
				output.format("%s %n", words);
			}
		}
		
		//catching all the potential errors that may occur from writing to a file
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
