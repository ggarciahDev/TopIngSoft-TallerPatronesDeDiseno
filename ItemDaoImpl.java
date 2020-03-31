import java.util.ArrayList;
import java.util.List;


public class ItemDaoImpl implements ItemDao {

    //list is working as a database
    private ArrayList<Item> items;

    public ItemDaoImpl() {
        items = new ArrayList<>();
    }

    @Override
    public ArrayList<Item> getItems(){
        return this.items;
    }

    @Override
    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public void printItem(){
        System.out.println("numero de elementos: " + items.size());
        for(Item item: items){
            System.out.println(item.printInfo());
        }
    }

    @Override
    public void delItem(int idItem){
        int index = 0;

        for(Item item: items){

            if( item.getId() == idItem ){
                break;
            }

            index++;
        }
        items.remove(index);
    }

    @Override
    public void updateItem(int idItem, Item newItem){
        int index = 0;

        for(Item item: items){

            if( item.getId() == idItem){
                items.set(index, newItem);
            }

            index++;
        }
    }
}