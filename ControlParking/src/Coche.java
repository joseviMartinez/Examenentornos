
public class Coche {
// creacion de los atributos
	private int id;
	private String matricula;
	private int horaentrada;
	private int horasalida;
	private float precio;
	private String observaciones;
	private int total;
	public Coche() {
		// inicializacion de los atributos
	id=0;
	matricula="";
	horaentrada=0;
	horasalida=0;
	precio=0;
	observaciones="";
	total=(horaentrada-horasalida)*2;
	}

	//creacion de los metodos de recuperacion y modificacion
	
	public void guardarid (int id1){
		id=id1;
	}
	public void guardarmatricula(String matri){
		matricula=matri;
	}
	public void guardarhoraentrada(int hore){
		horaentrada=hore;
	}
	public void guardarhorasalida(int horas){
		horasalida=horas;
	}
	public void guardarprecio(float preu){
		precio=preu;
	}
	public void guardarobservaciones(String obser){
		observaciones=obser;
	}
	public int cogerid(){
		return id;
	}
	public String cogermatricula(){
		return matricula;
	}
	public int cogerhoraentrada(){
		return horaentrada;
	}
	public int cogerhorasalida(){
		return horasalida;
	}
	public float cogerprecio(){
		return precio;
	}
	public String cogerobservaciones(){
		return observaciones;
	}
	public void guardar(int tot){
		total=tot;
	}
	public int cogertotal(int horaentrada, int horasalida){
		return total;
	}
	public String toString(){
		return matricula;
	}
}
