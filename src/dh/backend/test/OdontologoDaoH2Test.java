package dh.backend.test;

import dh.backend.dao.impl.OdontologoDaoH2;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDaoH2Test {

    private static Logger LOGGER = Logger.getLogger(OdontologoDaoH2Test.class);
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/db_clinica_2105;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que un odontologo fue guardado h2")
    void registrar() {
        Odontologo odontologo = new Odontologo("DH-22052024","Liyer","Villarraga");
        Odontologo odontologoEnH2 = odontologoService.registrar(odontologo);
        assertNotNull(odontologoEnH2);
    }

    @Test
    @DisplayName("Testear busqueda de todos los odontologos h2")
    void buscarTodos() {
        Odontologo odontologo = new Odontologo("DH-23052024","Julieth","Pinzon");
        Odontologo odontologoEnH2 = odontologoService.registrar(odontologo);

        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(3, odontologos.size());
    }
}