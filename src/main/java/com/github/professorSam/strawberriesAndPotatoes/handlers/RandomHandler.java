package com.github.professorSam.strawberriesAndPotatoes.handlers;

import com.github.professorSam.strawberriesAndPotatoes.StrawberriesAndPotatoes;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Set;

public class RandomHandler implements Handler {

    private static final Logger logger = LoggerFactory.getLogger("Random");
    private static final Random random = new Random();
    @Override
    public void handle(@NotNull Context context) throws Exception {
        Set<String> keys = StrawberriesAndPotatoes.getInstance().getRecipes().keySet();
        int index = random.nextInt(keys.size());
        String[] keyArray = keys.toArray(new String[0]);
        String id = StrawberriesAndPotatoes.getInstance().getRecipes().get(keyArray[index]).getId();
        context.redirect("/recipe/" + id);
        logger.info("Redirect to /recipe/" + id);
    }
}
