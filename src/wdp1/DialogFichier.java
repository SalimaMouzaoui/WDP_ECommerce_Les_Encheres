package wdp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class DialogFichier {
	File fichier;
	String nomFile;
	String pathFile;
    public DialogFichier(){
    	
	JFileChooser dialogue = new JFileChooser(".");
	//ChoixFichier();
	dialogue.setFileFilter(filter);
	if (dialogue.showOpenDialog(null)== 
	    JFileChooser.APPROVE_OPTION) {
	    fichier = dialogue.getSelectedFile();
	    nomFile = fichier.getName();
	    pathFile = fichier.getAbsolutePath();
	}
    }
    
    private FileFilter filter;
	 
	/*public void ChoixFichier() {
	
		filter = new FileFilter() {
 
			@Override
			public String getDescription() {
				return "Fichiers .tsp ";
			}
 
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) return true;
				if(f.getName().endsWith("tsp")) return true;
				return false;
			}
		};
 
	}
 */
	public String readFile(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String ligne;
			StringBuffer fichier = new StringBuffer();
 
			while((ligne = reader.readLine()) != null){
				fichier.append(ligne);
				fichier.append("\n");			
			}
			reader.close();
 
			return fichier.toString();		
		} catch (IOException e) {
			return e.getMessage();
		}
	}
	
}