package space.babincev.nonograms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //переход на 1ый уровень
        Button level1 = (Button)findViewById(R.id.button_level_1);
        level1.setOnClickListener(view -> {
            try{
                Intent intent = new Intent(MainActivity.this, Level1.class);
                startActivity(intent);
                finish();
            } catch (Exception ignored){

            }
        });
    }
}