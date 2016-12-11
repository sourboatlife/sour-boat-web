package com.sourboatlife.ui.models;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Brian on 11/27/2016.
 */
public class Show {
    private String title;
    private List<Episode> episodes;

    public Show(String title, List<Episode> episodes) {
        this.title = title;
        this.episodes = CollectionUtils.isEmpty(episodes) ? Collections.emptyList() : episodes;
    }

    public String getTitle() {
        return title;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}