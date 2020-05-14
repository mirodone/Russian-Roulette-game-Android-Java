package ro.mirodone.russianroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Button mButton;
    TextView mTextView;

    List<String> bullets;
    boolean shuffled= true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image_main);
        mButton = findViewById(R.id.btn_shoot);
        mTextView = findViewById(R.id.tv_output);

        bullets = new ArrayList<>();
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("NO");
        bullets.add("YES");

       // Collections.shuffle(bullets);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //roll the barrel
                Collections.shuffle(bullets);
                mImageView.setImageResource(R.drawable.ic_gun);
                shuffled =true;
                mTextView.setText(getString(R.string.image_shoot));
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentBullet = bullets.get(0);

                if(shuffled){
                    if(currentBullet.equals("YES")){
                        mImageView.setImageResource(R.drawable.ic_gun_bang);
                        mTextView.setText(getString(R.string.you_dead));
                    }else {
                        mImageView.setImageResource(R.drawable.ic_gun_click);
                        mTextView.setText(getString(R.string.you_alive));
                    }
                    shuffled =false;
                }else {
                    mTextView.setText(getString(R.string.roll_barrel));
                }

            }
        });


    }
}
