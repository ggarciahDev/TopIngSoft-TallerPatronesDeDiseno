class FacturaFactory extends AbstractFactory {
    
    @Override
    public Factura getFactura(String facturaType){
        if(facturaType.equalsIgnoreCase("facturaVencida")){
            return new FacturaVencida();
        }else if (facturaType.equalsIgnoreCase("facturaPagada")){
            return new FacturaPagada();
        }

        System.out.println("No se encuentra el objeto a fabricar");
        return null;
    }
}