package controller;

import dao.ApiD;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Dato;

@Path("servicios")
@Stateless
public class Service implements Serializable {
 
    private Dato dato;
    private ApiD dao;
    
    public Service() {
        dato = new Dato();
        dao = new ApiD();
    }
    
    @GET
    @Path("regresion")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRegresion() throws IOException {
        dato.setAge(30);
        return dao.getData();
    }

    public Dato getDato() {
        return dato;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }

    public ApiD getDao() {
        return dao;
    }

    public void setDao(ApiD dao) {
        this.dao = dao;
    }
    
}
