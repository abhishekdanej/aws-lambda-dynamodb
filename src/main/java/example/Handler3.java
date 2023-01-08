package example;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler3 implements RequestHandler<String, String> {

	@Override
	public String handleRequest(String event, Context context) {

		LambdaLogger logger = context.getLogger();
		String email = event;
		
		logger.log("\nEmail value: " + email);
		SendMessage msg = new SendMessage();
		
		try {
			msg.sendMessage(email);
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		return "";
	}

}
