package micnusz.chat.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import micnusz.chat.model.Message;
import micnusz.chat.service.MessageService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public Flux<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public Mono<Message> sendMessage(@RequestBody Message message, @AuthenticationPrincipal Jwt jwt) {
        message.setAuthorId(Long.parseLong(jwt.getSubject()));
        return messageService.sendMessage(message);
    }

}
