package ca.qc.sol_td12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {

    ConstraintLayout ex2Layout;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        ex2Layout = findViewById(R.id.ex2_layout);
        ex2Layout.setBackgroundColor(Color.GRAY);

        //init sensor manager et inscription du capteur Proximity
        sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        Sensor proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0] < 2.5)
            ex2Layout.setBackgroundColor(Color.RED);
        else
            ex2Layout.setBackgroundColor(Color.GRAY);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}