package wdp1;

import java.io.File;

public class directory {

//	public String readDirectory()
	public static void main(String [] args)
	{
		String f = "";
		String nomF = "instance";
        File file = new File(nomF);
    
      try {
        //On parcourt la liste des fichiers et répertoires
        for(File nom : file.listFiles()){
          //S'il s'agit d'un dossier, on ajoute un "/"
        	 f = ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName());
        	 System.out.println("f = " + f);
        }
      } catch (NullPointerException e) {
        //L'instruction peut générer une NullPointerException
        //s'il n'y a pas de sous-fichier !
      }
   //   return f;
    } 
}
          