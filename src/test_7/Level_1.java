package test_7;
public class Level_1 {
	
	private static Casilla[] tablero;

	public static void main(String[] args) {
		//inicializar juego
		tablero = new Casilla[26];
		
		for (int i = 1; i <= 25; i++) {
			Casilla c = new Casilla(i+"");
			tablero[i] = c;
		}
		
		//Escaleras
		tablero[3].setEscalera(11);
		tablero[10].setEscalera(12);
		tablero[9].setEscalera(18);
		tablero[6].setEscalera(17);
		
		//serpientes
		tablero[14].setSerpiente(4);
		tablero[19].setSerpiente(8);
		tablero[24].setSerpiente(16);
		tablero[22].setSerpiente(20);
		
		
		//Juego
		int count = 0;
		while(count < 25) {
			int b = (int)(Math.random()*(6)+1);
			System.out.println("Dado arroja "+b);
			count += b;
			if(count < 26) {
				System.out.println(tablero[count].mensajeGame());
				int escalera = tablero[count].getEscalera();
				count = escalera > 0 ? escalera : count;
				int serpiente = tablero[count].getSerpiente();
				count = serpiente > 0 ? serpiente : count;
			}else {
				System.out.println("Jugador supera el cuadro 25");
			}
		}
		
		System.out.println("Fin");

	}

}
