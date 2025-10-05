package micnusz.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table("users")
public class User {

    @Id
    private Long id;

    @Column("username")
    @NotBlank(message = "Username is mandatory")
    @Size(min = 5, max = 30)
    private String username;

    @JsonIgnore
    @Column("password")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 30)
    private String password;

    @Column("online")
    private boolean online = false;

    @Column("role")
    private Role role;
}
