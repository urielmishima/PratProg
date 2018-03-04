package problemaspropostos;

public abstract class Figura {
	
	//Atributos
	private double area;
	private double perimetro;
	
	//Construtores
	public Figura(double area) {
		this.area = area;
	}
	public Figura() {
		
	}
	
	//Get e Set
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}
	
	//Metodo Abstratos
	public abstract double area();
	public abstract double perimetro();
	
	//Outros Metodos
	public String imprima() {
		return "| Area = " + area() + ", perimetro = " + perimetro(); 
	}
}
