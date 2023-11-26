package org.example.Log;

import javafx.scene.text.Text;

public class Log {
    private static Log log;

    private Text fuente;
    private Log(){
    }

    public static Log getLog(){
        if (log == null){
            log = new Log();
            return log;
        }
        return log;
    }

    public void setFuente(Text t){
        fuente = t;
    }

    public void log(String mensaje) {
        if(fuente == null){
            System.out.println(mensaje);
        } else {
            fuente.setText(mensaje);
        }
    }
}
