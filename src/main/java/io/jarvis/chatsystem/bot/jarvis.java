package io.jarvis.chatsystem.bot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import io.jarvis.chatsystem.chat.chat;

import java.util.ArrayList;
import java.util.logging.Level;

//*------------[Jarvis]------------
//* by ZentornoLP and dici
//* TODO:
//* #

public class jarvis {

    public static final TS3Config config = new TS3Config();
    public static final TS3Query query = new TS3Query(config);
    public static final TS3Api api = query.getApi();
    public static final ArrayList<String> words = new ArrayList<String>();


    public static void main(String[] args) {
        System.out.println("-----------------------------[\033[35mJarvis\033[0m]-----------------------------");
		System.out.println("\033[35mJarvis\033[0m: \033[32mStarting\033[0m . . .");
        System.out.println("________________________________________");
        System.out.println(" ");
 		System.out.println("Version: \033[35mv1.0\033[0m");
        System.out.println("Updates: http://github.com/diciws");
        System.out.println("________________________________________");
        System.out.println(" ");
        System.out.println("\033[35mJarvis\033[0m: Starting System ...");
        System.out.println("\033[35mJarvis\033[0m: Connecting to IP...");
        config.setHost("ServerIP");// Server IP zum Connecten
        query.connect();
        api.login("serveradmin", "passwd");//ServerQuery Namen, Passwort(Login)
        api.selectVirtualServerById(1);//Server ID
        api.setNickname("Jarvis");
        config.setDebugLevel(Level.OFF);
        System.out.println("\033[35mJarvis\033[0m: Connected to Server!");
        System.out.println("\033[35mJarvis\033[0m: Nickname set 'Jarvis'");
        System.out.println("\033[35mJarvis\033[0m: Loading Files...");
        chat.start();
        System.out.println("\033[35mJarvis\033[0m: All Files enabled!");
        System.out.println(" ");
        System.out.println("Success, \033[1mSYSTEM\033[0m installed and started!");
        System.out.println("-----------------------------[\033[35mJarvis\033[0m]-----------------------------");

    }

}
