package hello;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LatestMessagesResponse{
	
	@JsonProperty
	private final int count;
	@JsonProperty
	private List<Message> latestMessages;
	
	public LatestMessagesResponse(int count, List<Message> latestMessages){
		this.count = count;
		this.latestMessages = latestMessages;
	}

	public List<Message> getLatestMessages() {
		return latestMessages;
	}
	
}
