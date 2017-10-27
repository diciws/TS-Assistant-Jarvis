package io.jarvis.chatsystem.chat;

import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import io.jarvis.chatsystem.ai.api.AIConfiguration;
import io.jarvis.chatsystem.ai.api.AIDataService;
import io.jarvis.chatsystem.ai.api.model.AIRequest;
import io.jarvis.chatsystem.ai.api.model.AIResponse;
import io.jarvis.chatsystem.bot.jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *------------[Jarvis]------------
// * by ZentornoLP and dici
// * TODO:
// * #

public class chat {


    public static void start() {
        jarvis.api.registerEvent(TS3EventType.TEXT_PRIVATE, 0);
        jarvis.api.addTS3Listeners(new TS3EventAdapter() {

            @Override
            public void onTextMessage(TextMessageEvent e) {

                AIConfiguration configuration = new AIConfiguration("e45a85a037fe4724996970ccf668e827");

                AIDataService dataService = new AIDataService(configuration);

                String line;

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (null != (line = reader.readLine())) {

                        try {
                            AIRequest request = new AIRequest(line);

                            AIResponse response = dataService.request(request);

                            if (response.getStatus().getCode() == 200) {
                                System.out.println(response.getResult().getFulfillment().getSpeech());
                            } else {
                                System.err.println(response.getStatus().getErrorDetails());
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("See ya!");

            }

        });

    }

}