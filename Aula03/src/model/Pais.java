package model;

import java.io.Serializable;

public class Pais implements Serializable{
	//Atributos
   private static final long serialVersionUID = 1L;
   private int id;
   private String nome;
   private long populacao;
   private double area;
	
   public Pais() {
   }	
   
	//Gets e Sets
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public long getPopulacao() {
      return populacao;
   }
   public void setPopulacao(long populacao) {
      this.populacao = populacao;
   }
   public double getArea() {
      return area;
   }
   public void setArea(double area) {
      this.area = area;
   }
	
	//Metodos Sobrepostos.
   @Override
   public String toString() {
      return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao
         	+ ", area=" + area + "]";
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Pais other = (Pais) obj;
      if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
         return false;
      if (id != other.id)
         return false;
      if (nome == null) {
         if (other.nome != null)
            return false;
      } else if (!nome.equals(other.nome))
         return false;
      if (populacao != other.populacao)
         return false;
      return true;
   }
	
	
}
