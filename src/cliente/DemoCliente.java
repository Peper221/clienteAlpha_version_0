 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author JOSEMARIO
 */
public class DemoCliente {
    public static void main(String [] args){
        
        try {
            Socket socket  =  new Socket("localhost",8080);
     
            ParaRecibir paraRecibir = new ParaRecibir(socket);
            Thread hiloRecibir = new Thread (paraRecibir);
            hiloRecibir.start();

            ParaEnviar paraEnviar = new ParaEnviar(socket);
            Thread hiloEnviar = new Thread (paraEnviar);
            hiloEnviar.start();
        } catch (Exception e) {
            System.out.println("Error en la comunicacion");
            System.exit(1);
        }
    
    
     
     
    }
}
