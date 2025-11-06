package com.pmdm.dialogos.composables

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerFecha(mostrarDatePicker : Boolean,fecha: (String) -> Unit) {
    var datePicker: Boolean by remember { mutableStateOf(mostrarDatePicker) }
    val datePickerState = rememberDatePickerState()
    if (datePicker) {
        DatePickerDialog(
            onDismissRequest = { datePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (datePickerState.selectedDateMillis != null) {
                            val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy")
                            val calendar = Calendar.getInstance()
                            calendar.timeInMillis = datePickerState.selectedDateMillis!!
                            val fechaString = formatter.format(calendar.time)
                            fecha(fechaString)
                        }
                        datePicker = false
                    }
                ) {
                    Text("Añadir fecha")
                }

            },


        ) {
            DatePicker(state = datePickerState)
        }
    }
}