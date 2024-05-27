package com.example.btvn_checkradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String ketqua = "";
    private String []DSTien = {"USD", "EUR", "NDT"};
    Spinner spinner;
    EditText edtNhapTien, edtKetQua;
    TextView txtLoaiTien;

    Button btnDoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1,DSTien
        );

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ketqua = DSTien[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ketqua = "";
            }
        });

        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float tien;
                tien= Float.parseFloat(edtNhapTien.getText().toString());
                if(ketqua.equals("USD")){
                    tien = (float)(tien/24000);
                    Toast.makeText(MainActivity.this, "USD", Toast.LENGTH_SHORT).show();
                }else if(ketqua.equals("EUR")){
                    tien = (float)(tien/26000);
                    Toast.makeText(MainActivity.this, "EUR" + ketqua, Toast.LENGTH_SHORT).show();
                }else if(ketqua.equals("NDT")){
                    tien = (float)(tien/3000);
                    Toast.makeText(MainActivity.this, "NDT" + ketqua, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Bạn chưa chọn loại tiền tệ!" + ketqua, Toast.LENGTH_SHORT).show();
                }
                txtLoaiTien.setText(ketqua.toString());
                edtKetQua.setText(String.valueOf(tien));
            }
        });

    }

    private void initialization() {
        edtNhapTien = (EditText) findViewById(R.id.txtInput);
        edtKetQua = (EditText) findViewById(R.id.txtOutput);
        txtLoaiTien = (TextView) findViewById(R.id.txtCategory);



        //chkChietKhau = (CheckBox) findViewById(R.id.chkChietKhau);

        btnDoi = (Button) findViewById(R.id.btnDoi);

        spinner = (Spinner) findViewById(R.id.spinner);

    }
}