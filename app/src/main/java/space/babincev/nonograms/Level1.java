package space.babincev.nonograms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Level1 extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[5][5];
    private int[][] buttonsValues = new int[5][5];
    private int[][] rightValues = {
            {1,1,1,1,0},
            {0,1,1,1,1},
            {1,1,0,1,0},
            {1,1,1,1,1},
            {1,1,1,1,0},
    };

    int sumResult = 0;

    private TextView[] rows = new TextView[5];
    private TextView[] columns = new TextView[5];

    private String[] columnsStrings = {"1\n3","5","2\n2","5","1\n1"};
    private String[] rowsStrings = {"    4","    4","  2 1","    5","    4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_level);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //инициализация кнопок
        for (int i = 0; i < 5; ++i)
            for (int j = 0; j < 5; ++j){
                String buttonID = "b" + i + j;
                int resursID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = (Button) findViewById(resursID);
                buttons[i][j].setOnClickListener(this);
                buttonsValues[i][j] = 0;
                if (buttonsValues[i][j] != rightValues[i][j]){
                    sumResult++;
                }
            }

        //инициализация rows
        for (int i = 0; i < 5; i++){
            String textViewID = "row" + i;
            int resursID = getResources().getIdentifier(textViewID, "id", getPackageName());
            TextView textView = (TextView)findViewById(resursID);
            textView.setText(rowsStrings[i]);
        }
        //инициализация columns
        for (int i = 0; i < 5; i++){
            String textViewID = "column" + i;
            int resursID = getResources().getIdentifier(textViewID, "id", getPackageName());
            TextView textView = (TextView)findViewById(resursID);
            textView.setText(columnsStrings[i]);
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onClick(View view) {

        int i = 0;
        int j = 0;
        boolean isFound = false;
        for (i = 0; i < 5 && !isFound; ++i){
            for (j = 0; j < 5 && !isFound; ++j){
                if (buttons[i][j].equals((Button) findViewById(view.getId()))){
                    isFound = true;
                }
            }
        }
        i--;
        j--;

       if (buttonsValues[i][j] == 1){
            buttons[i][j].setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_black_border));
            buttonsValues[i][j] = 0;
       } else{
            buttons[i][j].setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_white));
            buttonsValues[i][j] = 1;
       }
        if (buttonsValues[i][j] != rightValues[i][j]){
            sumResult++;
        } else {
            sumResult--;
        }
        buttons[i][j].invalidate();
       view.invalidate();
    }
    //системная кнопка назад
    @Override
    public void onBackPressed(){
    try {
        Intent intent = new Intent(Level1.this, MainActivity.class);
        startActivity(intent);
        finish();
    }catch (Exception ignore){

    }
    }
}