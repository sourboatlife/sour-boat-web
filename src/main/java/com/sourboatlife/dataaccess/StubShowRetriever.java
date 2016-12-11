package com.sourboatlife.dataaccess;

import com.sourboatlife.ui.models.Episode;
import com.sourboatlife.ui.models.Show;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Brian on 12/11/2016.
 */
public class StubShowRetriever implements ShowRetriever {
    @Override
    public List<Show> getShows() {
        List<Episode> episodes = Arrays.asList(
          new Episode.Builder()
            .withTitle("Title of this week's Show")
            .withDescription("This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show.")
            .withLink("https://www.youtube.com/embed/AZc0QiGdzl8")
            .withLink("https://www.youtube.com/embed/t5IYkoQ-2hY")
            .withTag("Programming").withTag("UI Frameworks")
            .withOriginalAirDate(ZonedDateTime.now())
            .build(),
          new Episode.Builder()
            .withTitle("Title of last week's Show")
            .withDescription("This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show. This is a long description of what it is we did during this show.")
            .withLink("https://www.youtube.com/embed/lsLs1sQhubc")
            .withTag("Programming").withTag("Pilot")
            .withOriginalAirDate(ZonedDateTime.now())
            .build());

        return Collections.singletonList(new Show("Sour Boat Life", episodes));
    }
}