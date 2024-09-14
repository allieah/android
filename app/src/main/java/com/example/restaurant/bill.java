package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class bill extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button cancel;
    private Button pay;
    private TextView itemsTextView;
    private TextView taxTextView;
    private TextView totalTextView;
    private EditText nameEditText;
    private EditText phoneEditText;
    private Spinner paymentSpinner;
    String[] payment;
    double total=0.0;
    String[] iconTitle={
            "French fries", "nacho","sandwich"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        itemsTextView = findViewById(R.id.items_text_view);
        taxTextView = findViewById(R.id.tax_text_view);
        totalTextView = findViewById(R.id.total_text_view);
        nameEditText = findViewById(R.id.name_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        paymentSpinner = findViewById(R.id.spinner);

        // Set up the payment spinner


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.payment,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentSpinner.setAdapter(adapter);
        paymentSpinner.setOnItemSelectedListener( this);


        // Get the bundle data passed from the previous activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ArrayList<String> itemNames = bundle.getStringArrayList("itemNames");
            ArrayList<Integer> itemPrices = bundle.getIntegerArrayList("itemPrices");

            // Display the items and their prices in the bill
            StringBuilder itemsString = new StringBuilder();
            double totalPrice = 0;
            for (int i = 0; i < itemNames.size(); i++) {
                itemsString.append(itemNames.get(i)).append(": Rs. ").append(itemPrices.get(i)).append("\n");
                totalPrice += itemPrices.get(i);
            }
            itemsTextView.setText(itemsString.toString());

            // Calculate and display the tax and total amount
            double tax = totalPrice * 0.1;
            total = totalPrice + tax;
            taxTextView.setText("Tax: Rs. " + String.format("%.2f", tax));
            totalTextView.setText(" Rs. " + String.format("%.2f", total));
        }

        pay=findViewById(R.id.pay1);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                Intent c=new Intent(getApplicationContext(),splash_screen.class);
                c.putExtra("Customer name", name);
//                c.putExtra("itemPrices", itemPricesAdded);
               c.putExtra("Total Price=", total);

                startActivity(c);

            }
        });

        cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i1=new Intent (getApplicationContext(),MainActivity2.class);
                startActivity(i1);
                Toast.makeText(getApplicationContext(),"mainpage", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}