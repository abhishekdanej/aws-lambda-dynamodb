package example;

import java.time.Instant;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class Case {
	public String id;
	public String name;
	public String email;
	public Instant regDate;

	@DynamoDbPartitionKey
    public String getId() {
        return this.id;
    };

    public void setId(String id) {

        this.id = id;
    }

    @DynamoDbSortKey
    public String getName() {
        return this.name;

    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Instant getRegistrationDate() {
        return regDate;
    }
    public void setRegistrationDate(Instant registrationDate) {

        this.regDate = registrationDate;
    }
   }
