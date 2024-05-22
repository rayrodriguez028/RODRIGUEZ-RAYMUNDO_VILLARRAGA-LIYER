package dh.backend.test;

import dh.backend.dao.impl.OdontologoEnMemoria;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoEnMemoriaTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoEnMemoria());

    @Test
    @DisplayName("Testear que un odontologo fue guardado")
    void registrar() {
        Odontologo odontologo = new Odontologo("DH-21052024","Juanito","Perez");
        Odontologo odontologoEnMemoria = odontologoService.registrar(odontologo);

        assertNotNull(odontologoEnMemoria);
    }

    @Test
    @DisplayName("Testear busqueda de todos los odontologos")
    void buscarTodos() {
        Odontologo odontologo = new Odontologo("DH-22052024","Raymundo","Rodriguez");
        odontologoService.registrar(odontologo);

        List<Odontologo> odontologooList = odontologoService.buscarTodos();

        assertEquals(2, odontologooList.size());
    }
}