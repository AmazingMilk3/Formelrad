package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		int gegebeneWerte = 0;
		
		if (leistung > 0) gegebeneWerte++;
		if (spannung > 0) gegebeneWerte++;
		if (strom > 0) gegebeneWerte++;
		if (widerstand > 0) gegebeneWerte++;
		
		if (gegebeneWerte > 2) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warnung");
			alert.setHeaderText("Sie haben zu viele Werte angegeben!");
			alert.setContentText("F�r die Berechnung durch das Programm sind nur zwei Werte n�tig.");

			alert.showAndWait();
		}
		else {
			if (leistung > 0) {
				if (spannung > 0) {
					strom = iAusPundU(leistung, spannung);
					widerstand = rAusUundP(spannung, leistung);
				}
				else if (strom > 0) {
					spannung = uAusPundI(leistung, strom);
					widerstand = rAusPundI(leistung, strom);
				}
				else if (widerstand > 0) {
					strom = iAusPundR(leistung, widerstand);
					spannung = uAusPundR(leistung, widerstand);
				}
			} else if (spannung > 0) {
				if (strom > 0) {
					leistung = pAusUundI(spannung, strom);
					widerstand = rAusUundI(spannung, strom);
				}
				else if (widerstand > 0) {
					strom = iAusUundR(spannung, widerstand);
					leistung = pAusUundR(spannung, widerstand);
				}
			} else if (widerstand > 0) {
				if (strom > 0) {
					leistung = pAusRundI(widerstand, strom);
					spannung = uAusRundI(widerstand, strom);
				}
			}
		}
	}
	
	/* Hier die Methoden mit den Formeln hinzuf�gen
	 */
	
	public double pAusUundI(double u, double i) {
		System.out.println("P calculated from U and I");
		
		return u * i;
	}
	
	public double pAusRundI(double r, double i) {
		System.out.println("P calculated from R and I");
		
		return r * (i * i);
	}
	
	public double pAusUundR(double u, double r) {
		System.out.println("P calculated from U and R");
		
		return (u * u) / r;
	}
	
	public double iAusPundR(double p, double r) {
		System.out.println("I calculated from P and R");
		
		return Math.sqrt(p / r); 
	}
	
	public double iAusPundU(double p, double u) {
		System.out.println("I calculated from P and U");
		
		return p / u;
	}
	
	public double iAusUundR(double u, double r) {
		System.out.println("I calculated from U and R");
		
		return u / r;
	}
	
	public double uAusRundI(double r, double i) {
		System.out.println("U calculated from R and I");
		
		return r*i;
	}
	
	public double uAusPundI(double p, double i) {
		System.out.println("U calculated from P and I");
		
		return p/i;
	}
	
	public double uAusPundR(double p, double r) {
		System.out.println("U calculated from R and P");
		
		return Math.sqrt(p*r);
	}
	
	public double rAusUundP(double u, double p) {
		System.out.println("R calculated from U and P");
		
		return (u*u)/p;
	}
	
	public double rAusPundI(double p, double i) {
		System.out.println("R calculated from I and P");
		
		return p/(i*i);
	}
	
	public double rAusUundI(double u, double i) {
		System.out.println("R calculated from U and I");
		
		return u/i;
	}
}
