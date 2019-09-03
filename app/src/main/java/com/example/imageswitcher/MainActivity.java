package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
Button button;
ImageSwitcher imageSwitcher;
int imid[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.l};
int count=imid.length;
int ci=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.next);
        imageSwitcher=findViewById(R.id.sis);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked Next", Toast.LENGTH_SHORT).show();
                ci++;
                if (ci==count)
                    ci=0;
                imageSwitcher.setImageResource(imid[ci]);

            }
        });
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //create a new ImageView and set it's properties
                ImageView iv=new ImageView(getApplicationContext());
                //set scale type of ImageView to Fit center
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //set the Height and width of ImageView To Fill PARENT
                iv.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));

                return iv;
            }
        });

        //Declare in and out animations and load them using AnimationUtils class
        Animation in= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out=AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        //set the animation type to ImageSwitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

    }
}
