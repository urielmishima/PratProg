package problemaspropostos;

public abstract class Solido {
	
	//atributos
	private double profundidade;
	private double volume;
		
	//Construtor
	public Solido(double profundidade) {
		this.profundidade = profundidade;
	}
	
	//Gets e Sets
	public double getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}


	//Metodo Abstrato	
	public abstract double volume();
}
