class FactoryProvider {
    public  AbstractFactory getFactory(String factoryType){


        if(factoryType.equalsIgnoreCase("clienteFactory")){
            return new ClienteFactory();

        }else if (factoryType.equalsIgnoreCase("facturaFactory")){
            return new FacturaFactory();

        }else if(factoryType.equalsIgnoreCase("itemFactory")){
            return new ItemFactory();

        }else if(factoryType.equalsIgnoreCase("tipoFactory")){
            return new TipoItemFactory();
        }
        

        System.out.println("No se encuentra el objeto a fabricar");
        return null;


    }
}