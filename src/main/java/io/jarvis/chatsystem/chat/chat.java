package io.jarvis.chatsystem.chat;

import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import io.jarvis.chatsystem.ai.api.AIConfiguration;
import io.jarvis.chatsystem.ai.api.AIDataService;
import io.jarvis.chatsystem.ai.api.AIServiceException;
import io.jarvis.chatsystem.ai.api.model.AIRequest;
import io.jarvis.chatsystem.ai.api.model.AIResponse;
import io.jarvis.chatsystem.bot.jarvis;

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

                if (jarvis.api.getClientByUId(e.getInvokerUniqueId()).isServerQueryClient()) {
                    return;
                }

                AIConfiguration configuration = new AIConfiguration("e45a85a037fe4724996970ccf668e827");

                AIDataService dataService = new AIDataService(configuration);

                String line = e.getMessage();

                System.out.println(line);

                AIRequest request = new AIRequest(line);

                try {
                    AIResponse response = dataService.request(request);

                    String message = response.getResult().getFulfillment().getSpeech().replace(";BAN", "");

                    if (response.getStatus().getCode() == 200) {
                        jarvis.api.sendPrivateMessage(e.getInvokerId(), message);
                        jarvis.api.banClient(e.getInvokerId(), 1, message);
                        return;
                    } else {
                        System.err.println(response.getStatus().getErrorDetails());
                        return;
                    }
                } catch (AIServiceException e1) {
                    e1.printStackTrace();
                }

            }

        });
    }

}

