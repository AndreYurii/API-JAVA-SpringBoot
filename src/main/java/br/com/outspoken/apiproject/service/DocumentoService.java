package br.com.outspoken.apiproject.service;

import br.com.outspoken.apiproject.model.Documento;
import java.time.LocalDate;


public class TesteService {



    public boolean validarDataDocumentoFutura(LocalDate dataAtual) {
        LocalDate agora =  LocalDate.now();

        if (agora.isAfter(dataAtual)){
            return true;
        }else {
            return false;
        }
    }

    public void getNomeUpperCase(){


    }

}
