package com.github.professorSam.strawberriesAndPotatoes.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootHandler implements Handler {

    private static final Logger logger = LoggerFactory.getLogger("RootHandler");
    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.result("Root");
        logger.info("Root called");
    }
}
