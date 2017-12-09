package br.edu.ifpi.capar.teste.pubnub;

import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Denylson Melo
 */
public class Publicando {

    private static final List<String> PAISES = Arrays.asList("Brazil", "Mongolia", "East Timor", "Jordan",
            "Sudan", "USA", "Sierra Leone", "Hungary", "Kazakhstan", "Barbados", "New Zealand", "Canada");

    private static final List<String> DRINKS = Arrays.asList("Rose Kisses", "Milk Thunder", "Fantasy Slingshot",
            "Honey Vengeance", "Oak Sip", "Nimble Bubble", "Perfect Rush", "Coriander Blizzard", "Almond Murder", "Tropical Drop");

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        PubNub pubnub = new PubNub(Configurador.getPNConfiguration());

        for (int i = 0; i < 30; i++) {
            Thread.sleep(3000);
            publicarNosCanais(pubnub, Configurador.getChannel(), getMensagem());
        }

    }

    private static void publicarNosCanais(PubNub pubnub, String channel, Object message) {

        System.out.print(message + " ---> ");

        pubnub.publish()
                .channel(channel)
                .message(message)
                .async(new PNCallback<PNPublishResult>() {
                    @Override
                    public void onResponse(PNPublishResult result, PNStatus status) {
                        if (status.isError()) {
                            System.out.println(status);
                        } else {
                            System.out.println("Published!");
                        }
                    }
                });
    }

    private static Map getMensagem() {
        Map message = new HashMap();
        message.put(sortear(PAISES), sortear(DRINKS));
        return message;
    }

    private static String sortear(List<String> list) {
        int index = RANDOM.nextInt(list.size());
        return list.get(index);
    }
}
