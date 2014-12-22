/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pyro.util;

import es.pyro.model.Sensor;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jjmartinez
 */

    

public class QueryDB {

	private static final String TABLE_SENSOR = "sensor";
	

	public Connection conecta() throws ClassNotFoundException, SQLException {
		Connection con;
		/* Exterior */
                
                
                String database = "bseed";
                String url = " jdbc:postgresql://54.77.89.234:5433/"+database;
                String username = "postgres";
                String password = "gisansware";
                
		
		Class.forName("org.postgresql.Driver"); // load the driver
		
		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);

		con = (Connection) DriverManager.getConnection(url, props);

		return con;
	}


        
        public void insertSensor(Sensor sensor)
			throws ClassNotFoundException, SQLException {
		Connection conn = this.conecta();
		Statement st = conn.createStatement();            
		
		String sql = "insert into " + QueryDB.TABLE_SENSOR + " values("
				+ sensor.getId_capsula()+ "," 
                                + sensor.getSensores_rad() + ",'"
				+ sensor.getDir_fisica_sensor() + "', " 
                                + sensor.getFase_uso()+ ","
				+ sensor.isSensor_HR_activo() + ","
				+ sensor.isConexion_activa() + "," 
                                + sensor.isGps_activo() + ",'" 
                                + sensor.getSensores_rad_activos()+ "',"
				+ sensor.getPeriodo_muestreo()+","  
                                + sensor.getTiempo_desconexion() + ",'"
				+ sensor.getLectura_acelerometro()+ "','"
				+ sensor.getEstado_capsula() + "'," 
                                +"ST_GeomFromText('POINT("
				+ sensor.getPosicion_UTM_Coordinates().getLongitude()+ " "
				+ sensor.getPosicion_UTM_Coordinates().getLatitude() + " "
				+ sensor.getPosicion_UTM_Coordinates().getAltitude() + ")'," + 4326 + "),'" 
                                + sensor.getOrientacion_capsula() + "," 
                                + sensor.getLectura_sensor_HR() + ",'"
                                + sensor.getLectura_sensores_rad() + "','"
                                + sensor.getAlerta_direccional() +"',"
                                + sensor.isAlerta_tendencia() +","
                                + sensor.isAlerta_caida() + ",'"
                                + sensor.getPropietario() + "',"
                                + sensor.getId_capsula()+ ","
                                + sensor.getTemperatura_media_rad()
				+ ")";

                System.out.println("sql");
                st.executeUpdate(sql);

		st.close();
		conn.close();

	}


	public void updateSensor(Sensor sensor) throws ClassNotFoundException, SQLException {
		Connection conn = this.conecta();
		Statement st = conn.createStatement();
                
                String[] alertaDireccional = sensor.getAlerta_direccional().split(",");

		String sql = "update" + QueryDB.TABLE_SENSOR + "set " 
                        +"id_capsula=" + sensor.getId_capsula() +","
                        +"sensores_rad="+sensor.getSensores_rad() +",'"
                        + "direcciones_fisicas_sensores="+ sensor.getDir_fisica_sensor() +"',"
                        + "fase_uso=" + sensor.getFase_uso() +","
                        + "sensor_hr_activo=" + sensor.isSensor_HR_activo()+","
                        + "conexion_activa="+sensor.isConexion_activa() +","
                        + "gps_activo="+ sensor.isGps_activo()+",'" 
                        + "sensores_rad_activos=" + sensor.getSensores_rad_activos()+"',"
                        + "periodo_muestre=" + sensor.getPeriodo_muestreo()+","
                        + "tiempo_desconexion="+sensor.getTiempo_desconexion()+",'" 
                        + "lectura_acelerometro="+sensor.getLectura_acelerometro()+"','"
                        + "estado_capsula="+sensor.getEstado_capsula()+"',"
                        + "posicion_utm="+"ST_GeomFromText('POINT("
				+ sensor.getPosicion_UTM_Coordinates().getLongitude()+ " "
				+ sensor.getPosicion_UTM_Coordinates().getLatitude() + " "
				+ sensor.getPosicion_UTM_Coordinates().getAltitude() + ")'," + 4326 + "),'" 
                        + "orientacion_capsula=" +sensor.getOrientacion_capsula()+"," 
                        +"lectura_sensor_hr="+sensor.getLectura_sensor_HR()+",'"
                        +"lectura_sensores_rad="+ sensor.getLectura_sensores_rad()+"','"
                        +"alerta_direccional="+sensor.getAlerta_direccional()+"',"
                        +"alerta_tendencia="+sensor.isAlerta_tendencia()+","
                        +"alerta_caida="+sensor.isAlerta_caida()+",'"
                        +"propietario="+sensor.getPropietario()+"',"
                        +"id_cap="+sensor.getId_capsula()+ ","
                        +"lectura_sensores_rad_med="+sensor.getTemperatura_media_rad()
                        +"alerta_direccional_1="+ alertaDireccional[0].substring(1) + ","
                        +"alerta_direccional_2="+ alertaDireccional[1]+ ","
                        +"alerta_direccional_3="+ alertaDireccional[2]+ ","
                        +"alerta_direccional_4="+ alertaDireccional[3]+ ","
                        +"alerta_direccional_5="+ alertaDireccional[4]+ ","
                        +"alerta_direccional_6="+ alertaDireccional[5]+ ","
                        +"alerta_direccional_7="+alertaDireccional[6].substring(0,alertaDireccional[6].length()-1)
                        ;
                System.out.println("sql");
		st.executeUpdate(sql);

		st.close();
		conn.close();

	}
	
}

