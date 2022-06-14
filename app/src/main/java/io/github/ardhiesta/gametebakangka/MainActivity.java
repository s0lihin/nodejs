package io.github.ardhiesta.gametebakangka;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnTebak;
    EditText etAngka;
    int angkaRandom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTebak = (Button) findViewById(R.id.btnTebak);
        etAngka = (EditText) findViewById(R.id.etAngka);
        angkaRandom = buatAngkaRandom(1, 3);
        btnTebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etAngka.equals("")) {
                    tebakAngka();
                }
            }
        });
    }

    private void tebakAngka(){
        int angkaTebakan = Integer.parseInt(etAngka.getText().toString());
        if (angkaTebakan == angkaRandom){
            tampilkanPopup("tebakan anda benar");
        } else {
            tampilkanPopup("Tebakan anda salah");
        }
        angkaRandom = buatAngkaRandom(1, 3);
    }

    private int buatAngkaRandom(int angkaMin, int angkaMax){
        Random rand = new Random();
        int randomNum = rand.nextInt(angkaMax - angkaMin) + angkaMin;
        return randomNum;
    }

    private void tampilkanPopup(String pesan){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(pesan+", jawaban : "+angkaRandom).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etAngka.setText("");
            }
        });

        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
