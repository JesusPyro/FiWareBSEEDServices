/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pyro.ws;


import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author jjmartinez
 */
@Path("/helloWorld")
public class HelloWorld {

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public String HelloWorldRequest() {
        return "This is a Hello World Service";
    }   
}
