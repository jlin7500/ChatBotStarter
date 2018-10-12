import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args) {
		ChatBotjlin chatbot1 = new ChatBotjlin();
		ChatBotGliu chatbot2 = new ChatBotGliu();
		ChatBotVzhao chatbot3 = new ChatBotVzhao();


		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the chatbot, nice to meet you.");
		System.out.println("Select a game");
		System.out.println("'League of Legends', 'Minecraft', 'Blade and Soul'");
		System.out.println("Please type exactly as shown it is case sensitive.");
		String statement = in.nextLine();
		if (statement.equals("League of Legends"))
		{
			chatbot3.chatLoop(statement);
			statement = in.nextLine();
		}
		else if (statement.equals("Minecraft"))
		{
			chatbot2.chatLoop(statement);
			statement = in.nextLine();
		}
		else if(statement.equals("Blade and Soul"))
		{
			chatbot1.chatLoop(statement);
			statement = in.nextLine();
		}




		if (statement.equals(""))
		while (!statement.equals("Bye"))
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example has only chatbot1

			chatbot1.chatLoop(statement);
			statement = in.nextLine();


		}
	}

}
