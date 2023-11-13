package application.U5D9.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nome;
        private String cognome;
        private String email;
        private String password;
        private LocalDate dataDiNascita;
        private String userPicture;
        @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true , mappedBy = "utente")
        @JsonIgnore
        private List<Blog> blogs;

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", nome='" + nome + '\'' +
                        ", cognome='" + cognome + '\'' +
                        ", email='" + email + '\'' +
                        ", dataDiNascita=" + dataDiNascita +
                        ", userPicture='" + userPicture + '\'' +
                        '}';
        }
}
