package wdp1;

import java.util.ArrayList;

public class recup {
	
	float prix_offre; 
	ArrayList<Integer> tab_objets; 	

	recup (float prix_offre, ArrayList<Integer> tab_objets)
	{
		this.prix_offre = prix_offre;
		this.tab_objets = tab_objets;
	}
	
	public float getPrixOffre()
	{
		return this.prix_offre;
	}
	public void setPrixOffre(float prix_offre)
	{
	      this.prix_offre = prix_offre;
	}
	public ArrayList<Integer> getTabObjets()
	{
		return this.tab_objets;
	}
	/*public void setTabObjets(int i)
	{
	      this.tab_objets = i;
	}*/
}
