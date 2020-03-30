public class ClienteFactory  extends AbstractFactory {
    @Override
    public Cliente getCliente(String clienteType){
        if(clienteType.equalsIgnoreCase("clienteMenor")){
            return new ClienteMenor();
        }else if (clienteType.equalsIgnoreCase("clienteMayor")){
            return new ClienteMayor();
        }

        System.out.println("No se encuentra el objeto a fabricar");
        return null;
    }

    
}