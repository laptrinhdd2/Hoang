package android2.team2.exe4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BaiHat> danhSachBaiHat;
    int viTri = 0;
    MediaPlayer mediaPlayer;
    TextView txtTenBaiHat;
    TextView txtBatDau;
    TextView txtKetThuc;
    SeekBar seekBar;
    ImageButton imgPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get view from layout
        txtTenBaiHat = (TextView) findViewById(R.id.txtTenBaiHat);
        txtBatDau = (TextView) findViewById(R.id.timeStart);
        txtKetThuc = (TextView) findViewById(R.id.timeEnd);
        seekBar = (SeekBar) findViewById(R.id.seekBarBaiHat);
        final ImageButton imgBack = (ImageButton) findViewById(R.id.imgBack);
        final ImageButton imgNext = (ImageButton) findViewById(R.id.imgNext);
        final ImageButton imgStop = (ImageButton) findViewById(R.id.imgStop);
        imgPlay = (ImageButton) findViewById(R.id.imgPlay);

        //them bai hat vao list
        danhSachBaiHat = new ArrayList<>();
        danhSachBaiHat.add(new BaiHat("Em Sẽ Là Cô Dâu", R.raw.emselacodau));
        danhSachBaiHat.add(new BaiHat("Duyên Mình Lỡ", R.raw.duyenminhlo));
        danhSachBaiHat.add(new BaiHat("Em Vẫn Chưa Về", R.raw.emvanchuave));
        danhSachBaiHat.add(new BaiHat("Hồng Nhan", R.raw.hongnha));
        danhSachBaiHat.add(new BaiHat("Mùi Hương Ấy", R.raw.muihuongay));


        //khoi tao mediaPlayer
        intallMediaPlayer();

        //bắt sự kiện button pause khi nhan chuyen play
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){//mac idnh la true
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.pause);
                }else{
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.play);
                }
                setTimeBaiHat();
                updateTimeStart();
            }
        });

        //stop
        imgStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();//giai phong vung nho khi do
                imgPlay.setImageResource(R.drawable.pause);
                intallMediaPlayer();
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viTri++;
                if(viTri > danhSachBaiHat.size() - 1){
                    viTri = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                intallMediaPlayer();
                mediaPlayer.start();
                imgPlay.setImageResource(R.drawable.play);
                setTimeBaiHat();
                updateTimeStart();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viTri--;
                if(viTri < 0){
                    viTri = danhSachBaiHat.size() - 1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                intallMediaPlayer();
                mediaPlayer.start();
                imgPlay.setImageResource(R.drawable.play);
                setTimeBaiHat();
                updateTimeStart();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //tha ra moi play
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


    }

    //function plaing bai hat
    private void intallMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, danhSachBaiHat.get(viTri).getFileBaiHat());
        txtTenBaiHat.setText(danhSachBaiHat.get(viTri).getTenBaiHat());
        //gan max cua seekbar = media.duration
        seekBar.setMax(mediaPlayer.getDuration());

    }

    //tinh thoi gian cua bai hat
    private void setTimeBaiHat() {
        SimpleDateFormat dinhDangTimeBaiHat = new SimpleDateFormat("mm:ss");
        txtKetThuc.setText(dinhDangTimeBaiHat.format(mediaPlayer.getDuration()));
    }

    //thay doi thoi gian text thoi gian da hat
    private void updateTimeStart(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdangThoiGian = new SimpleDateFormat("mm:ss");
                txtBatDau.setText(dinhdangThoiGian.format(mediaPlayer.getCurrentPosition()));
                //update thanh seekbar
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                //kiem tra bai hat da ket thuc chua va chuyen dang bai hat tiep theo
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        viTri++;
                        if(viTri > danhSachBaiHat.size() - 1){
                            viTri = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        intallMediaPlayer();
                        mediaPlayer.start();
                        imgPlay.setImageResource(R.drawable.play);
                        setTimeBaiHat();
                        updateTimeStart();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }
}
