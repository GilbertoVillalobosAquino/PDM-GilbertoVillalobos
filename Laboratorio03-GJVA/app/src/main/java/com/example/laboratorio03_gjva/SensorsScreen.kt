package com.example.laboratorio03_gjva

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SensorsScreen(navController: NavController) {

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0b101b),
            Color(0xFF232945)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient)
    ) {

        Column {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Volver")
            }

            GyroscopeSensor()
        }
    }
}

@Composable
fun GyroscopeSensor() {

    val gyroscopeValues = useSensor(Sensor.TYPE_GYROSCOPE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Giroscopio",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "X: ${gyroscopeValues[0]}",
            fontSize = 20.sp,
            color = Color.White
        )

        Text(
            text = "Y: ${gyroscopeValues[1]}",
            fontSize = 20.sp,
            color = Color.White
        )

        Text(
            text = "Z: ${gyroscopeValues[2]}",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun useSensor(sensorType: Int): FloatArray {

    val context = LocalContext.current
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    val sensorValues = remember {
        mutableStateOf(floatArrayOf(0f, 0f, 0f))
    }

    DisposableEffect(sensorType) {

        val sensor = sensorManager.getDefaultSensor(sensorType)

        val listener = object : SensorEventListener {

            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    sensorValues.value = it.values.clone()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }
        }

        sensor?.also {
            sensorManager.registerListener(
                listener,
                it,
                SensorManager.SENSOR_DELAY_UI
            )
        }

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    return sensorValues.value
}

@Preview(showBackground = true)
@Composable
fun SensorsScreenPreview() {
    SensorsScreen(navController = rememberNavController())
}
