package controller;

import dao.ApiD;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Dato;

@Named(value = "apiC")
@SessionScoped
public class ApiC implements Serializable {

    private Dato dato;
    private ApiD dao;
    
    public ApiC() {
        dato = new Dato();
        dao = new ApiD();
    }

    public void enviar() throws IOException {
        dao.postPredict(dato);
    }
    
    public void obtener() throws IOException {
        dao.getData();
    }
    
    public static void main(String[] args) throws IOException {
        ApiC api = new ApiC();
        api.dato.setAge(50);
        api.dato.setSex(0);
        api.enviar();
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
