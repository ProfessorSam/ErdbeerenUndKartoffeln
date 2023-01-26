package com.github.professorSam.strawberriesAndPotatoes;

import com.github.professorSam.strawberriesAndPotatoes.handlers.RootHandler;
import com.github.professorSam.strawberriesAndPotatoes.recipe.Recipe;
import com.google.gson.Gson;
import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StrawberriesAndPotatoes {

    private static final Logger logger = LoggerFactory.getLogger("Main");

    private static StrawberriesAndPotatoes instance;
    private static final Properties PROPERTIES = new Properties();
    private static final List<Recipe> RECIPES = new ArrayList<>();
    private final File runningDirectory;
    private final TemplateEngine templateEngine;

    public StrawberriesAndPotatoes() throws URISyntaxException, IOException {
        instance = this;
        this.runningDirectory = new File(StrawberriesAndPotatoes.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        logger.info("Running in " + runningDirectory.getCanonicalPath());
        loadProperties();
        loadRecipies();
        startWebServer();
        CodeResolver codeResolver = new ResourceCodeResolver("");
        templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
    }

    private void startWebServer(){
        Javalin server = Javalin.create();
        server.get("/", new RootHandler());
        server.start(getProperty("host"), Integer.parseInt(getProperty("port")));
    }

    private void loadRecipies(){
        File recipiesDir = new File(runningDirectory, "recipes");
        if(!recipiesDir.exists()){
            logger.info("No recipies directory found!");
            recipiesDir.mkdirs();
            try {
                Files.copy(StrawberriesAndPotatoes.class.getClassLoader().getResourceAsStream("exampleRecipe.json"), Path.of(recipiesDir.getPath(), "example.json"));
            } catch (IOException e) {
                logger.error("Unable to create example recipe", e);
                System.exit(-1);
            }
        }
        logger.info("Loading recipes");
        Gson gson = new Gson();
        for(File file : recipiesDir.listFiles()){
            if(!file.getName().contains(".json")){
                logger.warn("Non json file found in recipes: " + file.getName());
                continue;
            }
            try(Reader reader = new FileReader(file)){
                Recipe recipe = gson.fromJson(reader, Recipe.class);
                logger.info("Loaded: " + recipe.getTitle());
                RECIPES.add(recipe);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("Loaded " + RECIPES.size() + " recipes!");
    }

    private void loadProperties(){
        File propertiesFile = new File(runningDirectory, "server.properties");
        if(!propertiesFile.exists()){
            logger.info("No server.properties found! Creating...");
            try {
                Files.copy(StrawberriesAndPotatoes.class.getClassLoader().getResourceAsStream("server.properties"), Path.of(propertiesFile.getPath()));
            } catch (IOException e) {
                logger.error("Can't load properties");
                e.printStackTrace();
                System.exit(-1);
            }
            logger.info("Created!");
        }
        try {
            logger.info("Loading server.properties");
            PROPERTIES.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            logger.warn("Can't load properties", e);
            System.exit(-1);
        }
    }

    public String getProperty(String key){
        String value = PROPERTIES.getProperty(key);
        if(value != null){
            return value;
        }
        logger.warn(key + " is missing in default config");
        Properties defaultProperties = new Properties();
        try {
            defaultProperties.load(StrawberriesAndPotatoes.class.getResourceAsStream("server.properties"));
            value = defaultProperties.getProperty(key);
            if(value != null){
                return value;
            }
            throw new RuntimeException("Value not found: " + key);
        } catch (IOException e) {
            throw new RuntimeException("Can't load properties", e);
        }
    }

    public static void main(String[] args){
        try {
            new StrawberriesAndPotatoes();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static StrawberriesAndPotatoes getInstance() {
        return instance;
    }

    public TemplateEngine getTemplateEngine(){
        return templateEngine;
    }
}
