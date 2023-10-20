package org.example.Log;

public class Log {
    private static Log log;
    private Log(){
    }

    public static Log getLog(){
        if (log == null){
            log = new Log();
            return log;
        }
        return log;
    }

    public void log(String mensaje){
        System.out.println(mensaje);
    }
}
