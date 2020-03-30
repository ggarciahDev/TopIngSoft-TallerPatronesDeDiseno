import java.text.SimpleDateFormat;  
import java.util.Date;  

public abstract class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String genero;
    private String fechaNacimiento;
    private String estadoCivil;

    

    public Cliente(int id, String nombre,
        String apellido, String genero,
        String fechaNacimiento,String estadoCivil ){

            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.genero = genero;
            this.fechaNacimiento = fechaNacimiento;
            this.estadoCivil = estadoCivil;

    }

    public Cliente(){
        
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getEstadocivil(){
        return estadoCivil;
    }

    public void setEstadocivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }

    public String getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String printInfo(){
        return "Id: "+getId()+ " Nombre: "+getNombre()+ " Apellido: " +getApellido() +
        " Genero: " + getGenero() +  " Fecha nacimiento: " +  getFechaNacimiento() + " Estado civil: " + getEstadocivil();
    }

    //metodo de prueba
    public void probar(){
    
    }

    public void saludar(){
        System.out.println("Hola soy un cliente");
    }
}