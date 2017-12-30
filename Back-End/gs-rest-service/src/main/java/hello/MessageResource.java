package hello;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResource {
	
	private MessageService messageService;
	
	@Autowired
	public MessageResource(MessageService messageService) {
		this.messageService = messageService;
	}
	
    @PostMapping("/messages")
    public ResponseEntity<?> messageResponse(@RequestBody Message messageInfo){
    return new ResponseEntity<>(messageService.responseService(messageInfo), HttpStatus.CREATED);
    }
    
    @GetMapping("/messages")
    public ResponseEntity<?> getLatestMessages(@RequestParam("limit") int limit){
    	List<Message> response = messageService.getLatestMessagesService(limit);
    	if(response.isEmpty()){
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}