package co.miniforge.corey.mediatracker;

/**
 * Created by ostri on 11/19/2017.
 */

import co.miniforge.corey.mediatracker.model.MediaItem;
import co.miniforge.corey.mediatracker.model.MediaItemType;

        import android.support.v7.widget.PopupMenu;
        import android.view.MenuItem;

        import co.miniforge.corey.mediatracker.model.MediaItem;
        import co.miniforge.corey.mediatracker.model.MediaItemType;

public class AddPopUpMenuHelper implements android.widget.PopupMenu.OnMenuItemClickListener {

    MyListActivity activity;

    public AddPopUpMenuHelper(MyListActivity activity){
        this.activity = activity;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.movie:
                activity.addMediaItem(new MediaItem(MediaItemType.Movie));
                break;
            case R.id.tv:
                activity.addMediaItem(new MediaItem(MediaItemType.TV));
                break;
            case R.id.youtube:
                activity.addMediaItem(new MediaItem(MediaItemType.YouTube));
                break;
            default:
                activity.addMediaItem(new MediaItem(MediaItemType.Generic));
                break;
        }

        return true;
    }
}