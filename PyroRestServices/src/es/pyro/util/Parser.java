/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pyro.util;

import es.pyro.model.Coordinates;
import es.pyro.model.Sensor;
import java.io.IOException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
/**
 *
 * @author jjmartinez
 */
public class Parser {
    public Parser(){
        
    }
    
    /*
    {
  "subscriptionId" : "51c04a21d714fb3b37d7d5a7",
  "originator" : "localhost",
  "contextResponses" : [
    {
      "contextElement" : {
        "attributes" : [
          {
            "name" : "temperature",
            "type" : "float",
            "value" : "26.5"
          }
        ],
        "type" : "Room",
        "isPattern" : "false",
        "id" : "Room1"
      },
      "statusCode" : {
        "code" : "200",
        "reasonPhrase" : "OK"
      }
    }
  ]
}*/
    
    public Sensor parserString2Sensor(String event)throws JSONException, Exception, IOException {
       Sensor sensor = new Sensor();
       System.out.println(event);
       JSONObject obj = new JSONObject(event);
       JSONArray features = obj.getJSONArray("contextResponses");
       JSONObject contextElement = features.getJSONObject(0);
       JSONArray attributes = contextElement.getJSONArray("attributes");
       for (int i = 0; i < attributes.length(); i++) {
           JSONObject attribute = features.getJSONObject(i);
	   String name = attribute.getString("name");
	   String type = attribute.getString("type");
           if(name.equals("propietario")){
               String propietario = attribute.getString("value");
               sensor.setPropietario(propietario);
           }
           else if (name.equals("sensores_rad")){
               int sensores_rad = attribute.getInt("value");
               sensor.setSensores_rad(sensores_rad);
           }
           else if (name.equals("dir_fisica_sensores")){
               String dir_fisica_sensores = attribute.getString("value");
               sensor.setDir_fisica_sensor(dir_fisica_sensores);
           }
           else if (name.equals("fase_uso")){
                int fase_uso = attribute.getInt("value");
                sensor.setFase_uso(fase_uso);
           }
           else if (name.equals("sensor_HR_activo")){
               boolean sensor_HR_activo = attribute.getBoolean("value");
               sensor.setSensor_HR_activo(sensor_HR_activo);
           }
           else if (name.equals("conexion_activa")){
                boolean conexion_activa = attribute.getBoolean("value");
                sensor.setConexion_activa(conexion_activa);
           }
           else if (name.equals("gps_activo")){
                 boolean gps_activo = attribute.getBoolean("value");
                 sensor.setGps_activo(gps_activo);
           }
           else if (name.equals("sensores_rad_activos")){
               String sensores_rad_activos = attribute.getString("value");
               sensor.setSensores_rad_activos(sensores_rad_activos);
           }
           else if (name.equals("periodo_muestreo")){
                int periodo_muestreo = attribute.getInt("value");
                sensor.setPeriodo_muestreo(periodo_muestreo);
           }
           else if (name.equals("tiempo_desconexion")){
                 int tiempo_desconexion = attribute.getInt("value");
                 sensor.setTiempo_desconexion(tiempo_desconexion);
           }
           else if (name.equals("lectura_acelerometro")){
                String lectura_acelerometro = attribute.getString("value");
                sensor.setLectura_acelerometro(lectura_acelerometro);
           }
           else if (name.equals("estado_capsula")){
               String estado_capsula = attribute.getString("value");
               sensor.setEstado_capsula(estado_capsula);
           }
           else if (name.equals("posicion_UTM")){
               String posicion_UTM = attribute.getString("value");
               Coordinates coordinates = new Coordinates(posicion_UTM);
               sensor.setPosicion_UTM(coordinates);
           }
           else if (name.equals("orientacion_capsula")){
               int orientacion_capsula = attribute.getInt("value");
               sensor.setOrientacion_capsula(orientacion_capsula);
           }
           else if (name.equals("lectura_sensor_HR")){
               double lectura_sensor_HR = attribute.getDouble("value");
               sensor.setLectura_sensor_HR(lectura_sensor_HR);
               
           }
           else if (name.equals("lectura_sensores_rad")){
               String lectura_sensores_rad = attribute.getString("value");
               sensor.setLectura_sensores_rad(lectura_sensores_rad);
               
           }
           else if (name.equals("temperatura_media_rad")){
                double temperatura_media_rad = attribute.getDouble("value");
                sensor.setTemperatura_media_rad(temperatura_media_rad);
           }
           
       }
		
        return sensor;
    }
    
    

    
}
