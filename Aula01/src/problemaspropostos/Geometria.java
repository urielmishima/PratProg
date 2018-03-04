package problemaspropostos;

import java.util.ArrayList;

public class Geometria {

   public static void main(String[] args) {
      ArrayList<Figura> figuras = new ArrayList<>();
      figuras.add(new Circulo(5));
      figuras.add(new Triangulo(5, 5, 5, 5));
      figuras.add(new Losango(5, 5));
      figuras.add(new Retangulo(5, 5));
      figuras.add(new Quadrado(5));
      figuras.add(new Trapezio(5, 5, 5, 5, 5));
   	
      for(Figura f: figuras) {
         System.out.println(f.imprima());
      }
   	
   	
   
   }

}
