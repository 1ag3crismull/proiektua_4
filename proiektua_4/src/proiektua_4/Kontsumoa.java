package proiektua_4;

class Kontsumoa {
	//Atributuak
	/**
	 * Autoak egindako kilometroak
	 */
	private double kms;
	/**
	 * Kontsumitutako erregai-litroak
	 */
	private double litroak;
	/**
	 * Batez besteko abiadura
	 */
	private double vmed;
	/**
	 * Gasolinaren prezioa
	 */
	private double pGas;
	
	/**
	 * Metodoa (eraikitzailea)
	 * Defektuzko baloreak
	 */
	Kontsumoa() {
		kms = 0;
		litroak = 0;
		vmed = 0;
		pGas = 0;
	}
	
	/**
	 * Metodoa
	 * @return Bidaia egiteko erabilitako denbora String
	 */
	public String getDenbora() {
	    double denboraOrdutan = kms / vmed;
	    int orduak = (int) denboraOrdutan;
	    int minutuak = (int) ((denboraOrdutan - orduak) * 60);

	    if (minutuak == 0) {
	    	return orduak + " ordu";
	    }
	    else {
	    	return orduak + " ordu eta " + minutuak + " minutu";
	    }
	}
	
	/**
	 * Metodoa
	 * @return Ibilgailuaren batez besteko kontsumoa (litrotan, 100 kilometrotik behin) double
	 */
	public double getBatazBestekoKontsumoa() {
		double batazBestekoKontsumoa = (litroak / kms) * 100;
		return batazBestekoKontsumoa;
	}
	

	/**
	 * Metodoa
	 * @return Ibilgailuaren batez besteko kontsumoa (eurotan, 100 kilometroko) double
	 */
	public double getKontsumoaEuro() {
		double kontsumoaEuro = getBatazBestekoKontsumoa() * pGas;
		return kontsumoaEuro;
	}
	
	/**
	 * Metodoa
	 * @param Kilometroak aldatzeko double
	 */
	public void setKms(double k) {
		kms = k;
	}
	
	/**
	 * Metodoa
	 * @param Litroak aldatzeko double
	 */
	public void setLitroak(double l) {
		litroak = l;
	}
	
	/**
	 * Metodoa
	 * @param Bataz besteko abiadura aldatzeko double
	 */
	public void setVmed(double v) {
		vmed = v;
	}
	
	/**
	 * Metodoa
	 * @param Gasolinaren prezioa aldatzeko double
	 */
	public void setPgas(double g) {
		pGas = g;
	}
	
}
