/**
 * PRACTICA DAA 2: Torres de Hanoi
 * 
 * Vamos a crear un programa que resuelva el problema de las torres de hanoi para n discos.
 * 
 * @author alu0100888102
 * alu0100888102@ull.es
 * �ngel Alberto Hamilton L�pez
 */

public class TorresHanoi {
	Torre origen;
	Torre intermedia;
	Torre destino;
	int nDiscos;
	
	public TorresHanoi(){
		origen = new Torre();
		intermedia = new Torre();
		destino  = new Torre();
		origen.add(3);
		origen.add(2);
		origen.add(1);
		nDiscos = 3;
	}
	public TorresHanoi(int n){
		origen = new Torre();
		intermedia = new Torre();
		destino  = new Torre();
		for(int i =n; i>0; i--)
			origen.add(i);
		nDiscos = n;
	}
	
	public void solve(boolean debug){
		if(debug)
			System.out.println(origen +"\n" + intermedia +"\n" + destino + "\n\n");
		long startTime = System.nanoTime();
		llevarAlDestino(debug, nDiscos, origen, intermedia, destino);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		double miliseconds = (double)duration /1000000;
		System.out.println("Ha tardado: " + miliseconds + " milisegundos.");
	}
	
	/**
	 * la variante c�clica lleva los discos a la siguiente torre cada vez.
	 * @param debug
	 */
	public void solveCiclical(boolean debug){
		Torre start = null, end = null, aux = null;
		if(origen.getTop() != null){
			start = origen;
			end = intermedia;
			aux = destino;
		}
		if(intermedia.getTop() != null){
			start = intermedia;
			end = destino;
			aux = origen;
		}
		if(destino.getTop() != null){
			start = destino;
			end = origen;
			aux = intermedia;
		}
		if(debug)
			System.out.println(origen +"\n" + intermedia +"\n" + destino + "\n\n");
		llevarAlDestino(debug, nDiscos, start, aux, end);
	}
	/**
	 * el algoritmo que empleamos es el siguiente:
	 * Cada disco lo queremos llevar de Origen (ori) al destino (dest).  Si es el disco superior en la torre de origen lo movemos y ya.
	 * Si no, tenemos que mover el disco superior(n-1) a la torre auxiliar(aux), para dejarlo libre y poderlo mover al destino. Luego movemos n-1 de aux a dest para dejarlo encima de n.
	 * @param disco (numero de disco)
	 * @param ori (torre de origen)
	 * @param aux (torre auxiliar)
	 * @param dest (torre de destino)
	 */
	private void llevarAlDestino(boolean debug,int disco, Torre ori, Torre aux, Torre  dest){
		if(ori.getTop() == disco){
			dest.add(ori.getDisk());
			if(debug)
				System.out.println(origen +"\n" + intermedia +"\n" + destino + "\n\n");
		}
		else{
			llevarAlDestino(debug, disco-1, ori,dest,aux);
			dest.add(ori.getDisk());
			if(debug)
				System.out.println(origen +"\n" + intermedia +"\n" + destino + "\n\n");
			llevarAlDestino(debug, disco-1, aux, ori,dest);
		}
	}
	
	public static void main (String args[]){
		int n = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		boolean debug=false;
		if(b == 1)
			debug = true;
		TorresHanoi test = new TorresHanoi(n);
/*		System.out.println("--------------------------");
		test.solveCiclical(debug);
		System.out.println("--------------------------");
		test.solveCiclical(debug);
		System.out.println("--------------------------");
		test.solveCiclical(debug);
		System.out.println("--------------------------");		*/
		test.solve(debug);
		System.out.println("Pasos: " + (Math.pow(2, n) -1));
	}
}
