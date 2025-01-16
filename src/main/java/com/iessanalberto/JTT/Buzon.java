package com.iessanalberto.JTT;

import java.util.concurrent.Semaphore;

 /***************************************************************************************
 *  CLASE: "Buzon"
 ***************************************************************************************
 *  @author  Juan Terrén
 *
 *  @version 1.0 - Versión inicial
 *
 *  @since 16/01/2025
 *
 ***************************************************************************************
 *  COMENTARIOS:
 *
 *      - Implementa los roles de las clases productor y consumidor.
 ***************************************************************************************/
public class Buzon {

    private String a_Productor = null;
    private int a_Consumidor = 0;

    public int a_Contador = 0;
    public int a_max_palabras = 0;

    // Creamos los 'semaphores', e iniciamos el del productor a 1 para que sea el primero en entrar a realizar la tarea
    public final Semaphore a_SemaforoProductor = new Semaphore(1);
    public final Semaphore a_SemaforoConsumidor = new Semaphore(0);


    // Getters y Setters del productor y consumidor

    public String get_Productor(){
        return a_Productor;
    }

    public void set_Productor(String p_Productor){
        a_Productor = p_Productor;
    }

    public int get_Consumidor(){
        return a_Consumidor;
    }

    public void set_Consumidor(int p_Consumidor){
        a_Consumidor = p_Consumidor;

    }

} // Buzon
