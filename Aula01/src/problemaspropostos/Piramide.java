package problemaspropostos;

public class Piramide extends Solido {
	
	//Atributos
	private Triangulo triangulo;
	
	//Construtor
	public Piramide(double profundidade, double base, double altura, double m, double n) {
		super(profundidade);
		this.triangulo = new Triangulo(base, altura, m, n);
		setVolume(volume());
	}

	//Get e Set
	public Triangulo getTriangulo() {
		return triangulo;
	}
	public void setTriangulo(Triangulo triangulo) {
		this.triangulo = triangulo;
	}

	//Metodo sobreposto
	@Override
	public double volume() {
		return (1/3) * getTriangulo().getAltura() * getProfundidade() * getTriangulo().getBase();
	}

}
