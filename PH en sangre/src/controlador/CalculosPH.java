package controlador;

import javax.swing.JTextArea;

public class CalculosPH {

    public static String calculaPH(double pH) {
        String tipoSangre = "Error";
        if (pH >= 0) {
            if (pH < 7) {
                tipoSangre = "Basico";
            } else if (pH == 7) {
                tipoSangre = "Neutro";
            } else if (pH <= 14) {
                tipoSangre = "Acido";
            }
        }

        return tipoSangre;
    }
    
    public static void mostrarResultados(double pH, JTextArea consecuencias, JTextArea recomendaciones) {
        if (pH >= 0) {
            if (pH < 7.35) {
               
                consecuencias.append("\n-  Deterioro en la función de los órganos");
                consecuencias.append("\n- Fallas respiratorias");
                consecuencias.append("\n- Conmoción");
                consecuencias.append("\n- Artritis");
                consecuencias.append("\n- Mareos y vértigos");                              
                
               recomendaciones.append("\n- Consumir alimentos semicrudos");
               recomendaciones.append("\n- Evitar estres y situaciones emocionales tensas");
               recomendaciones.append("\n- Realizar actividad física");
               recomendaciones.append("\n- Consumir algas ricas en clorofila");
               
               
            } else if (pH>= 7.35 && pH<=7.42) {
                consecuencias.append("\n- PH dentro del rango de lo normal");
               recomendaciones.append("\n- Toma abundante agua.");
               
            } else if (pH <= 14) {
                consecuencias.append("\n- Arritmia");
                consecuencias.append("\n- Hipopotasemia");
                consecuencias.append("\n- Coma");
                consecuencias.append("\n- Convulsiones");
                
               recomendaciones.append("\n- Consumir cereales");
               recomendaciones.append("\n- Abundante frutos secos y semillas");
               recomendaciones.append("\n- Consumir legumbres y verduras");
               recomendaciones.append("\n- Consumir minerales, potasio, magnesio, sodio y calcio");
              
            }
        }
    }
}
