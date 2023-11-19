package proiektua_4;

import javax.swing.JOptionPane; //Leihoa agertzeko paketea. module-info.jav ezabatu behar da funtzionatu ahal izateko
import java.text.DecimalFormat; //Zenbaki hamartarrei formatua emateko

public class KontsumoKudeaketa {

	/**
	 * Metodoa
	 * @param Mezua sartzeko String
	 * @return Leihoan sartutako balioa itzuli double
	 */
    public static double getDoubleInput(String mezua) {
    	String input = JOptionPane.showInputDialog(null, mezua, "Sarrera", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            //Leihoa ixten badq, beste leiho bat agertuko da leihoa itxi egin dela esanez
        	JOptionPane.showMessageDialog(null, "Leihoa itxi da.", "Abisua", JOptionPane.WARNING_MESSAGE);
            System.exit(0); //Prozesua irteten eta bukatzen da
        }
        return Double.parseDouble(input.replace(",", ".")); //Txertatutako balioan, koma puntu bihurtzen du. Adibidez: '1,65' ordez '1.65'
    }
	
	public static void main(String[] args) {
		//Objektuak sortzen
		Kontsumoa autoa1 = new Kontsumoa();
		
		//'try' barruan dagoen bloquea exekutatuko da eta salbuespen bat badago erantzun espezifiko bat azalduko da
		try {
			//Atributuen balioak ezartzen
			double sartuKms = getDoubleInput("Sartu autoak egindako kilometroak:");
			double sartuLitroak = getDoubleInput("Sartu autoak kontsumitutako erregai-litroak:");
			double sartuVmed = getDoubleInput("Sartu autoaren bataz besteko abiadura:");
			double sartuPgas = getDoubleInput("Sartu gasolinaren prezioa:");
			
            //Egiaztatu zenbakiak negatiboak diren
            if (sartuKms < 0 || sartuLitroak < 0 || sartuVmed < 0 || sartuPgas < 0) {
                throw new NumberFormatException(); //'catch' dagoen errore mezua agertuko da
            }
            
			//Klaseko atributuen balioak aldatzen
			autoa1.setKms(sartuKms);
			autoa1.setLitroak(sartuLitroak);
			autoa1.setVmed(sartuVmed);
			autoa1.setPgas(sartuPgas);
			
			//Zenbaki hamartarrei formatua ematen. Adibidez: '341.00' ordez '341', '1.6532342' ordez '1.65'
			DecimalFormat df = new DecimalFormat("0.##");
			
			//Mezua inprimatzen leiho batean
			String mezua = "Autoak egindako kilometroak: " + df.format(sartuKms) + " km\n"
			        + "Autoak kontsumitutako erregai-litroak: " + df.format(sartuLitroak) + " L\n"
			        + "Autoaren bataz besteko abiadura: " + df.format(sartuVmed) + " km/h\n"
			        + "Gasolinaren prezioa: " + df.format(sartuPgas) + " €/L\n"
			        + "Autoak bidaia egiteko erabilitako denbora: " + autoa1.getDenbora() + "\n"
			        + "Autoaren batez besteko kontsumoa (litrotan, 100 kilometrotik behin): " + df.format(autoa1.getBatazBestekoKontsumoa()) + " L\n"
			        + "Autoaren batez besteko kontsumoa (eurotan, 100 kilometrotik behin): " + df.format(autoa1.getKontsumoaEuro()) + " €";

			JOptionPane.showMessageDialog(null, mezua, "Mezua", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (NumberFormatException e) {
		    String erroreMezua = "Sartutako balioak ez dira onartzen.";
		    JOptionPane.showMessageDialog(null, erroreMezua, "Errorea", JOptionPane.ERROR_MESSAGE);
		}

	}

}
