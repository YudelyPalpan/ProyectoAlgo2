
package controlador;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.*;

public class Validar {
    
    public static void longitud(JTextField entrada,int longMax){
        
        entrada.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                if(entrada.getText().length()>=longMax){
                    e.consume();
                }
                
            }
        });
    }
    
    public static boolean carateresInvalidos(JTextField entrada){
        
        boolean valido = true;
        String textoValidar = entrada.getText();
        
        int contArroba = 0,contPunto = 0;
        
        for (int i = 0; i < textoValidar.length(); i++) {
            
            if(textoValidar.charAt(i) == '@'){
                contArroba++;
            }else if(textoValidar.charAt(i) == '.'){
                contPunto++;
            }
            
        }
        
        if(contArroba !=1){
            valido = false;
        }
        if(contPunto == 0){
            valido = false;
        }
        
        return valido;
    }
    
    public static void soloCaracteres (JTextField entrada){
        
        entrada.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                
                String texto = entrada.getText();
                
                 
                if(texto.isEmpty()){
                    entrada.setBackground(Color.white);
                }
                
                for (int i = 0; i < texto.length(); i++) {
                    
                    if( Character.isDigit(texto.charAt(i))){
                        entrada.setBackground(Color.red);

                    }else{
                        entrada.setBackground(Color.white);
                    }
                }
                    
            }
            
        });
    }
    
    public static void soloNumeros (JTextField entrada){
        
        entrada.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyReleased(KeyEvent e){
                
                String texto = entrada.getText();
         
                
                if(texto.isEmpty()){
                    entrada.setBackground(Color.white);
                }
                
                for (int i = 0; i < texto.length(); i++) {
                    
                    if(!Character.isDigit(texto.charAt(i))){
                        
                        entrada.setBackground(Color.red);

                    }else {
                        
                        entrada.setBackground(Color.white);
                    }
                }
                    
            }
            
        });
    }
}
