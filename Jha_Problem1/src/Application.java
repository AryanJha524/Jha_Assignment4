
public class Application {

	public static void main(String[] args) {
		
		//creating an instance of the duplicate remover
		DuplicationRemover d1 = new DuplicationRemover();
		
		d1.remove("problem1.txt");
		d1.write("unique_words.txt");
		
	}

}
