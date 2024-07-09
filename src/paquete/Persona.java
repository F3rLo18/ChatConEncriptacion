package paquete;

public class Persona {
    private String nombres;
    private String apellidos;
    private int edad;
    private String sexo;
    private String contrasegna;
    private String telefono;
    private String codigo;
    private boolean admin;
    //Constructor de la clase cuando se  envía el número de teléfono 
    public Persona(String nombres, String apellidos, int edad, String sexo, String contrasegna,String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasegna = contrasegna;
        this.telefono = telefono;
    }
    //Constructor de la clase cuando no se envía el numero de teléfono
    public Persona(String nombres, String apellidos, int edad, String sexo, String contrasegna) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasegna = contrasegna;
    }
    //Metodos setters, El código y el género no son cambiables...
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    //Metodos getters para mostrar la info del contacto: 
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getContrasegna() {
        return contrasegna;
    }
   public boolean getAdmin(){
        return admin;
   }
    
    
    
}
