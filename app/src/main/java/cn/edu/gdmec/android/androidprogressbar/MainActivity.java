package cn.edu.gdmec.android.androidprogressbar;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ProgressBar progressBar;
    private SeekBar seekBar;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        seekBar = (SeekBar) this.findViewById(R.id.seekBar1);

        ratingBar = (RatingBar) this.findViewById(R.id.ratingBar1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }
        });
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.print("--" + progress);
                Log.i("-->",progress+"");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("-->",rating+"");
            }
        });

    }

    class MyTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);

        }

        @Override
        protected Void doInBackground(Void... params) {
            int i = 1;
            while (i <= 100) {
                try {
                    Thread.sleep(500);

                } catch (Exception e) {

                }
                publishProgress(i);
                i++;
            }
            return null;
        }

    }
}
