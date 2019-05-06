import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.PingEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DDokDDok extends ListenerAdapter{
	//Mods usernames must be lowercase
	private List<String> mods = new ArrayList<>();

	public DDokDDok() {
		mods.add("yourname");
	}
	//This will return the response from the command
	private String runCommands(GenericMessageEvent event, String command) {
		if(command.equalsIgnoreCase("!raffle") && mods.contains(event.getUser().getNick())) {
			try {
				List<String> temp = new ArrayList<>();
				JSONObject json = new JSONObject(JSONParser.readUrl(String.format("https://tmi.twitch.tv/group/user/%s/chatters", test1.CHANNEL)));
				System.out.println(json.toString());
				JSONArray viewers = json.getJSONObject("chatters").getJSONArray("viewers");
				for (int j = 0; j < viewers.length(); j++) {
					temp.add(viewers.getString(j));
				}
				JSONArray mods = json.getJSONObject("chatters").getJSONArray("moderators");
				for (int j = 0; j < mods.length(); j++) {
					temp.add(mods.getString(j));
				}

				Random random = new Random();
				return String.format("Congratulations %s! You won the raffle!", temp.get(random.nextInt(temp.size())));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equalsIgnoreCase("!schedule")) {
			return "This is an example bot, replace this text with your schedule text";
		}

		return null;
	}

	/**
	 * PircBotx will return the exact message sent and not the raw line
	 */
	@Override
	public void onGenericMessage(GenericMessageEvent event) throws Exception {
		String message = event.getMessage();
		String command = getCommandFromMessage(message);

		String response = runCommands(event, command);
		if(response != null) sendMessage(response);
	}

	/**
	 * The command will always be the first part of the message
	 * We can split the string into parts by spaces to get each word
	 * The first word if it starts with our command notifier "!" will get returned
	 * Otherwise it will return null
	 */
	private String getCommandFromMessage(String message) {
		String[] msgParts = message.split(" ");
		if (msgParts[0].startsWith("!")) {
			return msgParts[0];
		} else {
			return null;
		}
	}

	/**
	 * We MUST respond to this or else we will get kicked
	 */
	@Override
	public void onPing(PingEvent event) throws Exception {
		test1.bot.sendRaw().rawLineNow(String.format("PONG %s\r\n", event.getPingValue()));
	}

	private void sendMessage(String message) {
		test1.bot.sendIRC().message("#" + test1.CHANNEL, message);
	}
}
