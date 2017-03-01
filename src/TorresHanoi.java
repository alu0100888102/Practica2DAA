/**
 * PRACTICA DAA 2: Torres de Hanoi
 * 
 * Vamos a crear un programa que resuelva el problema de las torres de hanoi para n discos.
 * 
 * @author alu0100888102
 * alu0100888102@ull.es
 * Ángel Alberto Hamilton López
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
	
	public void solve(){
		llevarAlDestino(nDiscos, origen, intermedia, destino);
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
	private void llevarAlDestino(int disco, Torre ori, Torre aux, Torre  dest){
		if(ori.getTop() == disco)
			dest.add(ori.getDisk());
		else{
			llevarAlDestino(disco-1, ori,dest,aux);
			dest.add(ori.getDisk());
			llevarAlDestino(disco-1, aux, ori,dest);
		}
		System.out.println(origen +"\n" + intermedia +"\n" + destino);
	}
}
