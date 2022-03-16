package com.example.convertisseurdovis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public double EuDr(double eu) {
        return eu * 3.3;
    }

    public double DrEu(double dr) {
        return dr / 3.3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        Button convert = (Button) findViewById(R.id.btn);
        RadioButton conv1 = (RadioButton) findViewById(R.id.EuDr);
        RadioButton conv2 = (RadioButton) findViewById(R.id.DrEu);
        final EditText mnt = (EditText) findViewById(R.id.mnt);
        final TextView res = (TextView) findViewById(R.id.result);


        convert.setOnClickListener((x) -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            if (radioButton == conv1) {
                double mnt1 = Double.parseDouble(mnt.getText().toString());
                res.setText(String.format("%s", new DecimalFormat("##.##").format(EuDr(mnt1))));
            } else if (radioButton == conv2) {
                double mnt1 = Double.parseDouble(mnt.getText().toString());
                res.setText(String.format("%s", new DecimalFormat("##.##").format(DrEu(mnt1))));
            }

        });


    }


}