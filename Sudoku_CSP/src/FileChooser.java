import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Allows a user to select a file and returns the file selected
 * @author main
 *
 */
public class FileChooser {
	
	/**
	 * Returns the file chosen by the user
	 * @return
	 */
	public static File getFile(){
		File fileSelected = null;
		JFileChooser fc = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    "TXT files", "txt");
		
		fc.setFileFilter(filter);
		
		int returnVal = fc.showOpenDialog(fc);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		   fileSelected = fc.getSelectedFile();
		}
		
		return fileSelected;
	}
}
