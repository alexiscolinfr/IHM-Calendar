package Vu;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import Fichier.MethodesPourFichier;
import Modele.*;

public class PanelEvenement extends JPanel implements ActionListener {
	
	private JPanel zoneSaisie = new JPanel();
	private JPanel zoneAffichage = new JPanel();
	private Date chDate = new Date();
	private JLabel chLabDate = new JLabel(chDate.toString());
	private JButton ajouter = new JButton("+");
	private JLabel chLabTitre = new JLabel("Titre", JLabel.CENTER);
	private JLabel chLabLieu = new JLabel("Lieu", JLabel.CENTER);
	private JLabel chLabDebut = new JLabel("Debut", JLabel.CENTER);
	private JLabel chLabFin = new JLabel("Fin", JLabel.CENTER);
	private JLabel chLabDescription = new JLabel("Description", JLabel.CENTER);
	private JTextField chTextTitre = new JTextField(10);
	private JTextField chTextLieu = new JTextField(10);
	private JTextArea chTextDescription = new JTextArea(10,10);
	private JTextArea chTextEvt = new JTextArea(28,33);
	
	private JComboBox choixDebutHeure = new JComboBox();
	private JComboBox choixDebutMinute = new JComboBox();
	private JComboBox choixFinHeure = new JComboBox();
	private JComboBox choixFinMinute = new JComboBox();
	
	private Agenda agenda;
	private File file;
	
	private TableDunMois affiche_table = new TableDunMois();
	
	public PanelEvenement(Agenda parAgenda, File parFile){
		
		this.setLayout(new BorderLayout(8,8));
		this.add(zoneSaisie,BorderLayout.WEST);
		this.add(zoneAffichage,BorderLayout.EAST);
		
		zoneSaisie.setLayout(new GridBagLayout());
		zoneAffichage.setLayout(new BorderLayout(5,5));
		
		agenda = parAgenda;
		file = parFile;
		chTextEvt.setText(agenda.toString());
		
		for (int i=0 ; i< 60 ; i++)
		{
			String str = Integer.toString(i);
			if (i<10)
				str = "0"+str;
			choixDebutMinute.addItem(str);
			choixFinMinute.addItem(str);
		}
		
		for (int i=0 ; i< 24 ; i++)
		{
			String str = Integer.toString(i);
			if (i<10)
				str = "0"+str;
			choixDebutHeure.addItem(str);
			choixFinHeure.addItem(str);
		}
		
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		contrainte.gridx = contrainte.gridy =0;
		contrainte.gridwidth=3;
		zoneSaisie.add(chLabDate,contrainte);
		contrainte.gridx = 3;
		contrainte.gridwidth=1;
		zoneSaisie.add(ajouter, contrainte);
		ajouter.addActionListener(this);
		contrainte.gridx = 0;
		contrainte.gridy = 1;
		contrainte.gridwidth=2;
		zoneSaisie.add(chLabTitre,contrainte);
		contrainte.gridx = 2;
		zoneSaisie.add(chTextTitre,contrainte);
		contrainte.gridx = 0;
		contrainte.gridy = 2;
		zoneSaisie.add(chLabLieu,contrainte);
		contrainte.gridx = 2;
		zoneSaisie.add(chTextLieu,contrainte);
		contrainte.gridx = 0;
		contrainte.gridy = 3;
		contrainte.gridwidth=2;
		zoneSaisie.add(chLabDebut,contrainte);
		contrainte.gridx = 2;
		contrainte.gridwidth=1;
		zoneSaisie.add(choixDebutHeure,contrainte);
		contrainte.gridx = 3;
		zoneSaisie.add(choixDebutMinute,contrainte);
		contrainte.gridx = 0;
		contrainte.gridy = 4;
		contrainte.gridwidth=2;
		zoneSaisie.add(chLabFin,contrainte);
		contrainte.gridx = 2;
		contrainte.gridwidth=1;
		zoneSaisie.add(choixFinHeure,contrainte);
		contrainte.gridx = 3;
		zoneSaisie.add(choixFinMinute,contrainte);
		contrainte.gridx = 0;
		contrainte.gridy = 5;
		contrainte.gridwidth=4;
		zoneSaisie.add(chLabDescription,contrainte);
		contrainte.gridy = 6;
		contrainte.gridheight=5;
		zoneSaisie.add(chTextDescription,contrainte);
		   
		//Affichage Tableau
		
		affiche_table.setModel(new ModeleTable(agenda,chDate));
		JScrollPane scroll = new JScrollPane(affiche_table);
		scroll.setPreferredSize(new Dimension(440, 10*30));
		zoneAffichage.add(scroll);

	}
	
	public void setModel(ModeleTable mod)
	{
		affiche_table.setModel(mod);
	}
	
	public void setDate(Date parDate)
	{
		chDate = parDate;
		chLabDate.setText(chDate.toString());
	}
	
	public Agenda getAgenda()
	{
		return agenda;
	}
	
	public void actionPerformed(ActionEvent parEvt)
	{
		if(parEvt.getSource()==ajouter)
		{
			Evt evenement1 = new Evt(chDate,chTextTitre.getText(),chTextLieu.getText(),choixDebutHeure.getSelectedItem().toString(),choixDebutMinute.getSelectedItem().toString(),choixFinHeure.getSelectedItem().toString(),choixFinMinute.getSelectedItem().toString());
			agenda.ajoutEvt(chDate,evenement1);
			//System.out.println(evenement1.toString());
			chTextEvt.setText(agenda.toString());
			MethodesPourFichier.ecriture(file, agenda);
			affiche_table.setModel(new ModeleTable(agenda,chDate));
		}
	}
}
