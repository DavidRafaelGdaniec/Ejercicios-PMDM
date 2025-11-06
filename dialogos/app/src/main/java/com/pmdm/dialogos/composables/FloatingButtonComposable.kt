package com.pmdm.dialogos.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingActionButtonElevation(texto: (String) -> Unit) {
    var textoEscrito by remember { mutableStateOf("") }
    var mostrarDialogoF by remember { mutableStateOf(false) }
    var mostrarDialogoD by remember { mutableStateOf(false) }
    var fechaSeleccionada by remember { mutableStateOf("") }
    FloatingActionButton(onClick = { mostrarDialogoF = true })
    {
        Icon(Icons.Default.Add, contentDescription = "Añadir tarea")
    }
    if (mostrarDialogoF) {
        AlertDialog(
            onDismissRequest = { mostrarDialogoF = false },
            title = { Text("Añadir tarea") },
            text = {
                Column {
                    TextButton(onClick = { mostrarDialogoD = true }) {
                        Text("Añadir fecha")
                    }
                    OutlinedTextField(
                        value = textoEscrito,
                        onValueChange = { textoEscrito = it },
                        label = { Text("Escribe una tarea") }
                    )
                }

                if (mostrarDialogoD) {
                    DatePickerFecha(mostrarDialogoD, { fecha ->
                        fechaSeleccionada = fecha
                    })
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    if (fechaSeleccionada.isNotEmpty()) {
                        textoEscrito = textoEscrito + " - " + fechaSeleccionada
                    } else {
                        textoEscrito += " Sin fecha"
                    }
                    texto(textoEscrito)
                    mostrarDialogoF = false
                    mostrarDialogoD = false
                    textoEscrito = ""
                    fechaSeleccionada = ""
                })

                {
                    Text("Guardar tarea")
                }

            },
            dismissButton = {
                TextButton(onClick = { mostrarDialogoF = false }) {
                    Text("Cancelar")
                }
            }

        )

    }


}
