import com.sourboatlife.dataaccess.JsonShowRetriever;
import com.sourboatlife.ui.models.Show;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        port(Integer.valueOf(Optional.ofNullable(System.getenv("PORT")).orElse("8000")));

        staticFileLocation("/public");

        final List<Show> shows = new JsonShowRetriever().getShows();

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("shows", shows);
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/sh", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("shows", shows);
            return new ModelAndView(attributes, "sh.ftl");
        }, new FreeMarkerEngine());
    }
}