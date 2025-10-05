package micnusz.chat.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table("messages")
public class Message {

    @Id
    private Long id;

    @NotBlank
    private String content;

    private Long authorId;

    private Instant timestamp = Instant.now();
}
