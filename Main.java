import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;

class Main {
    
    public static void main(String args[]) throws IOException{
        ClienteMenor juan = new ClienteMenor();

        juan.setId(1);
        juan.setNombre("Juan");
        juan.setApellido("García");
        juan.setGenero("Masculino");
        juan.setFechaNacimiento("23/11/1999");
        juan.setEstadocivil("Soltero");

        ClienteMenor pedro = new ClienteMenor();
        pedro.setId(2);
        pedro.setNombre("pedro");
        pedro.setApellido("García");
        pedro.setGenero("Masculino");
        pedro.setFechaNacimiento("23/11/1999");
        pedro.setEstadocivil("Soltero");

        ClienteMayor ana = new ClienteMayor();
        ana.setId(3);
        ana.setNombre("ana");
        ana.setApellido("García");
        ana.setGenero("femenino");
        ana.setFechaNacimiento("23/11/1999");
        ana.setEstadocivil("Soltero");

        TipoItem type = new TipoLegal();
        type.setDescripcion("zapatos");
        type.setIdDescripcion(1);

        TipoItem type1 = new TipoLegal();
        type1.setDescripcion("celular");
        type1.setIdDescripcion(2);

        TipoItem type2 = new TipoLegal();
        type2.setDescripcion("lavadora");
        type2.setIdDescripcion(3);

        Item item1 = new ItemLocal();
        item1.setId(1);
        item1.setDescripcion("nike 3033");
        item1.setValorUnidad(4000.0);
        item1.setTipoItem(type);

        Item item2 = new ItemLocal();
        item2.setId(2);
        item2.setDescripcion("Jordan 3033");
        item2.setValorUnidad(5000.0);
        item2.setTipoItem(type2);

        Item item3 = new ItemLocal();
        item3.setId(3);
        item3.setDescripcion("Rebook 3033");
        item3.setValorUnidad(10000.0);
        item3.setTipoItem(type2);

        ArrayList <Item> itemsFacturas = new ArrayList<>();
        itemsFacturas.add(item1);

        Factura factura1 = new FacturaPagada();
        factura1.setNroFactura(1);
        factura1.setFechaFactura("20/01/2000");
        factura1.setCliente(juan);
        factura1.setTotalFactura(3000.0);
        factura1.setEstado("pagado");
        factura1.setItems(itemsFacturas);

        Factura factura2 = new FacturaPagada();
        factura2.setNroFactura(2);
        factura2.setFechaFactura("20/01/2000");
        factura2.setCliente(pedro);
        factura2.setTotalFactura(3000.0);
        factura2.setEstado("deuda");
        factura2.setItems(itemsFacturas);

        Factura factura3 = new FacturaPagada();
        factura3.setNroFactura(3);
        factura3.setFechaFactura("20/01/2000");
        factura3.setCliente(ana);
        factura3.setTotalFactura(3000.0);
        factura3.setEstado("vencida");
        factura3.setItems(itemsFacturas);

        FactoryProvider provider = new FactoryProvider();
        AbstractFactory factoryFacturas = provider.getFactory("facturaFactory");
        AbstractFactory factoryClientes = provider.getFactory("clienteFactory");
        AbstractFactory factoryItems = provider.getFactory("itemFactory");
        AbstractFactory factoryTypeItems = provider.getFactory("tipoFactory");

        FacturaDaoImpl facturaDao = new FacturaDaoImpl();
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        ItemDaoImpl itemDao = new ItemDaoImpl();
        TipoItemDaoImpl tipoItemDao = new TipoItemDaoImpl();

        clienteDao.addCliente(juan);
        clienteDao.addCliente(pedro);
        clienteDao.addCliente(ana);
        
        itemDao.addItem(item1);
        itemDao.addItem(item2);
        itemDao.addItem(item3);

        tipoItemDao.addTipoItem(type);
        tipoItemDao.addTipoItem(type1);
        tipoItemDao.addTipoItem(type2);

        facturaDao.addFactura(factura1);
        facturaDao.addFactura(factura2);
        facturaDao.addFactura(factura3);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nBienvenido a la tienda, eres el administrador? (y/n) \n");
        String res = br.readLine();
        while(true){
            if(res.equals("y")){
                break;
            }
            System.out.println("\nSi, usted si es, no me mienta. Escriba: y\n");
            res = br.readLine();
        }

        
        System.out.println("\nHola Administrador, que deseas hacer? (c/r/u/d/exit)\n");

        while(true){

            System.out.println("-> Crear una factura nueva. (c)");
            System.out.println("-> Ver historial de facturas. (r)");
            System.out.println("-> Actualizar una factura. (u)");
            System.out.println("-> Borrar una factura. (d)");
            System.out.println("-> Desea salir. (exit)\n");

            String resA = br.readLine();

            if(resA.equals("c")){

                System.out.print("\nHa seleccionado crear factura nueva. ");
                Factura newFactura;
                System.out.println("Que tipo de factura desea crear, factura Vencida o Pagada? (v/p)\n");

                String tipoFactura = br.readLine();

                while(true){
                    if( tipoFactura.equals("v") || tipoFactura.equals("p") ){
                        break;
                    }
                    System.out.println("\n Has ingresado una respuesta incorrecta, intentalo nuevamente. \n");
                    tipoFactura = br.readLine();
                }

                if(tipoFactura.equals("v")){

                    newFactura = factoryFacturas.getFactura("facturaVencida");

                }else{

                    newFactura = factoryFacturas.getFactura("facturaPagada");

                }

                Random  rnd = new Random();
                int nroFactura = (int) (rnd.nextDouble() * 100 + 20);

                System.out.println("\ningrese la fecha de la factura (dia/mes/anio):\n");
                String fecha = br.readLine();

                System.out.println("\ningrese el total (dolares):\n");
                Double total = Double.parseDouble( br.readLine() );

                System.out.println("\ningrese el estado ():\n");
                String estado = br.readLine();
                
                System.out.println("\nAhora, su cliente. el es de tipo Mayor o Menor? (m/n)\n");
                Cliente cliente;

                String tipoCliente = br.readLine();

                if(tipoCliente.equals("m") ){
                    cliente = factoryClientes.getCliente("clienteMayor");
                }else{
                    cliente = factoryClientes.getCliente("clienteMenor");
                }

                System.out.println("Ahora, empecemos a agregar los items que su cliente ha comprado:");
                ArrayList <Item> itemsComprados = new ArrayList<>();

                while(true){
                    System.out.println("A continuación, se mostrarán los items en venta:\n");
                    itemDao.printItem();

                    System.out.println("\nEscriba el id del item que desea incluir en la factura\n");
                    int idItem = Integer.parseInt( br.readLine() );
                
                    for(Item item: itemDao.getItems()){
                        if( idItem == item.getId() ){
                            itemsComprados.add(item);
                        }
                    }

                    System.out.println("\nDesea agregar otro item? (y/n)\n");
                    String respNewItem = br.readLine();

                    if(respNewItem.equals("y")){

                    }else{
                        break;
                    }

                }

                newFactura.setNroFactura(nroFactura);
                newFactura.setFechaFactura(fecha);
                newFactura.setCliente(cliente);
                newFactura.setTotalFactura(total);
                newFactura.setEstado(estado);
                newFactura.setItems(itemsComprados);

                facturaDao.addFactura(newFactura);

                System.out.println("\nFactura agregada exitosamente.\n");

            }else if(resA.equals("r")){

                System.out.println("\nImprimiendo facturas...");
                System.out.println();

                facturaDao.printFacturas();

            }else if(resA.equals("u")){
                facturaDao.printFacturas();
                System.out.println("Perfecto empecemos, ingresa el Nro de la factura a editar:\n");

                int nroFactura = Integer.parseInt( br.readLine() );

                Factura newFactura = factoryFacturas.getFactura("facturaVencida");
                
                for(Factura factura: facturaDao.getFacturas()){
                    if( factura.getNroFactura() == nroFactura ){
                        newFactura = factura; 
                    }
                }

                System.out.println("Que aspecto de la factura deseas cambiar?");
                System.out.println("-> Fecha de la factura? (f)");
                System.out.println("-> Total factura? (t)");
                System.out.println("-> Estado de la factura? (e)");

                String aspecto = br.readLine();

                if( aspecto.equals("f") ){
                    
                    System.out.println("\ningrese la nueva fecha:\n");
                    
                    String newFecha = br.readLine();
                    newFactura.setFechaFactura(newFecha);

                    System.out.println("\nFecha modificada exitosamente.\n");

                }else if( aspecto.equals("t") ){

                    System.out.println("\ningrese el nuevo total:\n");
                    
                    Double newTotal = Double.parseDouble( br.readLine() );
                    newFactura.setTotalFactura(newTotal);

                    System.out.println("\nTotal modificado exitosamente.\n");

                }else if( aspecto.equals("e") ){
                    System.out.println("\ningrese el nuevo estado:\n");
                    
                    String newEstado = br.readLine();
                    newFactura.setEstado(newEstado);

                    System.out.println("\nEstado modificado exitosamente.\n");
                }else{
                    System.out.println("\nNo se realizará ningún cambio.\n");
                }

                facturaDao.updateFactura(nroFactura, newFactura);

            }else if(resA.equals("d")){

                facturaDao.printFacturas();
                System.out.println();

                System.out.println("Por favor ingresa el nro de factura que deseas eliminar.\n");

                int nroFactura = Integer.parseInt( br.readLine() );
                facturaDao.delFactura(nroFactura);

                System.out.println("\nFactura eliminada exitosamente.\n");

            }else if(resA.equals("exit")){
                System.out.println("\nCerrando sistema...\n");
                break;
            }
        
        }

    }
}
