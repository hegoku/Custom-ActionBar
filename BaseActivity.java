import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class BaseActivity extends Activity implements OnClickListener{

	private TextView mTitleTextView;
	private TextView mBackwardbButton;
	private TextView mForwardButton;
	private FrameLayout mContentLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_base);

		ActionBar mActionBar=getActionBar();
		mActionBar.hide();

		mTitleTextView = (TextView) findViewById(R.id.text_title);
        mContentLayout = (FrameLayout) findViewById(R.id.layout_content);
        mBackwardbButton = (TextView) findViewById(R.id.button_backward);
        mForwardButton = (TextView) findViewById(R.id.button_forward);

        mForwardButton.setOnClickListener(this);
        mBackwardbButton.setOnClickListener(this);
	}

	//取出FrameLayout并调用父类removeAllViews()方法
    @Override
    public void setContentView(int layoutResID) {
        mContentLayout.removeAllViews();
        View.inflate(this, layoutResID, mContentLayout);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view);
        onContentChanged();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(View view, LayoutParams params) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view, params);
        onContentChanged();
    }

	@Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_backward:
                onBackward(v);
                break;

            case R.id.button_forward:
                onForward(v);
                break;

            default:
                break;
        }
    }

	public void setTitle(String t) {
        mTitleTextView.setText(t);
    }

	public void setForwardText(String t) {
		mForwardButton.setText(t);
		if(t.equals("")){
			mForwardButton.setVisibility(View.INVISIBLE);
		}else{
			mForwardButton.setVisibility(View.VISIBLE);
		}
    }

	public void setBackwardText(String t) {
		mBackwardbButton.setText(t);
		if(t.equals("")){
			mBackwardbButton.setVisibility(View.INVISIBLE);
		}else{
			mBackwardbButton.setVisibility(View.VISIBLE);
		}
    }

	protected void onForward(View forwardView) {

    }

	protected void onBackward(View backwardView) {
    }
}
