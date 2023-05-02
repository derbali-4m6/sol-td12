package ca.qc.sol_td12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class SensorListActivity extends AppCompatActivity {

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        //init
        sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        Log.d("Sensor", "Il y a " + sensors.size() + " capteurs trouvés");
        for (Sensor sensor: sensors) {
            Log.d("Sensor", "Nom: " + sensor.getName() + ", Vendeur: " + sensor.getVendor() + ", Version: " + sensor.getVersion());
        }
    }

    public void allerEx2(View view) {
        startActivity(new Intent(this, ProximityActivity.class));
    }
}