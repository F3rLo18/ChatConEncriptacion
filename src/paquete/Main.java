package paquete;

public class Main {
    public static final Login ventanaLogin= new Login();
    
    public static void main(String[] args) {
        ventanaLogin.setVisible(true);
    }

    public static void abrirLogin(){
        ventanaLogin.setVisible(true);
    }
    public static void cerrarLogin(){
        ventanaLogin.dispose();
    }

}
