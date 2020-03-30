public abstract class TipoItem {
    private int idDescripcion;
    private String descripcion;

    
    public TipoItem(int idDescripcion, String descripcion){
        this.idDescripcion = idDescripcion;
        this.descripcion = descripcion;
    }

    public TipoItem(){
        
    }

    

    public void setIdDescripcion (int idDescripcion){
        this.idDescripcion = idDescripcion;
    }

    public int getIdDescription(){
        return idDescripcion;
    }


    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void validarLegaliad(){
        System.out.println("Hola soy un ubjeto de dudosa procedencia ");
    }

    public String printInfo(){
        return "Id: " + getIdDescription() + " Descripcion: " + getDescripcion();
    }
    
}