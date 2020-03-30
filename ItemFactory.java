class ItemFactory extends AbstractFactory{
    
    @Override
    public Item getItem(String itemType){
        if(itemType.equalsIgnoreCase("itemStock")){
            return new ItemStock();
        }else if (itemType.equalsIgnoreCase("itemLocal")){
            return new ItemLocal();
        }

        System.out.println("No se encuentra el objeto a fabricar");
        return null;
    }
}