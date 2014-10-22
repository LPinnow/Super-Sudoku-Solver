import java.io.File;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File puzzleFile = null;
		puzzleFile = FileChooser.getFile();
		if (puzzleFile != null)
			System.out.println(puzzleFile.getName());
		else
			System.out.println("No file selected.");
	}

}
