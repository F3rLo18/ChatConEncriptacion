package paquete;
import java.awt.*;
import javax.swing.*;

public class interfazSesionIniciada extends JFrame{
    private void ventanaSesionIniciada(){
    iniciarComponentes();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
    crearVentana();
    }
    private void crearVentana(){
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setTitle("Interfaz de usuario");
        this.setResizable(false);
    }
    private void iniciarPanelListaContactos(){
        JPanel panel= new JPanel();
        panel.setSize(800,800);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        

    }




}
