package com.example.bt_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtSoLuong, edtDonGia, edtThanhTien;
    CheckBox chkVip;
    RadioButton rdoNam, rdoNu;
    Button btnThanhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float donGia = Float.parseFloat(edtDonGia.getText().toString());
                int sl = Integer.parseInt(edtSoLuong.getText().toString());
                float thanhtien = donGia*sl;

                if(chkVip.isChecked() || rdoNu.isChecked()){
                    thanhtien = (float) (thanhtien*0.9);
                }

                edtThanhTien.setText(String.valueOf(thanhtien));
            }
        });

    }

    private void initialization() {
            edtTen = (EditText) findViewById(R.id.txtTenkh);
            edtSoLuong = (EditText) findViewById(R.id.txtSL);
            edtDonGia= (EditText) findViewById(R.id.txtDonGia);
            edtThanhTien= (EditText) findViewById(R.id.txtThanhTien);
            chkVip = (CheckBox) findViewById(R.id.chkVip);
            rdoNam = (RadioButton) findViewById(R.id.rdoNam);
            rdoNu = (RadioButton) findViewById(R.id.rdoNu);
            btnThanhToan = (Button) findViewById(R.id.btnThanhToan);
    }

}