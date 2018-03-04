package problemaspropostos;

public class Cubo extends Solido {
	
	//Atributos
	private Quadrado quadrado;
	
	//Contrutor
	public Cubo(double profundidade) {
		super(profundidade);
		this.quadrado = new Quadrado(profundidade);
		setVolume(volume());
	}

	//Get e Set
	public Quadrado getQuadrado() {
		return quadrado;
	}
	public void setQuadrado(Quadrado quadrado) {
		this.quadrado = quadrado;
	}
	
	//Metodo Sobreposto
	@Override
	public double volume() {
		return getProfundidade() * 3;
	}

}
