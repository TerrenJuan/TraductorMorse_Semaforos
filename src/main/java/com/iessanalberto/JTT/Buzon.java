package com.iessanalberto.JTT;

import java.util.concurrent.Semaphore;

 /***************************************************************************************
 *  CLASE: "Buzon"
 ***************************************************************************************
 *  @author  Juan Terrén
 *
 *  @version 1.1 - Versión corregida
 *
 *  @since 23/01/2025
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
    public int a_Max_Palabras = 0;

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

    // Metodo que adquiere el semaforo del productor
    public void adquirirSemaforoProductor(){
        try {
            a_SemaforoProductor.acquire(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    } // adquirirSemaforoProductor()

     // Metodo que adquiere el semaforo del consumidor
     public void adquirirSemaforoConsumidor(){
        try {
            a_SemaforoConsumidor.acquire(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }// adquirirSemaforoConsumidor()

     // Metodo que libera el token para el semaforo del consumidor
    public void soltarSemaforoProductor(){
        a_SemaforoProductor.release(1);

    }// soltarSemaforoProductor()

     // Metodo que libera el token para el semaforo del productor
    public void soltarSemaforoConsumidor(){
        a_SemaforoConsumidor.release(1);

    }// soltarSemaforoConsumidor()

} // Buzon
