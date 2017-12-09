package br.edu.ifpi.capar.teste.pubnub;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;
import java.util.Arrays;

/**
 *
 * @author Denylson Melo
 */
public class Subscrevendo {

    public static void main(String[] args) {
        PubNub pubnub = new PubNub(Configurador.getPNConfiguration());

        pubnub.addListener(new SubscribeCallback() {
            @Override
            public void message(PubNub pubnub, PNMessageResult message) {
                System.out.println(message);
            }

            @Override
            public void status(PubNub pubnub, PNStatus pns) {
                System.out.println(" status >>> " + pns.getOrigin() + ", " + pns.getCategory());
            }

            @Override
            public void presence(PubNub pubnub, PNPresenceEventResult pnper) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        pubnub.subscribe()
                .channels(Arrays.asList(Configurador.getChannel())) // subscribe to channels
                .execute();
    }
}
