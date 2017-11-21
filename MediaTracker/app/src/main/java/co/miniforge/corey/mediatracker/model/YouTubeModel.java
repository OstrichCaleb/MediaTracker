package co.miniforge.corey.mediatracker.model;

import org.json.JSONObject;

/**
 * Created by ostri on 11/19/2017.
 */

public class YouTubeModel extends MediaItem {
    public String videoCreator;

    public YouTubeModel(JSONObject jsonObject) {
        super(jsonObject);
    }
}