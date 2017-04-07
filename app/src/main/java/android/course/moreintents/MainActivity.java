package android.course.moreintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimePicker alarmTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTime = (TimePicker) findViewById(R.id.alarmTime);

//        int hour = alarmTime.getCurrentHour();
//        int minute = alarmTime.getCurrentMinute();


    }

    public void dial(View view) {

        Uri tel = Uri.parse("tel:0543536074");
        Intent dialIntent = new Intent (Intent.ACTION_DIAL,tel);

        if (canOpen(dialIntent)) {
            startActivity(dialIntent);
        }else
            Toast.makeText(this, "No dialer found",Toast.LENGTH_SHORT).show();
    }

    public void website(View view) {

        Uri web = Uri.parse("http://www.fourtec.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW,web);

        if (canOpen(webIntent)) {
            startActivity(webIntent);
        }else {
            Toast.makeText(this, "No browser found", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean canOpen(Intent intent) {
        return intent.resolveActivity(getPackageManager()) !=null;
    }

    public void setAlarm(View view) {
        int hour = 0;
        int minutes = 0;

        if (isM()) {
            hour = alarmTime.getHour();
            minutes = alarmTime.getMinute();
        }else {
            hour = alarmTime.getCurrentHour();
            minutes = alarmTime.getCurrentMinute();
        }

        Intent setAlarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);

        setAlarmIntent.putExtra(AlarmClock.EXTRA_HOUR,hour);
        setAlarmIntent.putExtra(AlarmClock.EXTRA_MINUTES,minutes);


        if (canOpen(setAlarmIntent)){
            startActivity(setAlarmIntent);
        }else {
            Toast.makeText(this, "No alarm clock detected!", Toast.LENGTH_LONG).show();
        }


    }

    public boolean isM() {
        return Build.VERSION.SDK_INT>= Build.VERSION_CODES.M;
    }
}
