public interface TipoItemDao{
    
    void addTipoItem(TipoItem tipoItem);
    void printTipoItem();
    void delTipoItem(int idTipoItem);
    void updateTipoItem(int idTipoItem, TipoItem tipoItem);
}