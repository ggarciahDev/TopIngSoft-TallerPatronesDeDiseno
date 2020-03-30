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

        System.out.println("Bienvenido a la tienda, eres el administrador? y/n");
        String res = br.readLine();
        while(true){
            if(res.equals("y")){
                break;
            }
            System.out.println("Si, usted si es, no me mienta. Escriba y");
            res = br.readLine();
        }

        
        System.out.println("Hola Administrador, qué deseas hacer?");

        while(true){

            System.out.println("Crear una factura nueva. (c)");
            System.out.println("Ver historial de facturas. (r)");
            System.out.println("Actualizar una factura. (u)");
            System.out.println("Borrar una factura. (d)");
            System.out.println("Desea salir. (exit)");

            String resA = br.readLine();

            if(resA.equals("c")){

                System.out.println("Ha seleccionado crear factura nueva");
                Factura newFactura;
                System.out.println("Qué tipo de factura desea crear, factura Vencida o Pagada? (v/p)");

                String tipoFactura = br.readLine();

                if(tipoFactura.equals("v")){

                    newFactura = factoryFacturas.getFactura("facturaVencida");

                }else{

                    System.out.println("Por defecto, factura Pagada.");
                    newFactura = factoryFacturas.getFactura("facturaPagada");

                }

                Random  rnd = new Random();
                int nroFactura = (int) (rnd.nextDouble() * 100 + 20);

                System.out.println("ingrese la fecha de la factura:");
                String fecha = br.readLine();

                System.out.println("ingrese el total:");
                Double total = Double.parseDouble( br.readLine() );

                System.out.println("ingrese el estado:");
                String estado = br.readLine();
                
                System.out.println("Ahora, su cliente. él es de tipo Mayor o Menor? (m/n)");
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
                    System.out.println("A continuación, se mostrarán los items en venta:");
                    itemDao.printItem();

                    System.out.println("\n Escriba el id del item que desea incluir en la factura");
                    int idItem = Integer.parseInt( br.readLine() );
                
                    for(Item item: itemDao.items){
                        if( idItem == item.getId() ){
                            itemsComprados.add(item);
                        }
                    }

                    System.out.println("Desea agregar otro item? (y/n)");
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

                System.out.println("Factura agregada exitosamente.");

            }else if(resA.equals("r")){

                System.out.println("Imprimiendo facturas...");
                System.out.println();

                //imprimir todas las facturas del daoFacturas
                facturaDao.printFacturas();
                System.out.println();

            }else if(resA.equals("u")){
                facturaDao.printFacturas();
                System.out.println();
                System.out.println("Perfecto empecemos, ingresa el Nro de la factura a editar:");

                int nroFactura = Integer.parseInt( br.readLine() );

                Factura newFactura = factoryFacturas.getFactura("facturaVencida");
                
                for(Factura factura: facturaDao.facturas){
                    if( factura.getNroFactura() == nroFactura ){
                        newFactura = factura; 
                    }
                }

                System.out.println("Qué aspecto de la factura deseas cambiar?");
                System.out.println("fecha de la factura? (f)");
                System.out.println("total factura? (t)");
                System.out.println("estado de la factura? (e)");

                String aspecto = br.readLine();

                if( aspecto.equals("f") ){
                    
                    System.out.println("ingrese la nueva fecha:");
                    
                    String newFecha = br.readLine();
                    newFactura.setFechaFactura(newFecha);

                    System.out.println("Fecha modificada exitosamente.\n");

                }else if( aspecto.equals("t") ){

                    System.out.println("ingrese el nuevo total:");
                    
                    Double newTotal = Double.parseDouble( br.readLine() );
                    newFactura.setTotalFactura(newTotal);

                    System.out.println("Total modificado exitosamente.\n");

                }else if( aspecto.equals("e") ){
                    System.out.println("ingrese el nuevo estado:");
                    
                    String newEstado = br.readLine();
                    newFactura.setEstado(newEstado);

                    System.out.println("Estado modificado exitosamente.\n");
                }else{
                    System.out.println("No se realizará ningún cambio.");
                }

                facturaDao.updateFactura(nroFactura, newFactura);

            }else if(resA.equals("d")){

                facturaDao.printFacturas();
                System.out.println();

                System.out.println("Por favor ingresa el nro de factura que deseas eliminar.");

                int nroFactura = Integer.parseInt( br.readLine() );
                facturaDao.delFactura(nroFactura);

                System.out.println("Factura eliminada exitosamente.\n");

            }else if(resA.equals("exit")){
                System.out.println("Cerrando sistema...");
                break;
            }
        
        }

    }
}
