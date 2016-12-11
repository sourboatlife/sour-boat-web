package com.sourboatlife.dataaccess;

import com.google.gson.Gson;
import com.sourboatlife.ui.models.Show;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

/**
 * Created by Brian on 12/11/2016.
 */
public class JsonShowRetriever implements ShowRetriever {
  private static Gson gson = new Gson();

  @Override
  public List<Show> getShows() {
    return Collections.singletonList(
      gson.fromJson(
        new InputStreamReader(
          getClass().getResourceAsStream("/com/sourboatlife/shows.json")),
        Show.class));
  }
}