package io.jarvis.chatsystem.bot;

import java.util.ArrayList;
import java.util.logging.Level;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import io.jarvis.chatsystem.chat.chat;

//*------------[Jarvis]------------
//* by ZentornoLP and dici
//* TODO:
//* #

public class jarvis {

	public static final TS3Config config = new TS3Config();
	public static final TS3Query query = new TS3Query(config);
	public static final TS3Api api = query.getApi();
	public static final ArrayList<String> words = new ArrayList<>();
	
	
	public static void main(String[] args){
		System.out.println("------------------[\033Jarvis0m]------------------");
		System.out.println("Start \033Jarvis0m ...");
		System.out.println("________________________________________");
		System.out.println(" ");
		System.out.println("Version: 32m[v1.0]0m");
		System.out.println("Updates: http://github.com/diciws");
		System.out.println("________________________________________");
		System.out.println(" ");
		System.out.println("Starting Jarvis-System...");
		System.out.println("Connecting to IP...");
		config.setHost("---Ip-Adresse---");//Hier steht die IP
		config.setDebugLevel(Level.ALL);
		query.connect();
		api.selectVirtualServerById(2);
        api.selectVirtualServerByPort(9992);
		api.login("---QueryName---", "---QueryPW---");//Query Name und Passwort
		System.out.println("Connected to Server!");
		api.setNickname("Jarvis");
		System.out.println("Nickname set '\033Jarvis0m'");
		System.out.println("Loading Files...");
		chat.start();
		System.out.println("32mAll Files enabled!\033");
		System.out.println(" ");
		System.out.println("Success, \033[1mSYSTEM\033[0m connected");
		System.out.println("------------------[\033Jarvis0m]------------------");
		
	}
	
}
