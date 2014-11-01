import ea.*;

/**
 * Diese Klasse soll ein einfaches Billiard/Spiel implementieren,
 * um eine Demo der EA/Physik zu geben.
 * <br /><br />
 * Für mehr Informationen zur Physik, empfiehlt es sich,
 * die <b>Dokumentation</b> und den <a href="http://engine-alpha.org/wiki">Wiki</a>
 * zu konsultieren.
 * @author Michael Andonie
 *
 */
public class MiniBilliard 
extends Game {

	/**
	 * Die weisse Kugel. Externe Referenz, damit sie in der
	 * tasteReagieren - Methode zur Verfügung steht.
	 */
	private Kreis weisse;
	
	/**
	 * Erstellt das Spiel.
	 */
	public MiniBilliard() {
		super(500,350); // Fenster: Masse 500 x 350 Pixel
		
		//Der Radius für alle Kugeln ist 20
		
		//Erstelle und positioniere alle Kugeln
		weisse = new Kreis(20, 165, 20);
		
		Kreis k2 = new Kreis(250, 165, 20);
		Kreis k3 = new Kreis(270, 152, 20);
		Kreis k4 = new Kreis(270, 178, 20);
		Kreis k5 = new Kreis(290, 165, 20);
		Kreis k6 = new Kreis(290, 139, 20);
		Kreis k7 = new Kreis(290, 191, 20);
		Kreis k8 = new Kreis(310, 152, 20);
		Kreis k9 = new Kreis(310, 178, 20);
		Kreis k10 = new Kreis(310, 126, 20);
		Kreis k11 = new Kreis(310, 204, 20);
		
		//Erstelle das Spielfeld
		Rechteck wandlinks = new Rechteck(-20,0, 10, 520);
		Rechteck wandrechts = new Rechteck(490,0, 10, 500);
		Rechteck wandoben = new Rechteck(0,0, 500, 10);
		Rechteck wandunten = new Rechteck(0,340, 500, 10);
		Rechteck untergrund = new Rechteck(0,0, 500, 500);
		
		//Färbe die Kugeln und das Spielfeld ein
		weisse.farbeSetzen("Weiss");
		k2.farbeSetzen("Gelb");
		k3.farbeSetzen("Blau");
		k4.farbeSetzen("Grau");
		k5.farbeSetzen("Blau");
		k6.farbeSetzen("Orange");
		k7.farbeSetzen("Cyan");
		k8.farbeSetzen("Pink");
		k9.farbeSetzen("Lila");
		k10.farbeSetzen("Hellgrau");
		k11.farbeSetzen("Orange");
		
		wandlinks.farbeSetzen("Dunkelgrau");
		wandrechts.farbeSetzen("Dunkelgrau");
		wandoben.farbeSetzen("Dunkelgrau");
		wandunten.farbeSetzen("Dunkelgrau");
		
		untergrund.farbeSetzen("Gruen");
		
		//Alle Objekte sichtbar machen: -> An Wurzel anmelden
		
		wurzel.add(untergrund);
		wurzel.add(weisse, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, 
				wandlinks, wandrechts, wandoben, wandunten);
		
		
			//Physik-Verwenden
		
		//Bringe alle Objekte in Physik-Modus
		//weisse.setzeMeterProPixel(1/());
		weisse.newtonschMachen();
		k2.newtonschMachen();
		k3.newtonschMachen();
		k4.newtonschMachen();
		k5.newtonschMachen();
		k6.newtonschMachen();
		k7.newtonschMachen();
		k8.newtonschMachen();
		k9.newtonschMachen();
		k10.newtonschMachen();
		k11.newtonschMachen();
		
		wandlinks.newtonschMachen();
		wandoben.newtonschMachen();
		wandunten.newtonschMachen();
		wandrechts.newtonschMachen();
		
		//Markiere alle Wände als nicht beeinflussbar (=> andere Objekte prallen daran ab,
		//ohne dass sie davon bewegt werden.)
			//(Die Kugeln müssen nicht explizit als beeinflussbar markiert werden
			//-> das ist als Engine-Standard bereits eingestellt.)
		wandlinks.beeinflussbarSetzen(false);
		wandrechts.beeinflussbarSetzen(false);
		wandoben.beeinflussbarSetzen(false);
		wandunten.beeinflussbarSetzen(false);
		
		//Sorge für vollständige Geschwindigkeitserhaltung
		//weisse.kollisionsPufferSetzen(0);
		//k2.kollisionsPufferSetzen(0);
		//k3.kollisionsPufferSetzen(0);
		//k4.kollisionsPufferSetzen(0);
		//k5.kollisionsPufferSetzen(0);
		//k6.kollisionsPufferSetzen(0);
		//k7.kollisionsPufferSetzen(0);
		//k8.kollisionsPufferSetzen(0);
		//k9.kollisionsPufferSetzen(0);
		//k10.kollisionsPufferSetzen(0);
		//k11.kollisionsPufferSetzen(0);
		
		//wandlinks.kollisionsPufferSetzen(0);
		//wandoben.kollisionsPufferSetzen(0);
		//wandunten.kollisionsPufferSetzen(0);
		//wandrechts.kollisionsPufferSetzen(0);
		
		//weisse.kraftSetzen(new Vektor(0, 9.81f));
	}
	
	/**
	 * In der Taste-Reagieren-Methode wird die Tastatureingabe verarbeitet:<br />
	 * Bei Pfeiltasten-Druck bekommt die Weisse Kugel einen (zusätzlichen) Impuls
	 * von 20 kg*m/s
	 * @param	code	Der Tastencode der gedrückten Taste.
	 */
	@Override
	public void tasteReagieren(int code) {
		switch(code) {
		case 29: //Links
			weisse.impulsHinzunehmen(new Vektor(-20, 0));
			break;
		case 27: //Rechts
			weisse.impulsHinzunehmen(new Vektor(20, 0));
			break;
		case 28: //Down
			weisse.impulsHinzunehmen(new Vektor(0, 20));
			break;
		case 26: //Down
			weisse.impulsHinzunehmen(new Vektor(0, -20));
			break;
		case 30: //Leertaste
			//
			break;
		}
	}
	
	/**
	 * Die Main-Methode startet einfach ein Billiard-Spiel.
	 * @param args	Die Command-Line-Argumente. Absolut irrelevant für uns.
	 */
	public static void main(String[] args) {
		new MiniBilliard();
	}

}
