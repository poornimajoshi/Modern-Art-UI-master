package course.labs.modernuilab;

import java.util.Random;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.annotation.TargetApi;
import android.graphics.Color;


public class MainFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
	
    private static final String TAG = MainFragment.class.getSimpleName();
    
    public MainFragment() {
    }
	
	private View mView1, mView2, mView3, mView4, mView5;
    private SeekBar mSeekBar;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		mSeekBar = (SeekBar) rootView.findViewById(R.id.seek_bar);
		mView1 = (View) rootView.findViewById(R.id.view1);
		mView2 = (View) rootView.findViewById(R.id.view2);
		mView3 = (View) rootView.findViewById(R.id.view3);
		mView4 = (View) rootView.findViewById(R.id.view4);
		mView5 = (View) rootView.findViewById(R.id.view5);
		mSeekBar.setOnSeekBarChangeListener(this);
		//load random colors
		setRandomColors();
		return rootView;
	}
	
    private void setRandomColors(){
        setRandomColor(mView1, getRandomColor());
        setRandomColor(mView2, getRandomColor());
        setRandomColor(mView3, getRandomColor());
        setRandomColor(mView4, Color.LTGRAY);
        setRandomColor(mView5, getRandomColor());
    }
    
    private void setRandomColor(View view, int color){
        view.setBackgroundColor(color);
        view.setTag(color);
    }
	
	private int getRandomColor(){
        Random rnd = new Random(); 
        int color = Color.argb(255, rnd.nextInt(156), rnd.nextInt(256), rnd.nextInt(256));
        return color;
    }
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void changeColor(View view, int additionalValue) {
		int color = (Integer) view.getTag();
		color += additionalValue;
		view.setBackgroundColor(color);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		changeColor(mView1, progress);
		changeColor(mView2, progress);
		changeColor(mView3, progress);
		//changeColor(mView4, progress);
		changeColor(mView5, progress);	
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
