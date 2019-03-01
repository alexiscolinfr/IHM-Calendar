package Modele;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Agenda implements Serializable
{
	private HashMap <Date, ArrayList> chEvts;
	private int chNbEvt;
	
	public Agenda()
	{
		chEvts = new HashMap <Date, ArrayList>();
		chNbEvt = 0;
	}
	
	public void ajoutEvt(Date parCle, Evt parEvt)
	{
	
		if(chEvts.containsKey(parCle)==true){
			ArrayList list = chEvts.get(parCle);
			list.add(parEvt);
		}
		else{
			ArrayList <Evt> al = new ArrayList <Evt> ();
			al.add(parEvt);
			chEvts.put(parCle, al);
		}
		chNbEvt ++;
	}
	
	public String toString()
	{
		Set <Date> cles = chEvts.keySet();
		
		String message = new String();
		for(Date cle : cles)
		{
			message += cle.toString() + " :\n";
			ArrayList l = chEvts.get(cle);
			for (int i=0 ; i<l.size() ; i++)
				message += l.get(i) + "\n";
		}
		return message;
	}

	public HashMap getMap() {
		return chEvts;
	}

}