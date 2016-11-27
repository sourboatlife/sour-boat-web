package com.sourboatlife.ui.models;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Brian on 11/27/2016.
 */
public class Show {
    private List<Episode> episodes;

    public Show(List<Episode> episodes) {
        this.episodes = CollectionUtils.isEmpty(episodes) ? Collections.emptyList() : episodes;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}