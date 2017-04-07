package android.course.moreintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dial(View view) {

        Uri tel = Uri.parse("tel:0543536074");
        Intent dialIntent = new Intent (Intent.ACTION_DIAL,tel);


        startActivity(dialIntent);
    }
}
