package Modele;

import java.io.Serializable;

public class Evt implements Serializable
{
	private static int chNbr=0;
	private Date chDate;
	private String chTitre, chLieu, chHD, chHF, chMD, chMF;
	
	public Evt (Date parDate, String parTitre, String parLieu, String parHD, String parMD, String parHF, String parMF)
	{
		chDate = parDate;
		chHD = parHD;
		chMD = parMD;
		chHF = parHF;
		chMF = parMF;
		chTitre = parTitre;
		chLieu = parLieu;
		chNbr++;
	}
	public String toString()
	{
		return (chTitre + " à " + chLieu + " de " + chHD + ":" + chMD + " à " + chHF + ":" + chMF);
	}
	public Date getDate()
	{
		return chDate;
	}
	public String getTitre()
	{
		return chTitre;
	}
	public String getLieu()
	{
		return chLieu;
	}
	public void setDate(Date parDate)
	{
		chDate = parDate;
	}
	public void setTitre(String parTitre)
	{
		chTitre = parTitre;
	}
	public void setLieu(String parLieu)
	{
		chLieu = parLieu;
	}
	public int getNbr()
	{
		return chNbr;
	}
}
