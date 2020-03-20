package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock // 类似@Autowired
    private RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); // this tells Mockito to give a mock recipeRepository
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe,recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional =Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
        assertNotNull(recipeReturned, "Null recipe returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();

    }


    @Test
    public void getRecipes()  throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        /**
         *when recipeRepo.findAll() gets called, we want to return recipeData to the test
         */
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());

        /**
         * this is to verify how many times the findAll() has been called.
         */
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() throws Exception {
        Long idToDelete = Long.valueOf(2L);
        recipeService.deleteById(idToDelete);
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}