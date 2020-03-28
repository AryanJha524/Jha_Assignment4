
public class Application {

	public static void main(String[] args) {
		
		DuplicateCounter d1 = new DuplicateCounter();
		d1.count("problem2.txt");
		d1.write("unique_word_counts.txt");
	}

}
