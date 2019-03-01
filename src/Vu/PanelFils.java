package Vu;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import Modele.*;


public class PanelFils extends JPanel { // implements ActionListener {
	
	public PanelFils(Agenda parAgenda, File parFile)
	{
		PanelEvenement panelEvenement = new PanelEvenement(parAgenda, parFile);
		PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement);
		
		this.setLayout(new BorderLayout(8,8));
		this.add(panelCalendrier, BorderLayout.WEST);
		this.add(panelEvenement, BorderLayout.EAST);
	}
}
