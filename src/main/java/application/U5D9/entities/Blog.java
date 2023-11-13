package application.U5D9.entities;

import application.U5D9.enums.BlogCategory;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder(builderClassName = "buildBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private BlogCategory blogCategory;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User utente;


    public static class buildBuilder{
        private BlogCategory blogCategory;
        private String titolo = null;
        private String cover = null;
        private String contenuto = null;
        private int tempoDiLettura;
        private User utente = null;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", blogCategory=" + blogCategory +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura;
    }
}
