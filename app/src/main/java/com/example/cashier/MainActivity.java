package com.example.cashier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText withdrawAmountInput;
    private TextView notes100Label, notes50Label, notes10Label, notes1Label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        withdrawAmountInput = findViewById(R.id.withdraw_amount_input);
        notes100Label = findViewById(R.id.notes_100_label);
        notes50Label = findViewById(R.id.notes_50_label);
        notes10Label = findViewById(R.id.notes_10_label);
        notes1Label = findViewById(R.id.notes_1_label);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = Integer.parseInt(withdrawAmountInput.getText().toString());
                int[] notes = calculateCurrencyNotes(amount);
                notes100Label.setText("Number of 100 notes: " + notes[3]);
                notes50Label.setText("Number of 50 notes: " + notes[2]);
                notes10Label.setText("Number of 10 notes: " + notes[1]);
                notes1Label.setText("Number of 1 notes: " + notes[0]);
            }
        });
    }

    private int[] calculateCurrencyNotes(int amount) {
        int[] notes = new int[4];
        notes[3] = amount / 100;
        amount %= 100;
        notes[2] = amount / 50;
        amount %= 50;
        notes[1] = amount / 10;
        amount %= 10;
        notes[0] = amount;
        return notes;
    }
}
