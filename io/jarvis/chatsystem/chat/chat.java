package io.jarvis.chatsystem.chat;

import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import io.jarvis.chatsystem.bot.jarvis;

// *------------[Jarvis]------------
// * by ZentornoLP and dici
// * TODO:
// * #

public class chat {

	
	public static void start(){
	jarvis.api.registerEvent(TS3EventType.TEXT_PRIVATE, 0);
	jarvis.api.addTS3Listeners(new TS3EventAdapter() {

		@Override
		public void onTextMessage(TextMessageEvent e){
			
			//Hier steht halt nix
			
		}
		
	});
	
	}

}


