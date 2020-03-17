package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock // 类似@Autowired
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); // this tells Mockito to give a mock recipeRepository
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes()  throws Exception {
//        Set<Recipe> recipes = recipeService.getRecipes();
//        assertEquals(5, recipes.size());
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
}