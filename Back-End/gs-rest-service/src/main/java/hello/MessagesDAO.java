package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessagesDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MessagesDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public void initializeTables(){
		
		log.info("Creating tables");
		
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS messages(id UUID, username VARCHAR(255), message TEXT, posted_at TIMESTAMP)");
	}
	
	public void saveMessage(Message response){
		jdbcTemplate.update("INSERT INTO messages(id, username, message, posted_at) VALUES (?, ?, ?, ?)", 
    			new Object[] { response.getID(), response.getUsername(), response.getMessage(), response.getPostedAt()});
	}
	
	public int getMessagesCount(){
		
		String sql = "SELECT COUNT(*) FROM messages;";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	public List<Message> getLatestMessages(int limit){
		
		List<Message> latestMessages = new ArrayList<Message>();
		String sql = ""
				+ "SELECT id, username, message, posted_at "
				+ "FROM messages "
				+ "ORDER BY posted_at DESC "
				+ "LIMIT ?;";
		
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {limit});
		
		for (Map<String, Object> row : rows) {
			
			UUID id = UUID.fromString((String)row.get("id"));
			String message = (String)row.get("message");
			String username = (String)row.get("username");
			String postedAt = (String)row.get("posted_at");
			
			Message currentMessage = new Message(username, message, id, postedAt);
			latestMessages.add(currentMessage);		
		}
			
		return latestMessages;	
	}

}
