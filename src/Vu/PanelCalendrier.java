package Vu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Modele.*;
import Vu.BoutonDate;

public class PanelCalendrier extends JPanel implements ActionListener {
	
	private PanelEvenement panelEvenement;
	private Agenda agenda = new Agenda();
	
	// centre
	private CardLayout chCalendrier = new CardLayout();
	private Date today = new Date();
	private JPanel chPanCentre = new JPanel ();	
	BoutonDate bprec = new BoutonDate(new Date());
	
	// sud
	private JPanel chPanlSud= new JPanel();
	private int chIndexMois = today.getMois()-1;
	private String[] chMois={"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
	private JLabel chLabSud= new JLabel(chMois[chIndexMois]);
	private JButton precedent= new JButton("<");
	private JButton suivant= new JButton(">");
	
	
	public PanelCalendrier(PanelEvenement parEvenement)
	{
		
		// centre
		chPanCentre.setLayout(chCalendrier);
		
		panelEvenement = parEvenement;
		agenda = parEvenement.getAgenda();
		
		for (int j=0 ; j <= 11 ; j++)
		{
			JPanel chPanMois = new JPanel();
			int nbJour = Date.DernierJourDuMois(j+1, today.getAn());
			chPanMois.setLayout(new GridLayout(0,7));
			
			for(int i=0 ; i < nbJour ; i++)
			{
				Date date = new Date(i+1,j+1, today.getAn());
				BoutonDate bout = new BoutonDate(date);
				chPanMois.add(bout);
				bout.addActionListener(this);
			}
			chPanCentre.add(chPanMois,chMois[j]);
			
		}
		chCalendrier.show(chPanCentre,chMois[chIndexMois]);

		// sud
		chPanlSud.setLayout(new FlowLayout(FlowLayout.CENTER,40,20));
		chPanlSud.add(precedent);
		chPanlSud.add(chLabSud);
		chPanlSud.add(suivant);
		precedent.addActionListener(this);
		suivant.addActionListener(this);

		
		// global
		this.setLayout(new BorderLayout(10,10));
		this.add(chPanlSud,BorderLayout.SOUTH);
		this.add(chPanCentre,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent parEvt)
	{
		if(parEvt.getSource()==suivant)
		{
			chIndexMois++;
			if(chIndexMois >= chMois.length)
				chIndexMois=0;
			chLabSud.setText(chMois[chIndexMois]);
			chCalendrier.next(chPanCentre);
		}
		else if(parEvt.getSource()==precedent)
		{
			chIndexMois--;
			if(chIndexMois < 0)
				chIndexMois=chMois.length-1;
			chLabSud.setText(chMois[chIndexMois]);
			chCalendrier.previous(chPanCentre);
		}
		else
		{
			BoutonDate bSource = (BoutonDate)parEvt.getSource();
			bprec.setCouleur();
			bSource.setCouleurClique();
			//JOptionPane.showMessageDialog(null, bSource.getDate().toString(),"Date",JOptionPane.INFORMATION_MESSAGE);
			bprec = bSource;
			Date date = bprec.getDate();
			panelEvenement.setDate(date);
			panelEvenement.setModel(new ModeleTable(agenda,date));
		}
	}
	
}
