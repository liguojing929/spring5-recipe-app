package guru.springframework.spring5recipeapp.model;

import javax.persistence.*;

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

    public Notes() {
    }

    public Long getId() {
        return this.id;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public String getRecipeNote() {
        return this.recipeNote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setRecipeNote(String recipeNote) {
        this.recipeNote = recipeNote;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Notes)) return false;
        final Notes other = (Notes) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$recipe = this.getRecipe();
        final Object other$recipe = other.getRecipe();
        if (this$recipe == null ? other$recipe != null : !this$recipe.equals(other$recipe)) return false;
        final Object this$recipeNote = this.getRecipeNote();
        final Object other$recipeNote = other.getRecipeNote();
        if (this$recipeNote == null ? other$recipeNote != null : !this$recipeNote.equals(other$recipeNote))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $recipe = this.getRecipe();
        result = result * PRIME + ($recipe == null ? 43 : $recipe.hashCode());
        final Object $recipeNote = this.getRecipeNote();
        result = result * PRIME + ($recipeNote == null ? 43 : $recipeNote.hashCode());
        return result;
    }

    public String toString() {
        return "Notes(id=" + this.getId() + ", recipe=" + this.getRecipe() + ", recipeNote=" + this.getRecipeNote() + ")";
    }
}
