package app.qadheeb.fatimah.quizapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private Editable getTextAnswerQuestionTwo;
    private EditText textAnswerQuestionTwo;
    private EditText textAnswerQuestionFour;
    private TextView legsNumTextView;
    private int legsNumberAnswer = 0;
    private RadioButton hasCheckedTrueRadioButton;
    private RadioButton hasCheckedFalseRadioButton;
    private CheckBox hasCheckedFish;
    private CheckBox hasCheckedShark;
    private CheckBox hasCheckedAnt;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAnswerQuestionTwo = (EditText) findViewById(R.id.edit_text_answer_question_two);
        legsNumTextView = (TextView) findViewById(R.id.legs_num_text_view);
        hasCheckedTrueRadioButton = (RadioButton) findViewById(R.id.trueRadioButton);
        hasCheckedFalseRadioButton = (RadioButton) findViewById(R.id.falseRadioButton);
        hasCheckedFish = (CheckBox) findViewById(R.id.fish_check_box);
        hasCheckedShark = (CheckBox) findViewById(R.id.shark_check_box);
        hasCheckedAnt = (CheckBox) findViewById(R.id.ant_check_box);
        getTextAnswerQuestionTwo = textAnswerQuestionTwo.getText();
    }
    public void increment(View view) {
        legsNumberAnswer++;
        legsNumTextView.setText(String.valueOf(legsNumberAnswer));
    }
    public void decrement(View view) {
        if (legsNumberAnswer == 0) {
            return;
        }
        legsNumberAnswer--;
        legsNumTextView.setText(String.valueOf(legsNumberAnswer));
    }
    public void submitButton(View view) {
        result = 0;

        if (hasCheckedTrueRadioButton.isChecked()) {
            result++;
        }
        if ("giraffe".equals(getTextAnswerQuestionTwo.toString())) {
            result++;
        }
        if (legsNumTextView.getText() == "8") {
            result++;
        }
        if (hasCheckedFish.isChecked() && hasCheckedShark.isChecked() && hasCheckedAnt.isChecked()==false) {
            result++;
        }

        switch (result) {
            case 1:
                Toast.makeText(this, "Needs Improvement, you have got 1 out 4", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Fair, you have got 2 out 4", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Good, you have got 3 out 4", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Excellent, you have got 4 out 4", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "YOU HAVE FAILED", Toast.LENGTH_SHORT).show();
        }
    }
    public void resetButton(View view) {
        legsNumberAnswer = 0;
        hasCheckedTrueRadioButton.setChecked(false);
        hasCheckedFalseRadioButton.setChecked(false);
        hasCheckedFish.setChecked(false);
        hasCheckedShark.setChecked(false);
        hasCheckedAnt.setChecked(false);
        textAnswerQuestionTwo.setText("");
        legsNumTextView.setText("0");
    }
}

