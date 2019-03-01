package Modele;
import java.io.Serializable;
import java.util.*;

public class Date implements Serializable
{
	private int chJour, chMois, chAn, chJourSemaine;
	public Date (int parJour, int parMois, int parAn)
	{
		chJour = parJour;
		chMois = parMois;
		chAn = parAn;
		/*if (chJour < 1 || chJour > DernierJourDuMois(chMois,chAn))
			throw new ExceptAgenda("Jour invalide !");
		if (chMois < 1 || chMois > 12)
			throw new ExceptAgenda("Mois invalide !");
		if (chAn < 1582)
			throw new ExceptAgenda("Annee invalide !");
		*/
		GregorianCalendar d = new GregorianCalendar(chAn, chMois-1, chJour);
		chJourSemaine = d.get(Calendar.DAY_OF_WEEK);
	}
	
	public Date()
	{
		GregorianCalendar dateAuj = new GregorianCalendar();
		chAn = dateAuj.get(Calendar.YEAR);
		chMois = dateAuj.get(Calendar.MONTH)+1;
		chJour = dateAuj.get(Calendar.DAY_OF_MONTH);
		chJourSemaine = dateAuj.get(Calendar.DAY_OF_WEEK);
		
	}
	
	public static int DernierJourDuMois (int parMois, int parAn)
	{
		switch (parMois)
		{
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if ((parAn % 4 == 0 && parAn / 100 != 0) || (parAn % 400 == 0))
					return 29;
				else
					return 28;
			default:
				return 31;
		}
	}
	
	public int getJour()
	{
		return chJour;
	}
	
	public int getMois()
	{
		return chMois;
	}
	
	public int getAn()
	{
		return chAn;
	}
	
	public String toString ()
	{
		return (chJour + "/" + chMois + "/" + chAn);
	}
}
