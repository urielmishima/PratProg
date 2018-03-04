package problemaspropostos;

public class Retangulo extends Poligono implements Diagonal {
	
	//Atributos
	private double diagonal;

	//Construtor
	public Retangulo(double base, double altura) {
		super(base, altura);
		setDiagonal(diagonal());
	}
	
	//Get e Set
	public double getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
	
	//Metodos Sobrepostos
	@Override
	public double diagonal() {
		return Math.sqrt(Math.pow(getBase(), 2) + Math.pow(getAltura(), 2));
	}
	@Override
	public double perimetro() {
		return getBase() * 2 + getAltura() * 2;
	}
	@Override
	public String imprima() {		
		return "Retangulo 	" + super.imprima() + ", diagonal = " + diagonal();
	}
	

}
