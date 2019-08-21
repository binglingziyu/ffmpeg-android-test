package online.testdata.ffmpegtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
        System.loadLibrary("avutil");
        System.loadLibrary("native-lib");
    }

    public native String avformatInfo();
    public native String avcodecInfo();
    public native String avfilterInfo();
    public native String configurationInfo();

    private TextView mInfoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoView = findViewById(R.id.info_text);
    }


    public void format(View view) {
        mInfoView.setText(avformatInfo());
    }

    public void codec(View view) {
        mInfoView.setText(avcodecInfo());
    }

    public void filter(View view) {
        mInfoView.setText(avfilterInfo());
    }

    public void config(View view) {
        mInfoView.setText(configurationInfo());
    }
}
