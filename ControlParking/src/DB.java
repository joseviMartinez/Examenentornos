import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;






import javax.swing.JComboBox;
import javax.swing.text.Segment;

import com.mysql.jdbc.Statement;

public class DB {
	Connection conexion = null; //maneja la conexión
	Segment instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	JComboBox<Coche> listcox;
	public DB() {
		crearConexion();
	}
		
	public  DB(JComboBox<Coche> listadoCoche){
		crearConexion();
		//nos permite que veamos el combobox
		this.listcox=listadoCoche;
	}
	

	private void crearConexion() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","tonphp");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
			}// fin de catch
		
	}

	public void leerCoches(){
		try{
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery("SELECT *controlcoches");
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
				Coche C =new coChe();
				
				C.guardarid(int)conjuntoreltados.getObject("id");
				C.guardarmatricula((String)conjuntoresultados.getObject("Matricula"));
				C.guardarhoraentrada((int)conjuntoresultados.getObject("HoraEntrada"));
				C.guardarhorasalida((String)conjuntoresultados.getObject("HoraSalida"));
				C.guardarprecio(preu);((int)conjuntoresultados.getObject("Edad"));
	listadelincuentes.addItem(D);

			}
			conjuntoResultados.close();

	}	

}
