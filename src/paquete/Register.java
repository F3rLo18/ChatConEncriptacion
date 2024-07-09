package paquete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Register extends JFrame{
private static String fuente="Congenial Black";
private JPanel panel;
    public Register(){
        iniciarComponentes();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
//Metodo que iniciará los componentes del panel 
    private void iniciarComponentes(){
        iniciarVentana();
        iniciarPanel();
        iniciarEtiquetas();
        iniciarCajasTexto();
    }
//Método para inciailizar la ventana
    private void iniciarVentana(){
    this.setSize(600,600);
    this.setTitle("Register");
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    }
//Método para iniciar el panel
    private void iniciarPanel(){
    panel= new JPanel();
    panel.setBackground(new Color(15, 188, 223));
    panel.setLayout(null);
    this.getContentPane().add(panel);
}
//Método para inciar las etiquetas :
    private void iniciarEtiquetas(){
        JLabel etiquetaNombre= new JLabel("Nombres ",SwingConstants.RIGHT);
        etiquetaNombre.setBounds(90,30,120,45);
        etiquetaNombre.setFont(new Font(fuente,0, 25));
        

        JLabel etiquetaApellidos= new JLabel("Apellidos ",SwingConstants.RIGHT);
        etiquetaApellidos.setBounds(90,80,120,45);
        etiquetaApellidos.setFont(new Font(fuente,0, 25));
        
        
        JLabel etiquetaContrasegna= new JLabel("Contraseña ",SwingConstants.RIGHT);
        etiquetaContrasegna.setBounds(70,130,140,45);
        etiquetaContrasegna.setFont(new Font(fuente,0, 25));
        
        
        JLabel etiquetaGenero= new JLabel("Genero ",SwingConstants.RIGHT);
        etiquetaGenero.setBounds(90,180,120,45);
        etiquetaGenero.setFont(new Font(fuente,0, 25));
        

        JLabel etiquetaEdad= new JLabel("Edad ",SwingConstants.RIGHT);
        etiquetaEdad.setBounds(90,230,120,45);
        etiquetaEdad.setFont(new Font(fuente,0, 25));
        
        
        JLabel etiquetaNumero= new JLabel("Telefono ",SwingConstants.RIGHT);
        etiquetaNumero.setBounds(90,280,120,45);
        etiquetaNumero.setFont(new Font(fuente,0, 25));

        JLabel etiquetaLogin = new JLabel("Ir a inicio de sesion",SwingConstants.RIGHT);
        etiquetaLogin.setBounds(90,350,130,45);
        etiquetaLogin.setFont(new Font(fuente,0, 15));

        listenerIrLogin(etiquetaLogin);

        panel.add(etiquetaNombre);
        panel.add(etiquetaApellidos);
        panel.add(etiquetaContrasegna);
        panel.add(etiquetaGenero);
        panel.add(etiquetaEdad);
        panel.add(etiquetaNumero);
        panel.add(etiquetaLogin);
    }

    //Metodo para iniciar las cajas de texto y botones 
    @SuppressWarnings("unchecked")
    private void iniciarCajasTexto(){
        JTextField cajaNombre= new JTextField();
        cajaNombre.setBounds(230,30,300,45);
        cajaNombre.setFont(new Font(fuente,0, 25));

        JTextField cajaApellidos= new JTextField();
        cajaApellidos.setBounds(230,80,300,45);
        cajaApellidos.setFont(new Font(fuente,0, 25));

        

        JPasswordField cajaContrasegna= new JPasswordField();
        cajaContrasegna.setBounds(230,130,300,45);
        cajaContrasegna.setFont(new Font(fuente,0, 25));
        
        
        @SuppressWarnings("rawtypes")
        JComboBox cajaGenero= new JComboBox();
        cajaGenero.addItem("Hombre");
        cajaGenero.addItem("Mujer");

        
        cajaGenero.setBounds(230,180,300,45);
        cajaGenero.setFont(new Font(fuente,0, 25));

        JTextField cajaEdad= new JTextField();
        cajaEdad.setBounds(230,230,300,45);
        cajaEdad.setFont(new Font(fuente,0, 25));

        JTextField cajaTelefono= new JTextField();
        cajaTelefono.setBounds(230,280,300,45);
        cajaTelefono.setFont(new Font(fuente,0, 25));


        panel.add(cajaNombre);
        panel.add(cajaApellidos);
        panel.add(cajaContrasegna);
        panel.add(cajaGenero);
        panel.add(cajaEdad);
        panel.add(cajaTelefono);

        JButton botonRegistro = new JButton();
        botonRegistro.setText("Registrarse");
        botonRegistro.setBounds(380,350,150,50);
        listenerBotonRegistro(botonRegistro,cajaNombre,cajaApellidos,cajaContrasegna,cajaEdad,cajaGenero,cajaTelefono);
        panel.add(botonRegistro);
    }
    
    //Metodo para la accion del boton: 
    private void listenerBotonRegistro(JButton boton,JTextField cajaNombre,JTextField cajaApellidos, JPasswordField cajaContrasegna, JTextField cajaEdad, JComboBox cajaGenero, JTextField cajaTelefono){
        
        ActionListener oyenteBoton = new ActionListener() {
           int codigo; 
           
            @Override
            public void actionPerformed(ActionEvent e) {
            int edad;
            String sexo;
            //Obteniendo la contraseña en el JPaswwordField
            char []contra= cajaContrasegna.getPassword();
            String contrasegna= new String(contra);
            //Si alguna de las cajas está vacía: 
            if(cajaNombre.getText().equals("") || cajaApellidos.getText().equals("") || contrasegna.equals("") || cajaEdad.getText().equals("") ){
                JOptionPane.showMessageDialog(null,"Porfavor llene los campos");
                cajaNombre.setBackground(new Color(200, 63, 63));
                cajaApellidos.setBackground(new Color(200, 63, 63));
                cajaContrasegna.setBackground(new Color(200, 63, 63));
                cajaEdad.setBackground(new Color(200, 63, 63));
            }
            else{ //Si las cajas están llenas entonces: 
            if(cajaEdad.getText().matches("\\d*")){
                edad= Integer.parseInt(cajaEdad.getText());
                if(cajaGenero.getSelectedIndex()==0){sexo="Hombre";}else{sexo="Mujer";}
                //Si el campo del teléfono está vacío llamamos al constructor SIN el numero de telefono 
                if(cajaTelefono.getText().equals("")){
                    Persona nuevoUsuario= new Persona(cajaNombre.getText(), cajaApellidos.getText(),  edad,sexo, contrasegna);
                    nuevoUsuario.setAdmin(false);
                    codigo = ListaUsuarios.getCodigo();
                    ListaUsuarios.agregarusuario(nuevoUsuario,codigo);
                    JOptionPane.showMessageDialog(null,"Su codigo de inicio de sesion es: "+ ListaUsuarios.getCodigo());
                    codigo++;   
                    ListaUsuarios.setCodigo(String.valueOf(codigo));
                    Main.abrirLogin();
                    dispose();
                }else{ //SI la caja de telefono contiene algo
                    if(cajaTelefono.getText().matches("\\d*")){
                    Persona nuevoUsuario= new Persona(cajaNombre.getText(), cajaApellidos.getText(),  edad,sexo, contrasegna,cajaTelefono.getText());
                    nuevoUsuario.setAdmin(false);
                    codigo = ListaUsuarios.getCodigo();
                    ListaUsuarios.agregarusuario(nuevoUsuario,codigo);
                    JOptionPane.showMessageDialog(null,"Su codigo de inicio de sesion es: "+ ListaUsuarios.getCodigo());
                    codigo++;   
                    ListaUsuarios.setCodigo(String.valueOf(codigo));
                    Main.abrirLogin();
                    dispose();
                        
                    
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"El campo de telefono no puede contener letras...");
                    }
                   
                }
            }else{
                JOptionPane.showMessageDialog(null,"La edad no puede contener letras...");
            }

            }
            }
        };
        boton.addActionListener(oyenteBoton);


    }
    //Metodo para el listener de ir a inicio de sesion
    private void listenerIrLogin(JLabel irLogin){
    MouseListener oyenteRaton = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            Main.abrirLogin();
            dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
        irLogin.setForeground(Color.blue);    
        }

        @Override
        public void mouseExited(MouseEvent e) {
        irLogin.setForeground(Color.black);
        }
        



    };
    
        irLogin.addMouseListener(oyenteRaton);


    }


}
