package guru.springframework.spring5recipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // no need for cascade here - we want to keep recipe even if we delete note
    private Recipe recipe;


    /**
     * @Lob: signifies that the annotated field should be represented as BLOB (binary data) in the DataBase.
     * Specifies that a persistent property or field should be persisted as
     * a large object to a database-supported large object type.
     * Common use of @Lob is to annotate a HashMap field inside your Entity to store some of the object properties
     * which are not mapped into DB columns.
     */
    @Lob
    private String recipeNote;

}
