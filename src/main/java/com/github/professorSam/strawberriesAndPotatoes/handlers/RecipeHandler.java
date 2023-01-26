package com.github.professorSam.strawberriesAndPotatoes.handlers;

import com.github.professorSam.strawberriesAndPotatoes.StrawberriesAndPotatoes;
import com.github.professorSam.strawberriesAndPotatoes.recipe.Recipe;
import gg.jte.output.StringOutput;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeHandler implements Handler {
    private static final Logger logger = LoggerFactory.getLogger("Recipe");
    @Override
    public void handle(@NotNull Context context) throws Exception {
        String id = context.pathParam("id");
        if(id.isEmpty()){
            context.result("No valid id provided");
            return;
        }
        Recipe recipe = StrawberriesAndPotatoes.getInstance().getRecipes().get(id.toLowerCase());
        if(recipe == null){
            context.result("No recipe for this id found");
            return;
        }
        logger.info("Load Recipe: " + id.toLowerCase());
        StringOutput output = new StringOutput();
        StrawberriesAndPotatoes.getInstance().getTemplateEngine().render("recipe.jte", recipe, output);
        context.html(output.toString());
        context.header("Content-Type", "text/html; charset=utf-8");
    }
}
