    
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

import net.engio.mbassy.listener.Handler;

import org.kitteh.irc.client.library.Client;
import org.kitteh.irc.client.library.event.channel.ChannelJoinEvent;
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent;
import org.kitteh.irc.client.library.feature.twitch.TwitchSupport;


public class test1 {
	public static final String BOTNAME = "똑똑";
	public static final String OAUTH = "oauth:wy6k5a9pb5lvub4wqjjn5ma64rdh5j";
	public static final String CLIENTID = "6v4v3829v8ksmmbf6snrjm5la556pd";
	public static final String CHANNEL = "hana5837";

	public static PircBotX bot;
	
    public static class Listener {
        @Handler
        public void onUserJoinChannel(ChannelJoinEvent event) {
            if (event.getClient().isUser(event.getUser())) { // It's me!
                event.getChannel().sendMessage("Hello world! Kitteh's here for cuddles.");
                return;
            }
            // It's not me!
            event.getChannel().sendMessage("Welcome, " + event.getUser().getNick() + "! :3");
        }
        
        @Handler
        public void onMsgFired(ChannelMessageEvent event) {
        	String msg = event.getMessage();
        	event.sendReply(msg);
        	System.out.println(msg);
        	System.out.println(event.toString());
        	System.out.println(event.getActor());
        	System.out.println(event.getClient());
        }
    }


	public static void main(String[] args) throws Exception {
		/*
		Configuration config = new Configuration.Builder()
				.setName(BOTNAME)
				.setServerPassword(OAUTH)
				.addListener(new DDokDDok())
				.addAutoJoinChannel("#" + CHANNEL)
				.buildConfiguration();
		bot = new PircBotX(config);
		bot.startBot();*/
        Client client = Client.builder()
                .server().host("irc.chat.twitch.tv").port(443)
                .password(OAUTH).then()
                .nick(BOTNAME)
                .build();
        TwitchSupport.addSupport(client);
        client.connect();
        client.getEventManager().registerEventListener(new Listener());
        client.addChannel("#" + CHANNEL);
	}
}
