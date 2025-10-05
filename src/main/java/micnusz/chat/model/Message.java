package micnusz.chat.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("messages")
public class Message {

    @Id
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    private Instant timestamp;
}
