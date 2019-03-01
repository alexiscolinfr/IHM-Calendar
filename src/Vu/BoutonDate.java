package Vu;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.*;
import Modele.*;
public class BoutonDate extends JButton {
	
	Date chDate;
	
	public BoutonDate(Date parDate)
	{
		super(Integer.toString(parDate.getJour()));
		chDate = parDate;
		setCouleur();
	}
	
	public void setCouleur()
	{
		Date today = new Date();
		if (today.getJour() == chDate.getJour() && today.getMois() == chDate.getMois())
			setBackground(Color.green);
		
		//else if(chDate.getJourSemaine() == Calendar.SATURDAY || chDate.getJourSemaine() == Calendar.SUNDAY)
		//	setBackground(Color.red);
		
		else
			setBackground(Color.white);
	}
	
	public void setCouleurClique()
	{
		setBackground(Color.blue);
	}
	
	public Date getDate()
	{
		return chDate;
	}
}
