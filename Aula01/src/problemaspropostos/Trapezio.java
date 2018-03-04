package problemaspropostos;

public class Trapezio extends Poligono {
	
	//Atributos
	private double baseMenor;
	private double lado1;
	private double lado2;
	
	//Construtor
	public Trapezio(double base, double altura, double baseMenor, double lado1, double lado2) {
		super(base, altura);
		this.baseMenor = baseMenor;
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	
	//Gets e Sets
	public double getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}
	public double getLado1() {
		return lado1;
	}
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}
	public double getLado2() {
		return lado2;
	}
	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}	
	
	//Metodos Sobrescritos
	@Override
	public double perimetro() {
		return getLado1() + getLado2() + getBase() + getBaseMenor();
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (getBase() + getBaseMenor()) * getAltura() / 2;
	}
	@Override
	public String imprima() {
		return "Trapezio 	" + super.imprima();
	}
	

}
