package Modele;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel {
	
	Agenda chAgenda;
	Date chDate;
	
	public ModeleTable(Agenda parAgenda, Date parDate){
		chAgenda = parAgenda;
		chDate = parDate;
		int nbrJour = chDate.DernierJourDuMois(chDate.getMois(), chDate.getAn());
		String[]titreTable = new String [nbrJour];
		for (int i=0 ; i<nbrJour ; i++)
			titreTable[i] = new Integer(i+1).toString();
		
		setColumnIdentifiers(titreTable); //titre table
		setColumnCount(nbrJour); //nbr de colonnes
		setRowCount(10);
		
		HashMap map =  chAgenda.getMap();
		Set <Date> cles = map.keySet();
		for (Date cle : cles){
			if (cle.getMois() == chDate.getMois()){
				ArrayList liste = (ArrayList) map.get(cle);
				int colonne = cle.getJour() -1;
				for (int i=0 ; i<liste.size() ; i++)
					setValueAt(liste.get(i).toString(), i, colonne);
			}
		}
		
	}
}
