package problemaspropostos;

public class Quadrado extends Poligono implements Diagonal {
	
	//Atributos
	private double diagonal;

	//Metodo Cosntrutor
	public Quadrado(double base) {
		super(base, base);
		setDiagonal(diagonal());
	}
	
	//Get e Set
	public double getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
	
	//Metodos Sobrescritos
	@Override
	public double diagonal() {
		return getAltura() * Math.sqrt(2);
	}
	@Override
	public double perimetro() {
		return getAltura() * 4;
	}
	@Override
	public String imprima() {		
		return "Quadrado 	" + super.imprima() + ", diagonal = " + diagonal();
	}

}
