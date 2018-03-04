package problemaspropostos;

public class Esfera extends Circulo {
	
	//Atributos
	private double volume;
	
	//Construtor
	public Esfera(double raio, double volume) {
		super(raio);
		setVolume(volume());
	}

	//Get e Set
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double volume() {
		
		return (4/3) * Math.PI * Math.pow(getRaio(), 3);
	}

	
}
