package com.example.demoalertdialogltmtk12t;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog = null;
    private AlertDialog.Builder builder;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            showDialog(null);
            return;
        }
        this.doubleBackToExitPressedOnce = true;

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void showDialog(View view) {
        // Hiển thị Dialog tại đây
        if(alertDialog == null){
            builder = new AlertDialog.Builder(this)
                    .setTitle("Cảnh báo")
                    .setMessage("Bạn có muốn thoát khỏi ứng dụng?")
                    .setCancelable(false)
                    .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,"Hủy",Toast.LENGTH_SHORT).show();
                        }
                    })
            ;
            alertDialog = builder.create();
        }
        alertDialog.show();
    }
}