/**
 * PRACTICA DAA 2: Torres de Hanoi
 * 
 * Esta clase representa una torre. Los discos se representan por numeros (1 más pequeño, 3 más grande).
 * 
 * @author alu0100888102
 * alu0100888102@ull.es
 * Ángel Alberto Hamilton López
 */

import java.util.*;

public class Torre {
	ArrayList<Integer> almacen;
	
	public Torre(){
		almacen = new ArrayList<Integer>();
	}
	public ArrayList<Integer> getAlmacen(){
		return almacen;
	}
	public void setAlmacen(ArrayList<Integer> a){
		almacen = a;
	}
	
	public Integer getTop(){
		int n = almacen.size() -1;
		if(n<0)
			return null;
		return almacen.get(n);
	}
	public Integer getDisk(){
		int n = almacen.size() -1;
		if(n<0)
			throw new IllegalArgumentException("No hay mas discos en la torre");
		int out = almacen.get(n);
		almacen.remove(n);
		return out;
	}
	public void add(int d){
		if(d> almacen.get(almacen.size() - 1))
			throw new IllegalArgumentException("No se puede poner un disco sobre otro mas pequeño");
		almacen.add(d);
	}
	
	public String toString(){
		String out = new String();
		for(int i = almacen.size()-1; i>=0; i--)
			out += almacen.get(i);
		return out;
	}
}
