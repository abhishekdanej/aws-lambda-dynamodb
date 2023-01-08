package example;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

public class PersistCase {
	
	public void putRecord(String caseId, String employeeName, String email) {
		
		Region region = Region.AP_NORTHEAST_1;
		DynamoDbClient ddb = DynamoDbClient.builder().region(region).build();
		
		DynamoDbEnhancedClient eClient = DynamoDbEnhancedClient.builder().build();
		
		try {
			DynamoDbTable<Case> caseTable = eClient.table("Case", TableSchema.fromBean(Case.class));
			
			LocalDate localDate = LocalDate.parse("2023-01-07");
            LocalDateTime localDateTime = localDate.atStartOfDay();
            Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
            
            Case caseRecord = new Case();
            caseRecord.setName(employeeName);
            caseRecord.setEmail(email);
            caseRecord.setId(caseId);;
            caseRecord.setRegistrationDate(instant);
            
            caseTable.putItem(caseRecord);
		} catch (DynamoDbException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("done");

	}

}


