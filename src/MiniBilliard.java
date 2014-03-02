import ea.*;

/**
 * Diese Klasse soll ein einfaches Billiard/Spiel implementieren,
 * um eine Demo der EA/Physik zu geben.
 * @author Michael Andonie
 *
 */
public class MiniBilliard 
extends Game {

	/**
	 * Die weisse Kugel
	 */
	private Kreis weisse;
	
	/**
	 * Erstellt das Spiel.
	 */
	public MiniBilliard() {
		super(500,350); // Fenster: Masse 500 x 350 Pixel
		
		//Der Radius f�r alle Kugeln ist 20
		
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
		Rechteck wandlinks = new Rechteck(0,0, 10, 500);
		Rechteck wandrechts = new Rechteck(490,0, 10, 500);
		Rechteck wandoben = new Rechteck(0,0, 500, 10);
		Rechteck wandunten = new Rechteck(0,340, 500, 10);
		Rechteck untergrund = new Rechteck(0,0, 500, 500);
		
		//F�rbe die Kugeln und das Spielfeld ein
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
		k11.farbeSetzen("Dunkelgrau");
		
		wandlinks.farbeSetzen("Rot");
		wandrechts.farbeSetzen("Rot");
		wandoben.farbeSetzen("Rot");
		wandunten.farbeSetzen("Rot");
		
		untergrund.farbeSetzen("Gruen");
		
		//Alle Objekte sichtbar machen: -> An Wurzel anmelden
		
		wurzel.add(untergrund);
		wurzel.add(weisse, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, 
				wandlinks, wandrechts, wandoben, wandunten);
		
		
			//Physik-Verwenden
		
		//Bringe alle Objekte in Physik-Modus
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
		
		//Markiere alle W�nde als nicht beeinflussbar
			//(Kugeln m�ssen nicht explizit als beeinflussbar markiert werden
			//-> das ist als Engine-Standard bereits eingestellt.)
		wandlinks.beeinflussbarSetzen(false);
		wandrechts.beeinflussbarSetzen(false);
		wandoben.beeinflussbarSetzen(false);
		wandunten.beeinflussbarSetzen(false);
		
	}
	
	@Override
	public void tasteReagieren(int code) {
		switch(code) {
		case 29: //Links
			weisse.impulsHinzunehmen(new Vektor(-40, 0));
			break;
		case 27: //Rechts
			weisse.impulsHinzunehmen(new Vektor(40, 0));
			break;
		case 28: //Down
			weisse.impulsHinzunehmen(new Vektor(0, 40));
			break;
		case 26: //Down
			weisse.impulsHinzunehmen(new Vektor(0, -40));
			break;
		case 30: //Leertaste

			break;
		}
	}
	
	public static void main(String[] args) {
		new MiniBilliard();
	}

}