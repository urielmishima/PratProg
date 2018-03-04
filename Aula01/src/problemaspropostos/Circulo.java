package problemaspropostos;

public class Circulo extends Figura {
	
	//Atributos
	private double raio;
	
	//Construtor
	public Circulo(double raio) {
		super();
		this.raio = raio;
		setArea(area());
	}
	
	//Get and Set	
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	//Metodos Sobrepostos
	@Override
	public double area() {		
		return 2 * Math.PI * Math.pow(raio, 2);
	}
	@Override
	public double perimetro() {
		return Math.PI * Math.pow(getRaio(), 2);
	}
	@Override
	public String imprima() {		
		return "Circulo		" + super.imprima();
	}
	
	

}
