import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.kitteh.irc.client.library.Client;
import org.kitteh.irc.client.library.event.channel.ChannelJoinEvent;
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent;
import org.kitteh.irc.client.library.feature.twitch.TwitchSupport;

import net.engio.mbassy.listener.Handler;

public class DDokDDokTwitch {
	public static final String BOTNAME = "ddok_ddok";
	//public static final String CLIENTID = "6v4v3829v8ksmmbf6snrjm5la556pd";
	public static String CHANNEL = "#hana5837";
	public static ArrayList<String> userLogged;
	public static int test = 0;
	
	public static class Listener {
        @Handler
        public void onUserJoinChannel(ChannelJoinEvent event) {
        	String msgUser = event.getUser().getNick();
        	if (!userLogged.contains(msgUser)) {
        		event.getChannel().sendMessage("안녕 " + msgUser);
        		userLogged.add(msgUser);
        	}
        }
        
        @Handler
        public void onMsgFired(ChannelMessageEvent event) {
        	String msgUser = event.getActor().getNick();
        	
        	// Part 1 : Msg Chk
        	String msg = event.getMessage();
        	System.out.println(msg);

        	test++;
        	if (test == 5) {
        		banUser(event);
        	}
        	//System.out.println(event.getActor().getHost());
        
        	// Part 2 : Username Chk
        	if (!userLogged.contains(msgUser)) {
        		event.sendReply("안녕" + msgUser);
        		userLogged.add(msgUser);
        	}        	
        }
        private void banUser(ChannelMessageEvent event) {
        	String msgUser = event.getActor().getNick();
        	event.sendReply("/ban " + msgUser);
        }
    }

	public DDokDDokTwitch(String CHANNEL, String UserName) {
		this.CHANNEL = CHANNEL;
		userLogged = new ArrayList<>();
		userLogged.add(BOTNAME);
		userLogged.add(UserName);
	}
	
	public void connect() {
		String OAUTH = oauthString();
        Client client = Client.builder()
                .server().host("irc.chat.twitch.tv").port(443)
                .password(OAUTH).then()
                .realName(BOTNAME)
                .build();
        TwitchSupport.addSupport(client);
        client.connect();
        client.getEventManager().registerEventListener(new Listener());
        client.addChannel(CHANNEL);
	}
	
	public String oauthString() {
		String ret;
		try {
			String file = "./Resources/oauth.json";
			InputStream is = DDokDDokTwitch.class.getResourceAsStream(file);
	        if (is == null) {
	            throw new NullPointerException("Cannot find resource file " + file);
	        }
	        
	        JSONTokener tokener = new JSONTokener(is);
	        JSONObject jsonObject = new JSONObject(tokener);
	   
	        ret = (String) jsonObject.get("OAUTH");
		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}
		System.out.println(ret);
		return ret;
	}
}
