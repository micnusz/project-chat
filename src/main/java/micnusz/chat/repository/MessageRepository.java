package micnusz.chat.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import micnusz.chat.model.Message;
import reactor.core.publisher.Flux;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
    Flux<Message> findAllByReceiverId(Long receiverId);
}
