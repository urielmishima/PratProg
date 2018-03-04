package problemaspropostos;

public class Triangulo extends Poligono {
	
	//Atributos
	private double m;
	private double n;
	
	//Construtor
	public Triangulo(double base, double altura, double m, double n) {
		super(base, altura);
		this.m = m;
		this.n = n;
	}

	//Gets e Sets
	public double getM() {
		return m;
	}
	public void setM(double m) {
		this.m = m;
	}
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}

	//Metodos Sobrepostos
	@Override
	public double area() {
		return super.area() / 2;
	}
	@Override
	public double perimetro() {
		return m + n + getBase();
	}
	@Override
	public String imprima() {		
		return "Triangulo	" + super.imprima();
	}
	
	
}
