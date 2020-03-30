public abstract class Item {
    private TipoItem tipoItem;
    private int id;
    private String descripcion;
    private double valorUnidad;

    
    public Item(TipoItem tipoItem, int id,
         double valorUnidad){

        this.tipoItem = tipoItem;
        this.id = id;
        this.valorUnidad = valorUnidad;

    }

    public Item(){
        
    }

    public TipoItem getTipoItem(){
        return tipoItem;
    }

    public void setTipoItem( TipoItem tipoItem){
        this.tipoItem = tipoItem;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getValorUnidad(){
        return valorUnidad;
    }

    public void setValorUnidad(double valorUnidad){
        this.valorUnidad = valorUnidad;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void consultarEstado(){
        System.out.println("revisar disponibilidad");
    }

    public String printInfo(){
        return "Id: " + getId() + " Descripcion: " + getDescripcion() + " Valor unidad: " + getValorUnidad() +
         " Tipo Items: " + getTipoItem().printInfo();
    }
}