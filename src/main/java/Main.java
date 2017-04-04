import com.google.gson.Gson;
import com.sourboatlife.dataaccess.JsonShowRetriever;
import com.sourboatlife.ui.models.Show;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        String port = System.getenv("PORT");
        port(Integer.valueOf(port == null ? "8080" : port));

        staticFileLocation("/public");

        final List<Show> shows = new JsonShowRetriever().getShows();

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("shows", shows);
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        /*
        Gson gson = new Gson();

        get("/sh", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("shows", shows);
            return new ModelAndView(attributes, "sh.ftl");
        }, new FreeMarkerEngine());

        get("/json", (request, response) -> {
            response.type("text/json");
            return gson.toJson(shows);
        });
        */
    }
}