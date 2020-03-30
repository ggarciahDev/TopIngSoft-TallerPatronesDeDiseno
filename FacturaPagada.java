class FacturaPagada extends Factura {
    
    @Override
    public void validarEstado(){
        System.out.println("Su factura está al día");
    }
}