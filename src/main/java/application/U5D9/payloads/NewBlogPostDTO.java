package application.U5D9.payloads;

import application.U5D9.enums.BlogCategory;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewBlogPostDTO(
        BlogCategory blogCategory,
        @NotEmpty(message = "Il nome è un campo obbligatorio!")
        @Size(min = 3, max=30, message = "Il titolo deve essere compreso tra 3 e 30 caratteri")
         String titolo,
         String cover,
        @NotEmpty(message = "Il contenuto è un campo obbligatorio!")
        @Size( max=100, message = "Il contenuto deve essere massimo di 100 caratteri")
         String contenuto,
         @NotNull(message = "Il tempo di lettura è un campo obbligatorio!")
         int tempoDiLettura,
        @NotNull(message = "l'utente è un campo obbligatorio!")
         int utente_id
) {
}
