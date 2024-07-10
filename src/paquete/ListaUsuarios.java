package paquete;
import java.util.ArrayList;

public class ListaUsuarios {
private static ArrayList<Persona> usuarios = new ArrayList<>();
private static int codigo=202300000;


public static void crearAdmin() {
    Persona admin= new Persona("Fernando Josue","Lopez Iboy", 19, "Masculino", "278912","38701573");
    admin.setCodigo("202300840");
    admin.setAdmin(true);
    usuarios.add(admin);

}
public static boolean comprobarContrasenna(String contrasegna, String codigo){
    boolean correcto= false;
    for(Persona usuario:usuarios){
        if(usuario.getCodigo().equals(codigo) && usuario.getContrasegna().equals(contrasegna)){
                correcto=true;
            }
        
    }
    return correcto;
}
public static void agregarusuario(Persona usuarioNuevo,int codigo){
    String cod= String.valueOf(codigo);
    ListaUsuarios.setCodigo(cod);
    usuarios.add(usuarioNuevo);
    usuarioNuevo.setCodigo(cod);
}

public static int getCodigo() {
    return codigo;
}

public static void setCodigo(String codigo) {
    int codig= Integer.parseInt(codigo);
    ListaUsuarios.codigo = codig;
}

public static boolean buscarUsuario(String codigo){
    boolean encontrado= false;

    for(Persona persona:usuarios){
        if(encontrado){break;}
        if(persona instanceof Persona usuario && usuario.getCodigo().equals(codigo)){
                encontrado= true;
                
            }
    }
    return encontrado;

}

}
