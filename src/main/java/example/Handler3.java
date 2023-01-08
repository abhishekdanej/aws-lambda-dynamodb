package example;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import software.amazon.awssdk.utils.Logger;

public class Handler3 implements RequestHandler<String, String> {

	@Override
	public String handleRequest(String event, Context context) {

		LambdaLogger log = context.getLogger();
		String email = event;
		
		Logger.loggerFor("Email value: " + email);
		SendMessage msg = new SendMessage();
		
		try {
			msg.sendMessage(email);
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		return "";
	}

}
