package com.iessanalberto.JTT;

import java.util.concurrent.Semaphore;
;

public class Buzon {


    private String a_Productor = null;
    private String a_Consumidor = null;

    public final Semaphore a_SemaforoProductor = new Semaphore(1);
    public final Semaphore a_SemaforoConsumidor = new Semaphore(0);


    public String get_Productor(){
        return a_Productor;
    }

    public void set_Productor(String p_Productor){
        a_Productor = p_Productor;
    }

    public String get_Consumidor(){
        return a_Consumidor;
    }

    public void set_Consumidor(String p_Consumidor){
        a_Consumidor = p_Consumidor;

    }


}
