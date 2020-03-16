package guru.springframework.spring5recipeapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String direction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob // binary large object field.
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Enumerated(value = EnumType.STRING) // this is gonna store string value of enum in db
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category_join",
            joinColumns =  @JoinColumn(name = "category"),
            inverseJoinColumns = @JoinColumn(name = "recipe"))
    private Set<Category> categories = new HashSet<>();


    public void setNotes(Notes notes) {
        this.notes = notes;
        this.notes.setRecipe(this);
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Recipe addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setRecipe(this);
        return this;
    }


}
