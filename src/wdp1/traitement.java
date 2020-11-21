package wdp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class traitement {
	
	double lamda = 0.00006;
	int p = 2;
	double wp = 0.3;
	int iterMaxTS = 200;
	int iterMaxSLS = 1000;
	int nb_offres, nb_objets;
	recup[] r;
	int[][] matriceAdjacence;
	double max;
	float[] somme;
	int[] position;
	int[] solutionInitiale;
	ArrayList <Double> aleat;
	int numoffre;
	int tailleTab = 0;
	int changed;
	
	void lecture_fich( String nomFich) throws IOException
	{
	    BufferedReader br;
	    int i = 0, j;
	     
	    try {
				br = new BufferedReader(new FileReader(nomFich));
				String lign = br.readLine(); // lire une ligne
				
				String temp[] = lign.split(" ");
				nb_objets = Integer.parseInt(temp[0]);
				nb_offres = Integer.parseInt(temp[1]);
				
				lign = br.readLine();
				temp = null;
				r = new recup[nb_offres];
				float prix_offre;
				
				while (lign != null ) {
					temp = lign.split(" ");
				    prix_offre = Float.parseFloat(temp[0]);
				    ArrayList<Integer> objets = new ArrayList<Integer>();
					for ( j = 1; j < temp.length; j++)
					{
						objets.add(Integer.parseInt(temp[j]));
					}
					r[i] = new recup(prix_offre, objets);
					i++;					
					lign = br.readLine();
				}
			} catch (IOException ioe) {
				// System.out.print("Erreur : ");
				ioe.printStackTrace();
				System.exit(1);
			}
		}

	public int[][] matriceAdjacence()
	{
		int i, j, k;
		recup[] tab = getRecup();

		matriceAdjacence = new int[nb_offres][nb_offres];
		for ( i = 0; i < tab.length - 1 ; i++) // parcours de la table d'hashage
		{
			for ( j = i + 1; j < tab.length ; j++)
		     {
					for (k = 0 ; k < tab[j].tab_objets.size(); k++)
					{
						if (tab[i].tab_objets.contains(tab[j].tab_objets.get(k)))
						{
					    	matriceAdjacence[i][j] = 1;
					    	matriceAdjacence[j][i] = 1;
						}
					}
			 }				
		}
	 return matriceAdjacence;
	}	
	
	public recup[] RechercheLocaleStochastique()
	{		
		matriceAdjacence = matriceAdjacence();  // graphe de conflit
		ArrayList<Integer> alloc = solutionInitiale(matriceAdjacence); // solution initiale selon le codage RK
		double re;
		int bid;
		recup[] tabSolVoisine = new recup[iterMaxSLS];
		int k = 0, l = 0;
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < nb_offres; i++)
			B.add(i);
		recup[] tabArchive = new recup[iterMaxSLS];
		for (int i = 0; i < iterMaxSLS; i++)
		{
			re = Math.random();
			if ( re < wp)
				/** Le premier critère consiste à choisir l'offre à considérer
                 d'une manière aléatoire avec une probabilité wp > 0.
                 */
			    bid = (int) Math.round( Math.random() * (nb_offres - 1));
			else
			{
				/**
				 * Le deuxième critère consiste à choisir, avec une
                   probabilité 1 - wp, la meilleure offre (celle maximisant
                   le gain du vendeur une fois insérée) pour
                   etre considérée.*/
				ArrayList<Integer> allocPrime = new ArrayList<Integer>();
				for (int j = 0; j < alloc.size(); j++)
				{
					allocPrime.add(alloc.get(j));
				}
				
				recup[] tab = verifGainAugmenter (B, allocPrime, matriceAdjacence);
				bid = calculNumMaxPrixOffre(tab, 0, tab.length); // le meilleur
			}
			
			if ( ! (alloc.contains(bid)) )// si l'offre choisi n'existe pas dans l'allocation déja 
		        allocApresOptimisation(alloc, bid, matriceAdjacence);
				
				 float gain = calculGain(alloc);
					ArrayList<Integer> objets = new ArrayList<Integer>();
					for (int j = 0; j < alloc.size(); j++)
					{
						objets.add(alloc.get(j));
					}
					tabSolVoisine[k] = new recup(gain, objets);
					k++;
		}		
		
		return tabSolVoisine;
	}
	
	private int gainFunction(double gainQ, double gain) {
		// TODO Auto-generated method stub
		if (gainQ < gain)
			return 1;
		else return 0;
	}

	void trierOffresCondidates(ArrayList<Integer> B) {
		// TODO Auto-generated method stub
		recup[] tab = getRecup();
		float[] t = new float[B.size()]; 
		for (int i = 0; i < B.size(); i++)
			t[i] = tab[B.get(i)].prix_offre;
		
		TriBulle(t, t.length);
		B.clear();
		for (int i = 0; i < t.length; i++)
		{
			for (int j = 0; j < tab.length; j++)
				if (t[i] == tab[j].prix_offre)
					B.add(j);
		}
	}
	
	void permutation(float[] tab, int i, int j)
	{
	   float temp;
	    temp = tab[i];
	    tab[i] = tab[j];
	    tab[j] = temp;
	}
	
	void TriBulle (float[] tab, int n)
	{
	int i, j;
	for (i=n-1; i>=0; i--)
	{
	   for (j=1; j<=i; j++)
	    {
	       if (tab[j-1] < tab[j]) permutation(tab, j-1, j);
	    }
	}
	}
	
	private recup[] verifGainAugmenter (ArrayList<Integer> B, ArrayList<Integer> alloc, int[][] matriceAdjacence) 
	{
		int k = 0;
		recup[] tabSolVoisine = new recup[nb_offres];
		
		for (int i = 0; i < B.size(); i++)
		{			
			ArrayList<Integer> allocPrime = new ArrayList<Integer>();
			for (int j = 0; j < alloc.size(); j++)
			{
				allocPrime.add(alloc.get(j));
			}
			
				if ( !(allocPrime.contains(i)) )
				
					allocPrime.add(i);
				
			float gain = calculGain(allocPrime);
			ArrayList<Integer> objets = new ArrayList<Integer>();
			for (int j = 0; j < allocPrime.size(); j++)
			{
				objets.add(allocPrime.get(j));
			}
			tabSolVoisine[k] = new recup(gain, objets);
			k++;
		}
		return tabSolVoisine;
	}
	
	int calculNumMaxPrixOffre(recup[] tab, int indicedbt, int k) 
	{
		// TODO Auto-generated method stub
		double max = 0;
		int numMax = -1;
		for ( int i = indicedbt; i < k; i++)
		{
			if (tab[i].prix_offre > max)
			{
				max = tab[i].prix_offre;
				numMax = i;
			}
		}
		return numMax;
	}

	private void allocApresOptimisation(ArrayList<Integer> alloc, int k, int[][] matriceAdjacence) 
	{		
		float gain = calculGain(alloc);
	    ArrayList<Integer> Q = new ArrayList<Integer>();
	    int i;
	    for (  i=0; i < alloc.size() && (matriceAdjacence[k][alloc.get(i)] == 0); i++);
		if (i == alloc.size())
			if ( ! alloc.contains(k))
			alloc.add(k);
	
	/*		for ( i = 0; i < alloc.size() ; i++)
		      {
				if (matriceAdjacence[k][alloc.get(i)] == 1) // i.e il existe un conflit
					Q.add(alloc.get(i));
			  }	
			float gainQ = calculGain(Q);
			
			int res = gainFunction(gainQ, gain);
			if (res == 1)
			{		
				System.out.println("here");
				if (!alloc.contains(k))
			for ( i = 0; i < Q.size(); i++)
			{
				if (alloc.contains(Q.get(i)))
					alloc.remove(Q.get(i));
			}
			alloc.add(k);
			}*/
			
    }

	public ArrayList<Integer> solutionInitiale(int[][] matriceAdjacence)
	{
		int nb = 500;
		recup[] tabSolVoisine = new recup[nb];
        for (int k = 0 ; k < nb; k++)
        {
    		ArrayList<Integer> alloc = new ArrayList<Integer>();
		    aleat = suiteAleatoire();
	
		for (int i = 0; i < nb_offres; i++)
		{
			numoffre = numOffreMax();
			if ( i == 0 )
				alloc.add(numoffre);
			else
			{
				int j;
				for ( j = 0; j < alloc.size() && (matriceAdjacence[numoffre][alloc.get(j)] == 0); j++);
			
			    	if (j == alloc.size())
						  alloc.add(numoffre);
			}					
		}
		float gain = calculGain(alloc);
		ArrayList<Integer> objets = new ArrayList<Integer>();
		for (int j = 0; j < alloc.size(); j++)
		{
			objets.add(alloc.get(j));
		}
		tabSolVoisine[k] = new recup(gain, objets);
        }
        
        int numMaxGain = calculNumMaxPrixOffre(tabSolVoisine, 0, tabSolVoisine.length); // le meilleur
		ArrayList<Integer> alloc = new ArrayList<Integer>();
		for (int i = 0; i < tabSolVoisine.length; i++)
		{
			if (i == numMaxGain)
		for (int j = 0; j < tabSolVoisine[i].tab_objets.size(); j++)
		{
			alloc.add(tabSolVoisine[i].tab_objets.get(j));
		}
		}
		return alloc;
	}
	
	public int numOffreMax()
	{
		max = aleat.get(0);
		numoffre = 0;
		for (int i = 0; i < aleat.size(); i++)
		{
			if (aleat.get(i) > max)
			{
				max = aleat.get(i);
				numoffre = i;
			}
		}
		aleat.set(numoffre, (double) -1);
		return numoffre;
	}
	
	public ArrayList <Double> suiteAleatoire()
	{
		aleat = new ArrayList <Double>(); 
		
		for (int i = 0; i< nb_offres; i++)
		{
			aleat.add(Math.random() * 1);
		}
		return aleat;
	}
	
	public float calculGain(ArrayList<Integer> alloc)
	{
		float gain = 0;
		recup[] tab = getRecup();
		
		for (int i = 0; i < alloc.size(); i++)
		{
			gain += tab[alloc.get(i)].prix_offre;
		}
		return gain;
	}
	
	public int[][] constructMatriceB()
	{
		int i, j;
		recup[] tab = getRecup();

		int[][] matriceB = new int[nb_objets][nb_offres];
		
		for ( j = 0; j < nb_offres ; j++)
	     {
			for ( i = 0; i < nb_objets ; i++)
				{
				if (tab[j].tab_objets.contains(i+1))				
					matriceB[i][j] = 1;				
			    }
		}
	 return matriceB;
	}	
	
	public recup[] naive()
	{
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < nb_offres; i++)
			B.add(i);
		int[][] matriceAdjacence = matriceAdjacence();
		trierOffresCondidates(B);
		
		recup[] tabSolVoisine = new recup[B.size()];
		int k;
		int m = 0;
		for (int i=0; i < B.size(); i++)
		{
			ArrayList<Integer> alloc = new ArrayList<Integer>();
			alloc.add(B.get(i));
			for (int j=0; j < B.size(); j++)
			{
				for ( k=0; k < alloc.size() && (matriceAdjacence[B.get(j)][alloc.get(k)] == 0); k++);
				if (k == alloc.size())
					if ( ! alloc.contains(B.get(j)))
					alloc.add(B.get(j));
			}
			float gain = calculGain(alloc);
		//	float gainI0 = 0;
		//	ArrayList<Integer> I0 = new ArrayList<Integer>();
		/*<	if (i > 2)
			{
				ArrayList<Integer> I1 = new ArrayList<Integer>();
				ArrayList<Integer> I2 = new ArrayList<Integer>();
				parentSelection(tabSolVoisine, m, I1, I2);
		        I0 = recombinationOperator(matriceAdjacence, I1, I2);
		        gainI0 = calculGain(I0);
		      /*  alloc.clear();
		        for (int j = 0; j < I0.size(); j++)
		        {
		        	alloc.add(I0.get(j));
		        }
		      */
		//	}
			
			ArrayList<Integer> objets = new ArrayList<Integer>();
		/*	if (gainI0 > gain)
			{
				System.out.println("gainI0 = " + gainI0);
				for (int j = 0; j < I0.size(); j++)
			    {
			    	objets.add(I0.get(j));
			    }
			    tabSolVoisine[m] = new recup(gainI0, objets);
				m++;
			}
			else 
			{
				System.out.println("gain = " + gain);
			*/	for (int j = 0; j < alloc.size(); j++)
			    {
			    	objets.add(alloc.get(j));
			    }
			    tabSolVoisine[m] = new recup(gain, objets);
				m++;
			//}
		}
		return tabSolVoisine;
	}
	
	public ArrayList<Integer> TabuSearch()
	{		
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < nb_offres; i++)
			B.add(i);
        
		int iter, opt;
		int[][] matriceAdjacence = matriceAdjacence();
		iter = 0;
		opt = 0;
		int l = 0;
		ArrayList<Integer> alloc = new ArrayList<Integer>();
		ArrayList<Integer> tabuListe = new ArrayList<Integer>();
		ArrayList<Integer> allocStar = new ArrayList<Integer>();
		ArrayList<Integer> loserBid = new ArrayList<Integer>();
		opt = 0;
		recup[] tabArchive = new recup[iterMaxTS/p];
		float gain = 0;
		
		while (iter < iterMaxTS)
		{
			ArrayList<Integer> allocPrime = new ArrayList<Integer>();
			 gain = calculGain(alloc);
		    double tt = tabuTenure(gain);
		    changed = 0;
			recup SolVoisine = constructSolVoisineOnItem(matriceAdjacence, alloc, B, 
					tabuListe, iter, tt, loserBid);
			
			if ( changed == 1 ) // Intensification Move
			{
				for (int j = 0; j < SolVoisine.tab_objets.size(); j++)
			    {
					allocPrime.add(SolVoisine.tab_objets.get(j));
			    }
			}
			else // Perturbation Move
			{
				recup r = perturbationMove(matriceAdjacence, alloc, B, 
						tabuListe, iter, tt, loserBid);
				for (int j = 0; j < r.tab_objets.size(); j++)
				{
					allocPrime.add(r.tab_objets.get(j));
				}
			}
			alloc.clear();
		   for (int j = 0; j < allocPrime.size(); j++)
			{
				alloc.add(allocPrime.get(j));
			}

		    gain = calculGain(alloc);
		    updateTabuListe(tabuListe, alloc);
		    updateB(B, tabuListe, loserBid);
		    if (gain > calculGain(allocStar))
		    {
				 allocStar.clear();
		    	for (int j = 0; j < alloc.size(); j++)
				{
					allocStar.add(alloc.get(j));
				}
		    	gain = calculGain(allocStar);
		    }
		    else opt++;
		    if (opt > p)
		    {
		    	gain = calculGain(allocStar);
		    	ArrayList<Integer> objets = new ArrayList<Integer>();
		    	for (int j = 0; j < allocStar.size();  j++)
		    	{
		    		objets.add(allocStar.get(j));
		    	}
		    	tabArchive[l] = new recup(gain, objets);
		    	l++;
		        ArrayList<Integer> I1 = new ArrayList<Integer>();
		        ArrayList<Integer> I2 = new ArrayList<Integer>();
		        parentSelection(tabArchive, l, I1, I2);
		        ArrayList<Integer> I0 = recombinationOperator(matriceAdjacence, I1, I2);
		        alloc.clear();
		        for (int j = 0; j < I0.size(); j++)
		        {
		        	alloc.add(I0.get(j));
		        }
		       opt = 0;
		    }
		    iter++;
		}		
		return allocStar;
	}
	
	private recup constructSolVoisineOnItem(int[][] matriceAdjacence, ArrayList<Integer> alloc, ArrayList<Integer> B,
			ArrayList<Integer> tabuListe, int iter, double tt, ArrayList<Integer> loserBid) {
		// TODO Auto-generated method stub
		int k = 0;
		recup[] tabSolVoisine = new recup[nb_offres];
		recup[] loser = new recup[nb_offres];
		trierOffresCondidates(B);
		float gainTotal = 0;
		float gain = 0, gainQ = 0;
		recup[] tab = getRecup();
		int h = 0;
		gainTotal = calculGain(alloc);
		for (int i = 0; i < B.size(); i++)
		{
			ArrayList<Integer> Q = new ArrayList<Integer>();
			ArrayList<Integer> allocTmp = new ArrayList<Integer>();
			
			for (int j = 0; j < alloc.size(); j++)
			{
				allocTmp.add(alloc.get(j));
			}
			
			ArrayList<Integer> allocBis = new ArrayList<Integer>();
			for (int j = 0; j < alloc.size(); j++)
			{
				allocBis.add(alloc.get(j));
			}
				ArrayList<Integer> allocPrime = new ArrayList<Integer>();
			if (tabuListe.contains(B.get(i)) )
			{
				   allocPrime = Aspiration(matriceAdjacence, allocBis, tabuListe, B.get(i), iter, tt);
			}	   
			else 
			{
			for (int j = 0; j < alloc.size(); j++)
			{
				allocPrime.add(alloc.get(j));
			}
				if (!(allocPrime.contains(B.get(i))))				
					allocPrime.add(B.get(i));
			}
			float gain1 = calculGain(allocPrime);
			
			if (gain1 > gainTotal)
			{
				for (int j = 0; j < allocPrime.size(); j++)
				{
					if (matriceAdjacence[B.get(i)][allocPrime.get(j)] == 1)	
					{
						Q.add(allocPrime.get(j));
					}
				}
			}
			gainQ = calculGain(Q);
			gain = tab[B.get(i)].prix_offre;
		
			int res = gainFunction(gainQ, gain);
				if (res == 1)
				{		
					if (!allocTmp.contains(B.get(i)))
					allocTmp.add(B.get(i));				
					changed = 1;
				}
				ArrayList<Integer> R = new ArrayList<Integer>();
			if (iter < tt)
			{
				 for (int j = 0; j < Q.size() ; j++)
					{
						if (allocTmp.contains(Q.get(j)))
								{
							        if (!tabuListe.contains(Q.get(j)))
							        {
							        	allocTmp.remove(Q.get(j));	
							        	R.add(Q.get(j));
							        	changed = 1;
							        }
							        else 
							        {
							        	if (allocTmp.contains(B.get(i)))
							        	allocTmp.remove(B.get(i));
							        	changed = 0;
							        	break;
							        }
								}
				   }
			}
			else 
			{
				for (int j = 0; j < Q.size(); j++)
				{
					if (allocTmp.contains(Q.get(j)))
					{
						allocTmp.remove(Q.get(j));
						R.add(Q.get(j));						
						changed = 1;
					}
			    }
			}
			if (R.size() > 0){
				 ArrayList<Integer> objets = new ArrayList<Integer>();
				 for (int j = 0; j < R.size() ; j++)
					{
						objets.add(R.get(j));
					}
					loser[h] = new recup(calculGain(objets), objets);
					h++;
				}
			gain = calculGain(allocTmp);
		    if (gain > gainTotal)
		    {
	         ArrayList<Integer> objets = new ArrayList<Integer>();
		    for (int j = 0; j < allocTmp.size(); j++)
		    {
		    	objets.add(allocTmp.get(j));
		    }
		    tabSolVoisine[k] = new recup(gain, objets);
			k++;
		    }
			tailleTab = k;
		}
		int numMaxGain = calculNumMaxPrixOffre(tabSolVoisine, 0, tailleTab);
		
		for (int i = 0; i < h; i++)
    	{
	 		if (i == numMaxGain){
    		for (int j = 0; j < loser[i].tab_objets.size(); j++)
    			loserBid.add(loser[i].tab_objets.get(j));
	 		}
    	}
		ArrayList<Integer> allocPrime = new ArrayList<Integer>();
		float gainF = 0;
		for (int i = 0; i < tailleTab; i++)
		{
			if (i == numMaxGain)
			{
				for (int j = 0; j < tabSolVoisine[i].tab_objets.size();  j++)
				{
					allocPrime.add(tabSolVoisine[i].tab_objets.get(j));
				}
				gainF = tabSolVoisine[i].prix_offre;
			}
    	}		
    	recup allocP = new recup(gainF, allocPrime);
    	
		return allocP;
	}
	private ArrayList<Integer> recombinationOperator(int[][] matriceAdjacence, 
			ArrayList<Integer> I1, ArrayList<Integer> I2) {
		// TODO Auto-generated method stub
		ArrayList<Integer> I0 = new ArrayList<Integer>();
		int D1 = -1;
		int D2 = -1;
		int i = 0;
		trierOffresCondidates(I1); // tri ascandant
		trierOffresCondidates(I2); // tri ascandant
		while ((!I1.isEmpty()) && (!I2.isEmpty())) 
		{
			D1 = I1.get(0); // first element of I1
			D2 = I2.get(0); // first element of I2
			if (!(I0.contains(D1)))
			{
			for (i = 0; i < I0.size() && (matriceAdjacence[D1][I0.get(i)] == 0); i++);
			       if (i == I0.size())
				        I0.add(D1);
			}
			if (!(I0.contains(D2)))
			{				
			for (i = 0; i < I0.size() && (matriceAdjacence[D2][I0.get(i)] == 0); i++);
				   if (i == I0.size())
						I0.add(D2);
			}
				  for (int j = 0 ; j < I1.size(); j++)
		    {
					  if (I1.get(j) == D1){
						  I1.remove(I1.get(j));
						  }
		    }
				   for (int j = 0 ; j < I2.size(); j++)
		    {
					   if (I2.get(j) == D2){
						   I2.remove(I2.get(j));
						   }
		    }
		}
		return I0;
	}

	private void parentSelection(recup[] tabArchive, int l, ArrayList<Integer> I1,
			          ArrayList<Integer> I2) {
		// TODO Auto-generated method stub

		int numMaxGain1 = calculNumMaxNombreOffre(tabArchive, l, 0);
		for (int i = 0; i < l; i++)
		{
			if (i == numMaxGain1)
			{
				for (int j = 0; j < tabArchive[i].tab_objets.size();  j++)
				{
					I1.add(tabArchive[i].tab_objets.get(j));
				}
				tabArchive[i].prix_offre = -1;
			}
    	}
    	
		int numMaxGain2 = calculNumMaxNombreOffre(tabArchive, l, 0);
    	
    	for (int i = 0; i < l; i++)
		{
			if (i == numMaxGain2)
			{
				for (int j = 0; j < tabArchive[i].tab_objets.size();  j++)
				{
					I2.add(tabArchive[i].tab_objets.get(j));
				}
			}
    	}
	}

	private int calculNumMaxNombreOffre(recup[] tabArchive, int l, int indicedbt) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		double max = 0;
		int numMax = 0;
		
		for ( int i = indicedbt; i < l; i++)
		{
			if (tabArchive[i].tab_objets.size() > max)
			{
				max = tabArchive[i].tab_objets.size();
				numMax = i;
			}
		}
		return numMax;
	}

	private void updateB(ArrayList<Integer> B, ArrayList<Integer> tabuListe, ArrayList<Integer> loserBid) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < tabuListe.size(); i++)
		{
			if (B.contains(tabuListe.get(i)))
				B.remove(tabuListe.get(i));
		}		
		for (int i = 0 ; i < loserBid.size(); i++)
			if (!(B.contains(loserBid.get(i))))
			B.add(loserBid.get(i));
	}

	public double tabuTenure(float gain)
	{
		int L = (int) Math.round( Math.random() * 9 );
		return L + lamda + gain;
	//	return 10;
	}
	
	private void updateTabuListe(ArrayList<Integer> tabuListe, ArrayList<Integer> alloc) 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < alloc.size(); i++)
			if (!tabuListe.contains(alloc.get(alloc.size() - 1)))
		        tabuListe.add(alloc.get(alloc.size() - 1));
	}
	
	private ArrayList<Integer> Aspiration(int[][] matriceAdjacence, ArrayList<Integer> alloc,
			ArrayList<Integer> tabuListe, int offreChoisie, int iter, double tt) 
	{
		// TODO Auto-generated method stub
		ArrayList<Integer> allocRes = new ArrayList<Integer>();
		float gainAvant = calculGain(alloc);
		ArrayList<Integer> Q = new ArrayList<Integer>();
		ArrayList<Integer> allocPr = new ArrayList<Integer>();
		for (int i = 0; i < alloc.size(); i++)
			allocPr.add(alloc.get(i));
		allocPr.add(offreChoisie);
		if (iter < tt)
		{
			for (int j = 0; j < allocPr.size() ; j++)
			{
				if ((matriceAdjacence[offreChoisie][allocPr.get(j)] == 1))
						{
					        if (!tabuListe.contains(allocPr.get(j)))
					        {	
					        	Q.add(allocPr.get(j));
					        }
					        else 
					        {
					        	if (allocPr.contains(offreChoisie))
					        		allocPr.remove(offreChoisie);
					        	break;
					        }
						}
			}
		}
		else 
		{
			for (int j = 0; j < allocPr.size() ; j++)
			{
				if (matriceAdjacence[offreChoisie][allocPr.get(j)] == 1)
				{
					Q.add(allocPr.get(j));
				}
			}
		}
		for (int j = 0; j < Q.size() ; j++)
		{
			if (allocPr.contains(Q.get(j)))
				allocPr.remove(Q.get(j));
		}
		if (calculGain(allocPr) > gainAvant)
			for (int j = 0; j < allocPr.size() ; j++)
				allocRes.add(allocPr.get(j));
		//	allocRes = allocPr;
		else for (int j = 0; j < alloc.size() ; j++)
			allocRes.add(alloc.get(j));
		return allocRes;
	}

	private recup perturbationMove(int[][] matriceAdjacence, ArrayList<Integer> alloc, 
			ArrayList<Integer> B, ArrayList<Integer> tabuListe, 
			int iter, double tt, ArrayList<Integer> loserBid) {
		// TODO Auto-generated method stub
		recup[] loser = new recup[nb_offres];
		ArrayList<Integer> allocPr = new ArrayList<Integer>();
		int offreAleat = (int) Math.round( Math.random() * (B.size() - 1));
		recup[] tabSolVoisine = new recup[nb_offres];
		float gainTotal = calculGain(alloc);
		float gain = 0;
		int k = 0;
		float gain0 = 0;
		recup allocP = new recup(gain, allocPr);
		int h = 0;
		{
				 ArrayList<Integer> allocTmp = new ArrayList<Integer>();
				 for (int j = 0; j < alloc.size(); j++)
				    {
					     allocTmp.add(alloc.get(j));
				    }
				 ArrayList<Integer> allocPrime = new ArrayList<Integer>();
	  if (!(allocTmp.contains(offreAleat)))
	   {
		 if (tabuListe.contains(offreAleat) )
		 {
			 allocPrime = Aspiration(matriceAdjacence, allocTmp, tabuListe, offreAleat, iter, tt);
	     }
		 else //if (! tabuListe.contains(offreAleat) )
		{
			for (int j = 0; j < alloc.size(); j++)
		    {
			     allocPrime.add(alloc.get(j));
		    }
		int j;
		
			if (!(allocPrime.contains(offreAleat)))
			{
				allocPrime.add(offreAleat);

				if (iter < tt)
				{
					for ( j = 0; j < allocPrime.size() ; j++)
					{
						if ((matriceAdjacence[offreAleat][allocPrime.get(j)] == 1))
								{
							        if (!tabuListe.contains(allocPrime.get(j)))
							        {
							        	allocPrime.remove(allocPrime.get(j));	
							        }
							        else 
							        {
							        	for ( j = 0; j < allocPrime.size() ; j++)
							        	{
							        	if (allocPrime.get(j) == offreAleat)
							        	{
							        		allocPrime.remove(allocPrime.get(j));
			                                break;
							        	}							        	
							        	}
							        }
								}
					}
				}
				else 
				{
					for ( j = 0; j < allocPrime.size() ; j++)
					{
						if (matriceAdjacence[offreAleat][allocPrime.get(j)] == 1)
						{
							allocPrime.remove(allocPrime.get(j));	
						}
					}
				}
			}
		}
		 gain0 = calculGain(allocPrime);
	        ArrayList<Integer> objets = new ArrayList<Integer>();
			for (int j = 0; j < allocPrime.size(); j++)
			{
				objets.add(allocPrime.get(j));
			}
			tabSolVoisine[0] = new recup(gain0, objets);
			k = 1;
	  }	
	else {
		gain0 = calculGain(allocTmp);
        ArrayList<Integer> objets = new ArrayList<Integer>();
		for (int j = 0; j < allocTmp.size(); j++)
		{
			objets.add(allocTmp.get(j));
		}
		tabSolVoisine[0] = new recup(gain0, objets);
		k = 1;
	}
	  }
		
		for (int i = 0; i < B.size(); i++)
		{
			ArrayList<Integer> allocTmp = new ArrayList<Integer>();
		    for (int j = 0; j < alloc.size(); j++)
			{
				allocTmp.add(alloc.get(j));
			}
			ArrayList<Integer> allocPrime = new ArrayList<Integer>();
			if ( B.get(i) != offreAleat) 
			{
				if (tabuListe.contains(B.get(i)) )
				{
					   allocPrime = Aspiration(matriceAdjacence, allocTmp, tabuListe, B.get(i), iter, tt);
				}	 
				else
		       {
				for (int j = 0; j < alloc.size(); j++)
				{
					allocPrime.add(alloc.get(j));
				}
				if (!(allocPrime.contains(B.get(i))))
					{
						allocPrime.add(B.get(i));
                        ArrayList<Integer> R = new ArrayList<Integer>();
						if (iter < tt)
						{
							for (int j = 0; j < allocPrime.size() ; j++)
							{
								if ((matriceAdjacence[B.get(i)][allocPrime.get(j)] == 1))
										{
									        if (!tabuListe.contains(allocPrime.get(j)))
									        {
									        	allocPrime.remove(allocPrime.get(j));
									        	R.add(allocPrime.get(j));
											}
									        else 
									        {
									        	if (allocPrime.contains(B.get(i)))
									        	allocPrime.remove(B.get(i));	
									        	break;
									        }
										}
							}
						}
						else 
							for (int j = 0; j < allocPrime.size() ; j++)
							{
								if (matriceAdjacence[B.get(i)][allocPrime.get(j)] == 1)
								{
									allocPrime.remove(allocPrime.get(j));
						        	R.add(allocPrime.get(j));
								}
							}
						if (R.size() > 0){
							 ArrayList<Integer> objets = new ArrayList<Integer>();
							 for (int j = 0; j < R.size() ; j++)
								{
									objets.add(R.get(j));
								}
								loser[h] = new recup(calculGain(objets), objets);
								h++;
							}
					}
				}
				gain = calculGain(allocPrime);
				if (gain > gainTotal)
				{
					ArrayList<Integer> objets = new ArrayList<Integer>();
					for (int j = 0; j < allocPrime.size(); j++)
					{
						objets.add(allocPrime.get(j));
					}
					tabSolVoisine[k] = new recup(gain, objets);
				    k++;
				}
		}
		}
		int numMaxGain;
		if (k == 1)
			 numMaxGain = 0;
		else 
		numMaxGain = calculNumMaxPrixOffre(tabSolVoisine, 1, k);
		for (int i = 0; i < k; i++)
		{
			if (i == numMaxGain)
				gain = tabSolVoisine[i].prix_offre;
		}
		if (gain0 > gain && gain0 > gainTotal)
		{
			allocPr.clear();
			for (int j = 0; j < tabSolVoisine[0].tab_objets.size(); j++)
			{
				allocPr.add(tabSolVoisine[0].tab_objets.get(j));
			}
	    	allocP = new recup(gain0, allocPr);
	    		for (int j = 0; j < loser[0].tab_objets.size(); j++)
	    			loserBid.add(loser[0].tab_objets.get(j));  	
		}
		else 
		{
			allocPr.clear();
			for (int j = 0; j < tabSolVoisine[numMaxGain].tab_objets.size(); j++)
			{
				allocPr.add(tabSolVoisine[numMaxGain].tab_objets.get(j));
			}
			allocP = new recup(gain, allocPr);
		 	for (int i = 0; i < h; i++)
	    	{
		 		if (i == numMaxGain){
	    		for (int j = 0; j < loser[i].tab_objets.size(); j++)
	    			loserBid.add(loser[i].tab_objets.get(j));
		 		}
	    	}
		}
		return allocP;
	}
	
	void writeln(File use,String s, String fileName) {
		if(use != null){
			try {
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(use,
						true)));
				writer.println(s);
				writer.close();
			} catch (IOException e) {
				 System.out.println("Cannot write to file " +fileName+", "+e);
			}			
		}
	}
	
	void write(File use,String s, String fileName) {
		if(use != null){
			try {
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(use,
						true)));
				writer.print(s);
				writer.close();
			} catch (IOException e) {
				 System.out.println("Cannot write to file " +fileName+", "+e);
			}			
		}
	}
	
	public int getNbreObjets()
	{
		return this.nb_objets;
	}
	public int getNbreOffres()
	{
		return this.nb_offres;
	}
	public recup[] getRecup()
	{
		return this.r;
	}
    public int[][] getMatriceAdjacence()
    {
    	return this.matriceAdjacence;
    }
    public ArrayList<Double> getAleat()
    {
    	return this.aleat;
    }
    public int getParameterP()
	{
		return this.p;
	}
    public double getParameterLampda()
	{
		return this.lamda;
	}
    public int getNbMaxIterationTS()
   	{
   		return this.iterMaxTS;
   	}
    public int getNbMaxIterationSLS()
   	{
   		return this.iterMaxSLS;
   	}
    public double getWalkProbability()
	{
		return this.wp;
	}
}
