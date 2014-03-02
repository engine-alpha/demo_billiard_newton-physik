package phtests;

import ea.*;

public class PhysicsGame 
extends Game {
	
	enum Move {Right, Left, Nothing};

	private Move move = Move.Nothing;
	
	Kreis spieler;
	public PhysicsGame() {
		super(500,500);
		
		Rechteck boden = new Rechteck(0, 400, 500, 10);
		boden.farbeSetzen(new Farbe(25,25,25));
		boden.passivMachen();
		
		Rechteck wand1 = new Rechteck(0,0, 10, 500);
		Rechteck wand2 = new Rechteck(490, 0, 10, 500);
		wand1.farbeSetzen(new Farbe(25,25,25));
		wand2.farbeSetzen(new Farbe(25,25,25));
		wand1.passivMachen();
		wand2.passivMachen();
		
		Rechteck ebene = new Rechteck(160, 450, 100, 5);
		ebene.farbeSetzen("Blau");
		animationsManager.kreisAnimation(ebene, new Punkt(100, 400));
		ebene.passivMachen();
		
		spieler = new Kreis(40, 40, 20);
		spieler.farbeSetzen("Rot");
		spieler.aktivMachen();
		spieler.schwerkraftAktivSetzen(true);
		
		wurzel.add(spieler, boden, wand1, wand2, ebene);
		
		super.cam.fokusSetzen(spieler);
		
		Ticker mover = new Ticker() {
			@Override
			public void tick() {
				Vektor v = Vektor.NULLVEKTOR;
				if(move == Move.Right) {
					v = new Vektor(2, 0);
				} else if (move == Move.Left) {
					v = new Vektor(-2, 0);
				}
				spieler.bewegen(v);
			}};
		super.manager.anmelden(mover, 5);
	}
	
	@Override
	public void tasteReagieren(int code) {
		switch(code) {
		case 29: //Links
			move = Move.Left;
			break;
		case 27: //Rechts
			move = Move.Right;
			break;
		case 28: //Down
			spieler.positionSetzen(80, 80);
			break;
		case 26: //Down
			move = Move.Nothing;
			break;
		case 30: //Leertaste
			spieler.sprung(10);
			break;
		}
	}
	
	public static void main(String[] args) {
		new PhysicsGame();
		new PhysicsGame();
		new PhysicsGame();
	}

}
