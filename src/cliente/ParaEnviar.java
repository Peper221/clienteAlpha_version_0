/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;


import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSEMARIO
 */
class ParaEnviar implements Runnable{
    
    
    final DataOutputStream salida;
    Scanner teclado;
 
    public ParaEnviar(Socket socket) throws IOException{
        teclado = new Scanner (System.in);
        salida = new DataOutputStream(socket.getOutputStream());
        
    }

    @Override
    public void run() {
        
        System.out.println("ingrese un nombre de usuario");
        String me = teclado.nextLine();
        try {
            salida.writeUTF(me);
        } catch (IOException ex) {
            System.out.println("Error al ingresar usuario");
            System.exit(1);
        }
 
       while(true){
          
           String mensaje = teclado.nextLine();
 
                try {
                   salida.writeUTF(mensaje);
               } catch (Exception e) {
                    System.out.println("Error al mandar el mensaje");
                    System.exit(1);
               }
            
           
           }
 
    }
    
    
    
}
