##用法

将BaseActivity.java复制到src目录,将activity_base.xml复制到res/layout目录,然后让要显示的Activity继承改类:

```java
public class MainActivity extends BaseActivity{
  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
}
```

##方法

```java
public void setTitle(String t)        //设置标题

public void setForwardText(String t)  //设置右边按钮文字,如果为空则不显示按钮

public void setBackwardText(String t) //设置左边按钮文字,如果为空则不显示按钮

protected void onForward(View forwardView)    //子类重写该方法来处理右边按钮的点击事件

protected void onBackward(View backwardView)  //子类重写该方法来处理左边按钮的点击事件
```
