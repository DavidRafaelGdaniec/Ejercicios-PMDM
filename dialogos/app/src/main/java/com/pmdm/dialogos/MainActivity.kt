package com.pmdm.dialogos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.dialogos.composables.FloatingActionButtonElevation
import com.pmdm.dialogos.composables.Tareas
import com.pmdm.dialogos.ui.theme.dialogosTheme
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            dialogosTheme {
                MainScreen()
            }
        }
    }
    @Preview
    @Composable
    fun FloatingActionButtonElevationPreview()
    {
        FloatingActionButtonElevation { texto -> texto }
    }
    @Preview
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        var textoRecordado by remember { mutableStateOf("Tarea 1\nTarea 2\nTarea3\n") }
        dialogosTheme {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                 floatingActionButton = {
                     FloatingActionButtonElevation { nuevaTarea ->
                         textoRecordado += nuevaTarea + "\n"
                     }
                 },
                floatingActionButtonPosition = FabPosition.Center
            )
            { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                ) {
                    Tareas(textoRecordado)
                }
            }
        }


    }
}