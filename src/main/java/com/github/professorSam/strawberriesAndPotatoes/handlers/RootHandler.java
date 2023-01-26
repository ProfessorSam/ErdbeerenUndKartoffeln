package com.github.professorSam.strawberriesAndPotatoes.handlers;

import com.github.professorSam.strawberriesAndPotatoes.StrawberriesAndPotatoes;
import gg.jte.output.StringOutput;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootHandler implements Handler {

    private static final Logger logger = LoggerFactory.getLogger("RootHandler");
    @Override
    public void handle(@NotNull Context context) throws Exception {
        logger.info("Root called");
        StringOutput output = new StringOutput();
        StrawberriesAndPotatoes.getInstance().getTemplateEngine().render("root.jte", null, output);
        context.html(output.toString());
    }
}
