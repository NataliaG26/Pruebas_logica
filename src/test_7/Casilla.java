package test_7;

public class Casilla {
	
	private String name;
	private int escalera;
	private int serpiente;

	public Casilla(String name) {
		this.escalera = 0;
		this.serpiente = 0;
		this.name = name;
	}
	
	public String mensajeGame() {
		String msj = "Jugador avanza al cuadro "+name;
		if(escalera > 0)
			msj += "\nJugador sube por escalera al cuadro "+escalera;
		if(serpiente > 0) {
			msj += "\nJugador desciende al cuadro "+serpiente;
		}
		return msj;
	}
	
	public int getEscalera() {
		return escalera;
	}
	public void setEscalera(int escalera) {
		this.escalera = escalera;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSerpiente() {
		return serpiente;
	}
	public void setSerpiente(int serpiete) {
		this.serpiente = serpiete;
	}
	

}
