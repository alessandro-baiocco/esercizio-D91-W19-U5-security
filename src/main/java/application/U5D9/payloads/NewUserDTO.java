package application.U5D9.payloads;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record NewUserDTO(
        @NotEmpty(message = "Il nome è un campo obbligatorio!")
        @Size(min = 3, max=30, message = "Il nome deve essere compreso tra 3 e 30 caratteri")
        String nome,
        @NotEmpty(message = "Il cognome è un campo obbligatorio!")
        @Size(min = 3, max=30, message = "Il nome deve essere compreso tra 3 e 30 caratteri")
        String cognome,
        @NotEmpty(message = "la password è un campo obbligatorio!")
        @Size(min = 3, max=30, message = "Il nome deve essere compreso tra 3 e 30 caratteri")
        String password,
        @Past(message = "la data di nascita deve essere nel passato")
        LocalDate dataDiNascita,
        @NotEmpty(message = "L'email è un campo obbligatorio!")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email) {
}
