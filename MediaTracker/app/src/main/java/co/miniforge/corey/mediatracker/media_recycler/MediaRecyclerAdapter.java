package co.miniforge.corey.mediatracker.media_recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import co.miniforge.corey.mediatracker.R;
import co.miniforge.corey.mediatracker.model.MediaItem;
import co.miniforge.corey.mediatracker.model.MovieModel;
import co.miniforge.corey.mediatracker.model.TVModel;
import co.miniforge.corey.mediatracker.model.YouTubeModel;

/**
 * Created by corey on 10/15/17.
 */

public class MediaRecyclerAdapter extends RecyclerView.Adapter {
    private List<MediaItem> mediaItems = new LinkedList<>();
    private final int TV = 0, MOVIE = 1, YT = 2, DE = 3;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflated;

        switch(viewType) {
            case TV:
                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item_tv, parent, false);
                break;
            case MOVIE:
                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item_movie, parent, false);
                break;
            case YT:
                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item_youtube, parent, false);
                break;
            default:
                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item, parent, false);
                break;
        }

        return new MediaViewHolder(inflated);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        switch(holder.getItemViewType()) {
//            case TV:
//                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item_tv, parent, false);
//                break;
//            case MOVIE:
//                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item_movie, parent, false);
//                break;
//            case YT:
//                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item_youtube, parent, false);
//                break;
//            case DE:
//                inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item, parent, false);
//                break;
//        }


        ((MediaViewHolder)holder).bindData(mediaItems.get(position));
    }

    @Override
    public int getItemViewType(int position){
        if (mediaItems.get(position) instanceof TVModel) {
            return TV;
        } else if (mediaItems.get(position) instanceof MovieModel){
            return MOVIE;
        } else if (mediaItems.get(position) instanceof YouTubeModel){
            return YT;
        } else if (mediaItems.get(position) instanceof MediaItem){
            return DE;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return mediaItems.size();
    }

    public void updateList(List<MediaItem> mediaItems){
        this.mediaItems = mediaItems;
        notifyDataSetChanged();
    }
}
