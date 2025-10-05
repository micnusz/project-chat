package micnusz.chat.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import micnusz.chat.model.Message;
import micnusz.chat.repository.MessageRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Flux<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> sendMessage(Message message) {
        message.setTimestamp(Instant.now());
        return messageRepository.save(message);
    }

    public Flux<Message> getMessagesByAuthor(Long authorId) {
        return messageRepository.findAllByAuthorId(authorId);
    }
}
