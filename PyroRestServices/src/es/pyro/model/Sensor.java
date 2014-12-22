package es.pyro.model;

import java.util.ArrayList;

public class Sensor {
	/*Jcatala 1 7 [0x1A, 0x20, 0x2A, 0x30, 0x38, 0x40, 0x54, 0x5C, 0x5A, 0x34]
	 *  2 True True True [1, 1, 1, 0, 1, 0, 0] 30 250 [0.1, 0.1, 0.989]
	 *   Vertical [0,899898982, 39,050494985, 25,30] 30� 80 
	 *   [35.8, 49.6, 45.3, 35.8, 49.6, 38.7, 39.2] 35.6
	 *   
	 *   
	 *   Jcatala; 1; 7; [0x1A, 0x20, 0x2A, 0x30, 0x38, 0x40, 0x54, 0x5C, 0x5A, 0x34];
2; True; True; True; [1, 1, 1, 0, 1, 0, 0]; 30; 250; [0.1, 0.1, 0.989];
Vertical; [0,899898982, 39,050494985, 25,30]; 30�; 80;
[35.8, 49.6, 45.3, 35.8, 49.6, 38.7, 39.2]; 35.6
	 *   
	 * */
	public Sensor() {
		// TODO Auto-generated constructor stub
	}
	
	public Sensor(String sensorString) {
		
		System.out.println(sensorString);
		String [] sensor = sensorString.split(";");
		this.propietario = sensor[0];
		this.id_capsula = Integer.parseInt(sensor[1].trim());
		this.sensores_rad = Integer.parseInt(sensor[2].trim());
		this.dir_fisica_sensor = sensor[3];
		this.fase_uso = Integer.parseInt(sensor[4].trim());
		this.sensor_HR_activo = Boolean.getBoolean(sensor[5].trim());
		this.conexion_activa = Boolean.getBoolean(sensor[6].trim());
		this.gps_activo = Boolean.getBoolean(sensor[7].trim());
		this.sensores_rad_activos = sensor[8];
		this.periodo_muestreo = Integer.parseInt(sensor[9].trim());
		this.tiempo_desconexion = Integer.parseInt(sensor[10].trim());
		this.lectura_acelerometro = sensor[11];
		
//		this.estado_capsula = Integer.parseInt(sensor[12].trim());
		this.estado_capsula = sensor[12].trim();
		this.posicion_UTM = new Coordinates(sensor[13]);
		this.orientacion_capsula = Integer.parseInt(sensor[14].trim().substring(0, sensor[14].trim().length()-1));
		this.lectura_sensor_HR = Double.parseDouble(sensor[15].trim());
		this.lectura_sensores_rad = sensor[16];
		this.temperatura_media_rad = Double.parseDouble(sensor[17].trim());
//		this.alerta_direccional = sensor[18];
//		this.alerta_tendencia = sensor[19];
//		this.alerta_caida =sensor[20];

	}	
	
	
	public Sensor(String propietario, int id_capsula, int sensores_rad,
			String dir_fisica_sensor, int fase_uso,
			boolean sensor_HR_activo, boolean conexion_activa,
			boolean gps_activo, String sensores_rad_activos,
			int periodo_muestreo, int tiempo_desconexion,
			String lectura_acelerometro, String estado_capsula,
			Coordinates posicion_UTM, int orientacion_capsula,
			double lectura_sensor_HR, String lectura_sensores_rad,
			int temperatura_media_rad, String alerta_direccional,
			boolean alerta_tendencia, boolean alerta_caida) {
		super();
		this.propietario = propietario;
		this.id_capsula = id_capsula;
		this.sensores_rad = sensores_rad;
		this.dir_fisica_sensor = dir_fisica_sensor;
		this.fase_uso = fase_uso;
		this.sensor_HR_activo = sensor_HR_activo;
		this.conexion_activa = conexion_activa;
		this.gps_activo = gps_activo;
		this.sensores_rad_activos = sensores_rad_activos;
		this.periodo_muestreo = periodo_muestreo;
		this.tiempo_desconexion = tiempo_desconexion;
		this.lectura_acelerometro = lectura_acelerometro;
		this.estado_capsula = estado_capsula;
		this.posicion_UTM = posicion_UTM;
		this.orientacion_capsula = orientacion_capsula;
		this.lectura_sensor_HR = lectura_sensor_HR;
		this.lectura_sensores_rad = lectura_sensores_rad;
		this.temperatura_media_rad = temperatura_media_rad;
		this.alerta_direccional = alerta_direccional;
		this.alerta_tendencia = alerta_tendencia;
		this.alerta_caida = alerta_caida;
	}



	// Configuracion
	private String propietario;
	private int id_capsula;
	private int sensores_rad;
	private String dir_fisica_sensor;
	
	// Despliegue
	private int fase_uso;
	private boolean sensor_HR_activo;
	private boolean conexion_activa;
	private boolean gps_activo;
	private String sensores_rad_activos;
	private int periodo_muestreo;
	private int tiempo_desconexion;
	
	// Mediciones
	private String lectura_acelerometro;
	private String estado_capsula;
	private Coordinates posicion_UTM;
	private int orientacion_capsula;
	private double lectura_sensor_HR;
	private String lectura_sensores_rad;
	private double temperatura_media_rad;
	
	// Alertas
	private String alerta_direccional;
	private boolean alerta_tendencia;
	private boolean alerta_caida;
        
        private int alerta_direccional_1;
        private int alerta_direccional_2;
        private int alerta_direccional_3;
        private int alerta_direccional_4;
        private int alerta_direccional_5;
        private int alerta_direccional_6;
        private int alerta_direccional_7;
        
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public int getId_capsula() {
		return id_capsula;
	}
	public void setId_capsula(int id_capsula) {
		this.id_capsula = id_capsula;
	}
	public int getSensores_rad() {
		return sensores_rad;
	}
	public void setSensores_rad(int sensores_rad) {
		this.sensores_rad = sensores_rad;
	}
	public String getDir_fisica_sensor() {
		return dir_fisica_sensor;
	}
	public void setDir_fisica_sensor(String dir_fisica_sensor) {
		this.dir_fisica_sensor = dir_fisica_sensor;
	}
	public int getFase_uso() {
		return fase_uso;
	}
	public void setFase_uso(int fase_uso) {
		this.fase_uso = fase_uso;
	}
	public boolean isSensor_HR_activo() {
		return sensor_HR_activo;
	}
	public void setSensor_HR_activo(boolean sensor_HR_activo) {
		this.sensor_HR_activo = sensor_HR_activo;
	}
	public boolean isConexion_activa() {
		return conexion_activa;
	}
	public void setConexion_activa(boolean conexion_activa) {
		this.conexion_activa = conexion_activa;
	}
	public boolean isGps_activo() {
		return gps_activo;
	}
	public void setGps_activo(boolean gps_activo) {
		this.gps_activo = gps_activo;
	}
	public String getSensores_rad_activos() {
		return sensores_rad_activos;
	}
	public void setSensores_rad_activos(String sensores_rad_activos) {
		this.sensores_rad_activos = sensores_rad_activos;
	}
	public int getPeriodo_muestreo() {
		return periodo_muestreo;
	}
	public void setPeriodo_muestreo(int periodo_muestreo) {
		this.periodo_muestreo = periodo_muestreo;
	}
	public int getTiempo_desconexion() {
		return tiempo_desconexion;
	}
	public void setTiempo_desconexion(int tiempo_desconexion) {
		this.tiempo_desconexion = tiempo_desconexion;
	}
	public String getLectura_acelerometro() {
		return lectura_acelerometro;
	}
	public void setLectura_acelerometro(String lectura_acelerometro) {
		this.lectura_acelerometro = lectura_acelerometro;
	}
	public String getEstado_capsula() {
		return estado_capsula;
	}
	public void setEstado_capsula(String estado_capsula) {
		this.estado_capsula = estado_capsula;
	}
	public String getPosicion_UTM() {
		return posicion_UTM.getCoordinates();
	}
        public Coordinates getPosicion_UTM_Coordinates(){
            return posicion_UTM;
        }
	public void setPosicion_UTM(Coordinates posicion_UTM) {
		this.posicion_UTM = posicion_UTM;
	}
	public int getOrientacion_capsula() {
		return orientacion_capsula;
	}
	public void setOrientacion_capsula(int orientacion_capsula) {
		this.orientacion_capsula = orientacion_capsula;
	}
	public double getLectura_sensor_HR() {
		return lectura_sensor_HR;
	}
	public void setLectura_sensor_HR(double lectura_sensor_HR) {
		this.lectura_sensor_HR = lectura_sensor_HR;
	}
	public String getLectura_sensores_rad() {
		return lectura_sensores_rad;
	}
	public void setLectura_sensores_rad(String lectura_sensores_rad) {
		this.lectura_sensores_rad = lectura_sensores_rad;
	}
	public double getTemperatura_media_rad() {
		return temperatura_media_rad;
	}
	public void setTemperatura_media_rad(double temperatura_media_rad) {
		this.temperatura_media_rad = temperatura_media_rad;
	}
	public String getAlerta_direccional() {
		return alerta_direccional;
	}
	public void setAlerta_direccional(String alerta_direccional) {
		this.alerta_direccional = alerta_direccional;
	}
	public boolean isAlerta_tendencia() {
		return alerta_tendencia;
	}
	public void setAlerta_tendencia(boolean alerta_tendencia) {
		this.alerta_tendencia = alerta_tendencia;
	}
	public boolean isAlerta_caida() {
		return alerta_caida;
	}
	public void setAlerta_caida(boolean alerta_caida) {
		this.alerta_caida = alerta_caida;
	}

        	public int getAlerta_direccional_1() {
		return alerta_direccional_1;
	}

	public void setAlerta_direccional_1(int alerta_direccional_1) {
		this.alerta_direccional_1 = alerta_direccional_1;
	}

	public int getAlerta_direccional_2() {
		return alerta_direccional_2;
	}

	public void setAlerta_direccional_2(int alerta_direccional_2) {
		this.alerta_direccional_2 = alerta_direccional_2;
	}

	public int getAlerta_direccional_3() {
		return alerta_direccional_3;
	}

	public void setAlerta_direccional_3(int alerta_direccional_3) {
		this.alerta_direccional_3 = alerta_direccional_3;
	}

	public int getAlerta_direccional_4() {
		return alerta_direccional_4;
	}

	public void setAlerta_direccional_4(int alerta_direccional_4) {
		this.alerta_direccional_4 = alerta_direccional_4;
	}

	public int getAlerta_direccional_5() {
		return alerta_direccional_5;
	}

	public void setAlerta_direccional_5(int alerta_direccional_5) {
		this.alerta_direccional_5 = alerta_direccional_5;
	}

	public int getAlerta_direccional_6() {
		return alerta_direccional_6;
	}

	public void setAlerta_direccional_6(int alerta_direccional_6) {
		this.alerta_direccional_6 = alerta_direccional_6;
	}

	public int getAlerta_direccional_7() {
		return alerta_direccional_7;
	}

	public void setAlerta_direccional_7(int alerta_direccional_7) {
		this.alerta_direccional_7 = alerta_direccional_7;
	}
        
	@Override
	public String toString() {
		return "Sensor [propietario=" + propietario + ", id_capsula="
				+ id_capsula + ", sensores_rad=" + sensores_rad
				+ ", dir_fisica_sensor=" + dir_fisica_sensor + ", fase_uso="
				+ fase_uso + ", sensor_HR_activo=" + sensor_HR_activo
				+ ", conexion_activa=" + conexion_activa + ", gps_activo="
				+ gps_activo + ", sensores_rad_activos=" + sensores_rad_activos
				+ ", periodo_muestreo=" + periodo_muestreo
				+ ", tiempo_desconexion=" + tiempo_desconexion
				+ ", lectura_acelerometro=" + lectura_acelerometro
				+ ", estado_capsula=" + estado_capsula + ", posicion_UTM="
				+ posicion_UTM + ", orientacion_capsula=" + orientacion_capsula
				+ ", lectura_sensor_HR=" + lectura_sensor_HR
				+ ", lectura_sensores_rad=" + lectura_sensores_rad
				+ ", temperatura_media_rad=" + temperatura_media_rad + "]";
	}
	
	
	
	
	
}
