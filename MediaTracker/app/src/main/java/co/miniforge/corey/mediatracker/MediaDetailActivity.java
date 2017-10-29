package co.miniforge.corey.mediatracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import co.miniforge.corey.mediatracker.model.MediaItem;

public class MediaDetailActivity extends AppCompatActivity {
    EditText titleEntry;
    EditText descriptionEntry;
    EditText urlEntry;
    Button saveBtn;

    MediaItem mediaItem;
    JSONObject jsonObject;

    String mediaExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_detail);

        locateViews();

        bindFunctionality();
    }

    private void locateViews() {
        this.titleEntry = (EditText) findViewById(R.id.titleEntry);
        this.descriptionEntry = (EditText) findViewById(R.id.descriptionEntry);
        this.urlEntry = (EditText) findViewById(R.id.urlEntry);

        this.saveBtn = (Button) findViewById(R.id.saveBtn);
    }

    private void bindFunctionality() {
        if(getIntent().hasExtra(MyListActivity.mediaExtra)) {
            this.mediaExtra = getIntent().getStringExtra(MyListActivity.mediaExtra);

            jsonObject = null;

            try {
                jsonObject = new JSONObject(this.mediaExtra);
            } catch (Exception e){
                // Throw some exception
            }

            mediaItem = new MediaItem(jsonObject);

            titleEntry.setText(mediaItem.title);
            descriptionEntry.setText(mediaItem.description);
            urlEntry.setText(mediaItem.url);
        }

        saveBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mediaItem.title = titleEntry.getText().toString();
                mediaItem.description = descriptionEntry.getText().toString();
                mediaItem.url = urlEntry.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyListActivity.class);
                intent.putExtra(MyListActivity.mediaExtra, mediaItem.toJson().toString());
                startActivity(intent);
            }
        });
    }
}