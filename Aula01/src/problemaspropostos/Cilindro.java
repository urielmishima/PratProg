package problemaspropostos;

public class Cilindro extends Solido {
	
	//Atributos
	private Circulo circulo;
	
	//Construtor
	public Cilindro(double profundidade, double raio) {
		super(profundidade);
		this.circulo = new Circulo(raio);
		setVolume(volume());
	}
	
	//Get e Set
	public Circulo getCirculo() {
		return circulo;
	}

	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}
		
	//Metodo Sobreposto
	@Override
	public double volume() {
		return Math.PI * Math.pow(getCirculo().getRaio(), 3) * getProfundidade();
	}
}
