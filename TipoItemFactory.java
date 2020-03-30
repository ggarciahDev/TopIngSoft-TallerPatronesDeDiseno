class TipoItemFactory extends AbstractFactory {
    
    @Override
    public TipoItem getTypeItem(String typeItem ){
        if(typeItem.equalsIgnoreCase("tipoLegal")){
            return new TipoLegal();
        }else if (typeItem.equalsIgnoreCase("tipoIlegal")){
            return new TipoIlegal();
        }

        System.out.println("No se encuentra el objeto a fabricar");
        return null;
    }
}