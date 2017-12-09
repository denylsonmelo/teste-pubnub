package br.edu.ifpi.capar.teste.pubnub;

import com.pubnub.api.PNConfiguration;

/**
 *
 * @author Denylson Melo
 */
public abstract class Configurador {
    
    public static PNConfiguration getPNConfiguration(){
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setSubscribeKey("SUBSCRIBE-KEY");
        pnConfiguration.setPublishKey("PUBLISH-KEY");
        return pnConfiguration;
    }
    
    public static String getChannel(){// qualquer nome de canal que queira
        return "meu_canal_de_teste";  // nao tem haver com as chaves no site
    }
}
