package Vu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import Fichier.MethodesPourFichier;
import Modele.*;

public class FenetreMere extends JFrame 
{
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu edition = new JMenu("Edition");
	private JMenu annees = new JMenu("Années");
	private JMenu quitter = new JMenu("Quitter");
	
	
	private JCheckBoxMenuItem annee1 = new JCheckBoxMenuItem("2015");
	private JCheckBoxMenuItem annee2 = new JCheckBoxMenuItem("2016");
	private JCheckBoxMenuItem annee3 = new JCheckBoxMenuItem("2017");
	
	public FenetreMere(String parTitre, Agenda agenda, File file)
	{
		super (parTitre);
		PanelFils contentPane= new PanelFils(agenda,file);
		setContentPane(contentPane);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setSize (1000,500); setVisible(true); setLocation(200,300);
		annees.add(annee1);
		annees.add(annee2);
		annees.add(annee3);
		
		edition.add(annees);
		menuBar.add(edition);
		menuBar.add(quitter);
		setJMenuBar(menuBar);
	}

	public static void main (String [] args)
	{
		File file = new File("Data_Nom_Fichier");
		Agenda agenda =(Agenda)MethodesPourFichier.lecture(file);
		//Agenda agenda = new Agenda();
		new FenetreMere("Formulaire", agenda, file);
	}

}
