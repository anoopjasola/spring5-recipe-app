package guru.springframework.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.domain.Recipe;
import guru.springframework.service.RecipeService;

/**
 * Created by jt on 6/1/17.
 * @param <T>
 */
@RestController
public class IndexController<T> {

	private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
    
    @RequestMapping({"/getrecipe"})
    public ResponseEntity<?> getAllRecipe() {
    	Set<Recipe> recipeList = recipeService.getRecipes();
    	return new ResponseEntity<Set<Recipe>>(recipeList, HttpStatus.ACCEPTED);
    }
}
