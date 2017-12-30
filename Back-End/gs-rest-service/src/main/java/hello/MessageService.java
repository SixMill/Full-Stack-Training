package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageService {
	
	private MessagesDAO messagesDAO;

	@Autowired
	public MessageService(MessagesDAO messagesDAO) {
		this.messagesDAO = messagesDAO;
	}

	public Message responseService(Message messageInfo) {
		Message response = new Message(messageInfo.getUsername(), messageInfo.getMessage());
		messagesDAO.saveMessage(response);
		return response;
	}
	
	public List<Message> getLatestMessagesService(int limit){
		int count = messagesDAO.getMessagesCount();
		if(count > 0){
			List<Message> latestMessages = messagesDAO.getLatestMessages(limit);
			return latestMessages;
		}
		else return new ArrayList<Message>();
	}

}
