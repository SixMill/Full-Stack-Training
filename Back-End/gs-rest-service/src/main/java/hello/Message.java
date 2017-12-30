package hello;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Message {

	@JsonProperty
    private String username;
	@JsonProperty
	private String message;
	@JsonProperty
    private UUID id;
	@JsonProperty
    private String postedAt;

	//Constructor for posting a message
    public Message(String username, String message) {
    	this.id = UUID.randomUUID();
    	this.message = message;
        this.username = username;
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSSSSS Z");
        this.postedAt = ZonedDateTime.now().format(FORMATTER);
    }
    
    //Constructor for getting a message from the Database
    public Message(String username, String message, UUID id, String postedAt) {
    	this.id = id;
    	this.message = message;
        this.username = username;
        this.postedAt = postedAt;
	}

	public Message() {
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}

	public UUID getID(){
    	return id;
    }
    
    public String getUsername(){
    	return username;
    }
    
    public String getMessage(){
    	return message;
    }
    
    public String getPostedAt(){
    	return postedAt;
    }

}
