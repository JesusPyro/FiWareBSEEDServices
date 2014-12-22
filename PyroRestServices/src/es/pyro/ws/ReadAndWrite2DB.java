/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pyro.ws;

//import com.sun.istack.internal.NotNull;
import es.pyro.model.Sensor;
import es.pyro.util.Parser;
import es.pyro.util.QueryDB;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author jjmartinez
 */
@Path("/eventsReceived")
public class ReadAndWrite2DB {

    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public String EventsReceivedRequest(@DefaultValue("") @QueryParam("sensor") String event) {
        try {
            Parser parser = new Parser();
            System.out.println("en EventsReceivedRequest-->"+event);
            Sensor sensor = parser.parserString2Sensor(event);
            QueryDB query = new QueryDB();
            query.insertSensor(sensor);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ("0");
        }

        return "1";
    }   
}
