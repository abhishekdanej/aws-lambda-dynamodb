package example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Handler implements RequestHandler<Map<String,String>, String> {

	@Override
	public String handleRequest(Map<String, String> event, Context context) {
		// TODO Auto-generated method stub

		LambdaLogger logger = context.getLogger();
		Gson gson = new GsonBuilder().create();
		
		logger.log("ENV VARIABLES: " + gson.toJson(System.getenv()));
		logger.log("CONTEXT: " + gson.toJson(context));
		
		logger.log("EVENT Data: " + gson.toJson(event));
		
		String myCaseID = event.get("inputCaseID");
		logger.log("CaseId: " + myCaseID);
		
		return myCaseID;
	}

}
