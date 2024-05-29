package com.example.first_application;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;import android.os.Bundle;
import android.util.Log;import android.view.View;
import android.widget.AdapterView;import android.widget.ArrayAdapter;
import android.widget.Button;import android.widget.EditText;
import android.widget.ListView;import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    private TextView mainTextView;
    private Button mainButton;
    private EditText mainEditText;
    private ListView mainListView;
    private ArrayAdapter mArrayAdapter;
    private ArrayList mNameList = new ArrayList();
    private Button ok_btn, cnc_btn;
    @SuppressLint("MissingInflatedId")
    @Override    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Set in Bass!");
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainEditText = findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);
    }
    @Override    public void onClick(View view)
    {
        mainTextView.setText(mainEditText.getText().toString()+" IS THE BEST BASSIST!!!");
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Log.d("MLG 1337", position + ":" + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()+ " is learning Bass development!");
    }
    View.OnClickListener oclBtn = new View.OnClickListener()
    {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick (View view)
        {
            if ((view.getId()) == R.id.ok_btn)
            {
                Toast.makeText(getApplicationContext(), "ХАРОШ", Toast.LENGTH_LONG).show();
            }
            if ((view.getId()) == R.id.cnc_btn)
            {
                Toast.makeText(getApplicationContext(), "ОТМЕНА", Toast.LENGTH_LONG).show();
            }
        }
    };

}