/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
 

/**
 *
 * @author JOSEMARIO
 */
class ParaRecibir implements Runnable{
    
    final DataInputStream entrada;
     final DataOutputStream salida;
     
     static String remitente;
 
      
     
    public ParaRecibir(Socket socket) throws IOException{
        entrada = new DataInputStream(socket.getInputStream());
        salida = new DataOutputStream(socket.getOutputStream());
    
    }
  
    @Override
    public void run() {
        
        String mensaje;
        
        try {
            mensaje = entrada.readUTF();
            if (mensaje.equals("El nombre ya esta ocupado")) {
                    System.out.println(mensaje);
                    System.exit(1);
                }else{
                System.out.println(mensaje);
                }
        } catch (IOException ex) {
            System.out.println("error en ingresar nombre");
        }
        
        
        while(true){
            try {
            mensaje = entrada.readUTF();
 
                System.out.println(mensaje);
           
   
            } catch (Exception e) {
                System.out.println("Error en la recepción de mensaje");
                System.exit(1);
            }
        
           
        }
     }
        
    }

