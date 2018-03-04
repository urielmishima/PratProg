package problemaspropostos;

public abstract class Poligono extends Figura {

	//Atributos
	private double base;
	private double altura;
	
	//Construtor
	public Poligono(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
		setArea(area());
	}
		
	//Gets e Sets
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	//Metodo Sobreposto
	@Override
	public double area() {		
		return getBase() * getAltura();
	}

	



}
