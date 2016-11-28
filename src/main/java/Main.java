import com.sourboatlife.ui.models.Episode;
import com.sourboatlife.ui.models.Show;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

  public static void main(String[] args) {

    port(System.getenv("PORT") != null
      ? Integer.valueOf(System.getenv("PORT"))
      : 5000);
    staticFileLocation("/public");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("show", new Show(Arrays.asList(new Episode.Builder()
                    .withTitle("Test Data!")
                    .withLink("http://www.twitch.tv/sourboatlife")
                    .build())));

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    /*
    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());
    */
  }

}
