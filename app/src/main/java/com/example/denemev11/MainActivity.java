package com.example.denemev11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
EditText editText,editText2,editText3;
Button buttonRast;
Button buttonTemiz;
ImageView ımageView;
int kul1,kul2;
int artıs=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        buttonRast=(Button)findViewById(R.id.button);
        buttonTemiz=(Button)findViewById(R.id.button2);
        ımageView=(ImageView)findViewById(R.id.imageView2);
        Toast.makeText(MainActivity.this, "2 tarafın da 3 zar atma hakkı vardır. Sonrasında temizle butonuna basınız.", Toast.LENGTH_SHORT).show();
        buttonRast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number;
                Random random=new Random();
                number=random.nextInt(6)+1;//Random Fonksiyonunun kullanım biçimi---Int(Rnd()*(son deger - ilk deger)+ilk deger)
                editText.setText(String.valueOf(number));
                String resource="zar"+(String.valueOf(number));
                int id=getResources().getIdentifier(resource,"drawable",getPackageName());
                ımageView.setImageResource(id);
                artıs++;
                if(artıs==1 || artıs==3 || artıs==5)
                {
                    kul1+=number;
                    editText2.setText(String.valueOf(kul1));
                }
                else if (artıs==2 || artıs==4 || artıs==6)
                {
                    kul2+=number;
                    editText3.setText(String.valueOf(kul2));
                }
                if (artıs==6)
                {
                    if (kul1>kul2)
                    {
                        Toast.makeText(MainActivity.this, "1. oyuncu kazandı", Toast.LENGTH_SHORT).show();
                    }
                    else if (kul1<kul2)
                    {
                        Toast.makeText(MainActivity.this, "2. oyuncu kazandı", Toast.LENGTH_SHORT).show();
                    }
                    else if (kul1==kul2)
                    {
                        Toast.makeText(MainActivity.this, "Berabere", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        buttonTemiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
                artıs=0;
                kul1=0;
                kul2=0;
                ımageView.setImageResource(R.drawable.ugur);
            }
        });
    }
}
