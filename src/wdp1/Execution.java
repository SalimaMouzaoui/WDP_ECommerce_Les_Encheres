package wdp1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Execution {
		
	        int nbre_offres , nbre_objets ;
	        double gain, tpsExec;
	        ArrayList<Integer> alloc = new ArrayList<Integer>();

	        public void lectureFile(String nomFile, traitement t) throws IOException
	        {
	        	t.lecture_fich(nomFile); //in101 test.txt 
	        	nbre_offres = t.getNbreOffres();
	        	nbre_objets = t.getNbreObjets();
	        	//System.out.println("nbVar = " + nbre_objets+ " et nbClauses = " + nbre_offres);
	        }
	        
	        public int getNbOffres()
			{
				return this.nbre_offres;
			}
	        public int getNbObjets()
			{
				return this.nbre_objets;
			}
	        public double getTempsExec()
			{
				return this.tpsExec;
			}
		
	        public ArrayList<Integer> execute(String nomMethod, traitement t)
	        {
	        	    if (nomMethod.equals("SLS"))
	        	    {
	        	    recup[] tabSolVoisine = new recup[500];
	        	//	for (int k = 0; k < 20; k++)
	        	//	{
					this.gain = t.calculGain(alloc);
					long startTime = System.currentTimeMillis();
					recup[] tab = t.RechercheLocaleStochastique();
					tpsExec = System.currentTimeMillis() - startTime;
					int numMaxGain = t.calculNumMaxPrixOffre(tab, 0, tab.length); // le meilleur
					
					for (int i = 0; i < tab.length; i++)
					{
						if (i == numMaxGain)
					for (int j = 0; j < tab[i].tab_objets.size(); j++)
					{
						alloc.add(tab[i].tab_objets.get(j));
					}
					}
					ArrayList<Integer> objets = new ArrayList<Integer>();
					for (int j = 0; j < alloc.size(); j++)
					{
						objets.add(alloc.get(j));
					}
				/*	tabSolVoisine[k] = new recup(t.calculGain(alloc), objets);
	        		}
	        		int numMaxGain = t.calculNumMaxPrixOffre(tabSolVoisine, 0, tabSolVoisine.length); // le meilleur
	        		for (int i = 0; i < tabSolVoisine.length; i++)
	        		{
	        			if (i == numMaxGain)
	        		for (int j = 0; j < tabSolVoisine[i].tab_objets.size(); j++)
	        		{
	        			alloc.add(tabSolVoisine[i].tab_objets.get(j));
	        		}
	        		}
	        		*/
	        		gain = t.calculGain(alloc);
	        	    }
	        	    else if (nomMethod.equals("TS"))
	        	    {
	        	    	long startTime = System.currentTimeMillis();
	        	    	alloc = t.TabuSearch();
	        	    	tpsExec = System.currentTimeMillis() - startTime;
	        	    	gain = t.calculGain(alloc);
	        	    }
	        	    else if (nomMethod.equals("NV"))
	        	    {
	        	    	long startTime = System.currentTimeMillis();
	        	    	recup[] tab = t.naive();
	        	    	tpsExec = System.currentTimeMillis() - startTime;
	        	    	int numMaxGain = t.calculNumMaxPrixOffre(tab, 0, tab.length); // le meilleur
	        			for (int i = 0; i < tab.length; i++)
	        			{
	        				if (i == numMaxGain)
	        			for (int j = 0; j < tab[i].tab_objets.size(); j++)
	        			{
	        				alloc.add(tab[i].tab_objets.get(j));
	        			}
	        			}
	        			gain = t.calculGain(alloc);
	        	    }
					return alloc;
	        }
	        
	        public double getGain()
	        {
	        	return this.gain;
	        }
	        
	        public String getOffreGagnates()
	        {
	        	String txt = new String();
	        	for (int j = 0; j < alloc.size(); j++)
    			{
	        			txt += txt.valueOf(alloc.get(j) + " ");
	        	}
	        	
	        	return txt;
	        }
	        public String[] getOffrePerdantes()
	        {
	        	String txt = new String();
	        	String t[] = new String[nbre_offres/10];
	        	int k = 0 , i = 0;
	        	for (int j = 0; j < nbre_offres; j++)
    			{
	        		if (k == 10)
	        		{
	        			t[i] = txt;
	        			i++;
	        			k = 0;
	        			txt = new String();
	        		}
	        		else
	        		{
	        			if ( !alloc.contains(j) ){
	        			txt += txt.valueOf(j + " ");
	        			k++;}
	        		}	        		
    			}
	        	/*
	        	for (int j = 0; j < t.length; j++)
    			{
	        		System.out.println(t[j]);
    			}
    			*/
	        	return t;
	        }
	}


