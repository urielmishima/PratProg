package problemaspropostos;

public class Losango extends Poligono {
	
	//Contrutor
	public Losango(double base, double altura) {
		super(base, altura);
	}
	
	//Metodos Sobrepostos
	@Override
	public double perimetro() {
		return getBase() * 4;
	}
	@Override
	public String imprima() {		
		return "Losango		" + super.imprima();
	}
}
