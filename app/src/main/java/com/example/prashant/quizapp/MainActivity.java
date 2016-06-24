package com.example.prashant.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  int currentScore;
  EditText questOneEditText;
  RadioGroup questionTwoRadioGroup;
  RadioGroup questionThreeRadioGroup;
  RadioGroup questionFiveRadioGroup;
  CheckBox optionOne;
  CheckBox optionTwo;
  CheckBox optionThree;
  CheckBox optionFour;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    currentScore = 0;
    questOneEditText = (EditText) findViewById(R.id.questionOneEditText);
    questionTwoRadioGroup = (RadioGroup) findViewById(R.id.question_two_radio_group);
    questionThreeRadioGroup = (RadioGroup) findViewById(R.id.question_three_radio_group);
    questionFiveRadioGroup = (RadioGroup) findViewById(R.id.question_five_radio_group);
    optionOne = (CheckBox) findViewById(R.id.checkbox_option_one);
    optionTwo = (CheckBox) findViewById(R.id.checkbox_option_two);
    optionThree = (CheckBox) findViewById(R.id.checkbox_option_three);
    optionFour = (CheckBox) findViewById(R.id.checkbox_option_four);
  }

  public void checkScore(View view) {
    int viewID = view.getId();
    if (viewID == R.id.submitBtn) {
      checkAnswersAndUpdateScore();
      Toast.makeText(this, "Your score: " + currentScore, Toast.LENGTH_LONG).show();
      resetViewAndScore();
    }
  }

  private void resetViewAndScore() {
    currentScore = 0;
    questOneEditText.setText("");
    questionTwoRadioGroup.clearCheck();
    questionThreeRadioGroup.clearCheck();
    questionFiveRadioGroup.clearCheck();
    if (optionOne.isChecked()) optionOne.setChecked(false);
    if (optionTwo.isChecked()) optionTwo.setChecked(false);
    if (optionThree.isChecked()) optionThree.setChecked(false);
    if (optionFour.isChecked()) optionFour.setChecked(false);
  }

  private void checkAnswersAndUpdateScore() {
    if (checkAnswerOfFirstQuestion()) currentScore++;
    if (checkAnswerOfSecondQuestion()) currentScore++;
    if (checkAnswerOfThirdQuestion()) currentScore++;
    if (checkAnswerOfFourthQuestion()) currentScore++;
    if (checkAnswerOfFifthQuestion()) currentScore++;
  }

  private boolean checkAnswerOfFirstQuestion() {
    String correctAnswer = getResources().getString(R.string.answer_one);
    String userAnswer = questOneEditText.getText().toString();
    if (correctAnswer.equalsIgnoreCase(userAnswer)) {
      return true;
    }
    return false;
  }

  private boolean checkAnswerOfSecondQuestion() {
    int checkedRadioId = questionTwoRadioGroup.getCheckedRadioButtonId();
    if (checkedRadioId == R.id.radio_question_two_option_one) return true;
    return false;
  }

  private boolean checkAnswerOfThirdQuestion() {
    int checkedRadioId = questionThreeRadioGroup.getCheckedRadioButtonId();
    if (checkedRadioId == R.id.radio_question_three_option_one) return true;
    return false;
  }

  private boolean checkAnswerOfFourthQuestion() {
    if (optionOne.isChecked()
        && optionTwo.isChecked()
        && !optionThree.isChecked()
        && !optionFour.isChecked()) {
      return true;
    }
    return false;
  }

  private boolean checkAnswerOfFifthQuestion() {
    int checkedRadioId = questionFiveRadioGroup.getCheckedRadioButtonId();
    if (checkedRadioId == R.id.radio_question_five_option_one) return true;
    return false;
  }
}
