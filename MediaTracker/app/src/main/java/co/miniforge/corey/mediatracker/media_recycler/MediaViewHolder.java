package co.miniforge.corey.mediatracker.media_recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.miniforge.corey.mediatracker.MediaDetailActivity;
import co.miniforge.corey.mediatracker.MediaItemDetailActivity;
import co.miniforge.corey.mediatracker.MyListActivity;
import co.miniforge.corey.mediatracker.R;
import co.miniforge.corey.mediatracker.model.MediaItem;

/**
 * Created by caleb on 10/28/17.
 */

public class MediaViewHolder extends RecyclerView.ViewHolder {
    TextView mediaName;
    TextView mediaDescription;

    View inflated;

    Context context;

    public MediaViewHolder(View itemView) {
        super(itemView);

        locateViews(itemView);
    }

    private void locateViews(View itemView) {
        inflated = itemView;
        context = itemView.getContext();

        mediaName = itemView.findViewById(R.id.mediaName);
        mediaDescription = itemView.findViewById(R.id.mediaDescription);
    }

    public void bindData(final MediaItem mediaItem) {
        this.mediaName.setText(mediaItem.title);
        this.mediaDescription.setText(mediaItem.description);

        inflated.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MediaDetailActivity.class);
                intent.putExtra(MyListActivity.mediaExtra, mediaItem.toJson().toString());
                context.startActivity(intent);
            }
        });

        inflated.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                ((MyListActivity)context).deleteMediaItem(mediaItem);
                return true;
            }
        });
    }
}
