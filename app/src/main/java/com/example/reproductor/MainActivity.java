package com.example.reproductor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play_pause;
    MediaPlayer mp;
    ImageView iv;
    TextView NA;
    TextView NC;
    int posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer[3];
    int [] imagen = {R.drawable.pt1, R.drawable.pt2, R.drawable.pt3};
    String [] NombreA = {"PanteonRococo", "Pxndx", "JoseJose"};
    String [] NombreC = {"EstaNoche", "ProcedimientosParaLlegarAunComunAcuerdo", "MiVida"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btn_play);
        iv = (ImageView)findViewById(R.id.imageView);
        NA = (TextView)findViewById(R.id.NombreA);
        NC = (TextView)findViewById(R.id.NombreC);

        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);
    }

    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            if(posicion == 0){
                NA.setText(NombreA[0]);
                NC.setText(NombreC[0]);
            } else if (posicion == 1){
                NA.setText(NombreA[1]);
                NC.setText(NombreC[1]);
            } else if (posicion == 2){
                NA.setText(NombreA[2]);
                NC.setText(NombreC[2]);
            }
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            if(posicion == 0){
                NA.setText(NombreA[0]);
                NC.setText(NombreC[0]);
            } else if (posicion == 1){
                NA.setText(NombreA[1]);
                NC.setText(NombreC[1]);
            } else if (posicion == 2){
                NA.setText(NombreA[2]);
                NC.setText(NombreC[2]);
            }
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Reproducir", Toast.LENGTH_SHORT).show();
        }
    }
    public void Stop(View view){
        if (vectormp[posicion] != null){
            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(this, R.raw.race);
            vectormp[1] = MediaPlayer.create(this, R.raw.sound);
            vectormp[2] = MediaPlayer.create(this, R.raw.tea);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.pt1);
            Toast.makeText(this, "Parar", Toast.LENGTH_SHORT).show();
        }
    }
    public void Siguiente(View view){
        if (posicion < vectormp.length -1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion ++;
                vectormp[posicion].start();

                if(posicion == 0){
                    iv.setImageResource(imagen[0]);
                    NA.setText(NombreA[0]);
                    NC.setText(NombreC[0]);
                } else if (posicion == 1){
                    iv.setImageResource(imagen[1]);
                    NA.setText(NombreA[1]);
                    NC.setText(NombreC[1]);
                } else if (posicion == 2){
                    iv.setImageResource(imagen[2]);
                    NA.setText(NombreA[2]);
                    NC.setText(NombreC[2]);
                }
            }else{
                posicion++;
                if(posicion == 0){
                    iv.setImageResource(imagen[0]);
                    NA.setText(NombreA[0]);
                    NC.setText(NombreC[0]);
                } else if (posicion == 1){
                    iv.setImageResource(imagen[1]);
                    NA.setText(NombreA[1]);
                    NC.setText(NombreC[1]);
                } else if (posicion == 2){
                    iv.setImageResource(imagen[2]);
                    NA.setText(NombreA[2]);
                    NC.setText(NombreC[2]);
                }
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(View view){
        if (posicion >= 1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion --;
                if(posicion == 0){
                    iv.setImageResource(imagen[0]);
                    NA.setText(NombreA[0]);
                    NC.setText(NombreC[0]);
                } else if (posicion == 1){
                    iv.setImageResource(imagen[1]);
                    NA.setText(NombreA[1]);
                    NC.setText(NombreC[1]);
                } else if (posicion == 2){
                    iv.setImageResource(imagen[2]);
                    NA.setText(NombreA[2]);
                    NC.setText(NombreC[2]);
                }
                vectormp[posicion].start();

            }else{
                posicion--;
                if(posicion == 0){
                    iv.setImageResource(imagen[0]);
                    NA.setText(NombreA[0]);
                    NC.setText(NombreC[0]);
                } else if (posicion == 1){
                    iv.setImageResource(imagen[1]);
                    NA.setText(NombreA[1]);
                    NC.setText(NombreC[1]);
                } else if (posicion == 2){
                    iv.setImageResource(imagen[2]);
                    NA.setText(NombreA[2]);
                    NC.setText(NombreC[2]);
                }
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}
