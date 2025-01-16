package com.iessanalberto.JTT;

import static com.iessanalberto.JTT.TraductorMorse.TEXTO_A_TRADUCIR;

public class Productor implements Runnable {

    Buzon a_Buzon = null;


    public Productor(Buzon p_Buzon) {
        a_Buzon = p_Buzon;
    }

    @Override
    public void run() {
        String[] l_words = TEXTO_A_TRADUCIR.toUpperCase().split(" ");

        try {
            a_Buzon.a_SemaforoProductor.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < l_words.length - 1; i++) {

            a_Buzon.set_Productor(l_words[i]);

        }
            a_Buzon.a_SemaforoConsumidor.release();



    }
}
