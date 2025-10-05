package micnusz.chat.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import micnusz.chat.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByUsername(String username);
}
