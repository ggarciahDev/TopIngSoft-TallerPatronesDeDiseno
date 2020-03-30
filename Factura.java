import java.util.ArrayList;
public abstract class Factura {

    private int nroFactura;
    private String fechaFactura;
    private Cliente cliente;
    private double totalFactura;
    private String estado;
    private ArrayList <Item> items;


    
    public Factura( int nroFactura, String fechaFactura,
        Cliente cliente, double totalFactura,
        String estado, ArrayList <Item> items){

            this.nroFactura = nroFactura;
            this.fechaFactura = fechaFactura;
            this.cliente = cliente;
            this.totalFactura = totalFactura;
            this.estado = estado;
            this.items =  items;

    }

    public Factura(){
        
    }

    public int getNroFactura(){
        return nroFactura;
    }

    public void setNroFactura(int nroFactura){
        this.nroFactura = nroFactura;
    }

    public String getFechaFactura(){
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura){
        this.fechaFactura = fechaFactura;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente( Cliente cliente){
        this.cliente = cliente;
    }

    public double getTotalFactura(){
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura){
        this.totalFactura = totalFactura;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public ArrayList <Item>  getItems(){
        return items;
    }

    public void setItems(ArrayList <Item>  items){
        this.items = items;
    }

    public void validarEstado(){
        System.out.println("revise el estado de su factura");
    }

    public String printItems(){
        String str ="";
        for(Item item: items){
            str = str + item.printInfo();
        }

        return str;
    }

   

    public String printInfo(){
        return "Nro Factura: " + getNroFactura() + " Fecha factura: " + getFechaFactura() +
         " Total factura: "+ Double.toString(getTotalFactura())  + " Estado: " +  getEstado()+  
         " Cliente: " + getCliente().printInfo() + " Items: " + printItems();
    }

}