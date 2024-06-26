package Controlador;

import Vista.*;

public class Controlador_main {
    Vista_main vista_main = new Vista_main();

     public void Control_padre() {
         boolean iterador = true;
         while (iterador){
             int opciones = vista_main.menu();
             switch (opciones){
                 case 1:
                     Vista_Inventario v = new Vista_Inventario();
                     v.Conectar();
                     break;
                 case 2:
                     Vista_clientes vista_clientes = new Vista_clientes();
                     vista_clientes.conectar();
                     break;
                 case 3:
                     Vista_Pedidos ve = new Vista_Pedidos();
                     ve.Conectar();
                     break;
                 case 4:
                     Vista_kardex vu = new Vista_kardex();
                     vu.conectar();
                     break;
                 case 5:
                     iterador = false;
                     break;
             }
         }
    }

}
