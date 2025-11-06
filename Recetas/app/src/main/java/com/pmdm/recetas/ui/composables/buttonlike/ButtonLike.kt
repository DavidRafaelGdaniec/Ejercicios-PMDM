package com.pmdm.recetas.ui.composables.buttonlike

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.recetas.R
import com.pmdm.recetas.ui.theme.RecetasTheme
import java.sql.SQLIntegrityConstraintViolationException


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonLike(
    iLike: Boolean,             // Estado que indica si se ha pulsado like o no.
    numberOfLikes: Int,         // Número de likes que llevamos.
    onILikePressed: () -> Unit  // Función que se ejecutará cuando se pulse el botón.
) {
    Box(Modifier.size(50.dp), contentAlignment = Alignment.Center)
    {
        IconButton(
            onClick = onILikePressed,
            modifier = Modifier
                .clip(shape = ButtonDefaults.shape)
                .background(color = ButtonDefaults.buttonColors().containerColor)
        )
        {
            val colores = if (iLike) Color.Red else Color.White
            Icon(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Botón de like",
                tint = colores
            )

        }
        Badge(Modifier
            .align(Alignment.BottomEnd)) {
            Text(text = if (numberOfLikes > 99) "99+" else numberOfLikes.toString())
        }
    }
}

@Preview
@Composable
fun ButtonLikePreview() {
    RecetasTheme {
        Row {
            ButtonLike(false, 5, {})
            ButtonLike(true, 100, {})
        }
    }
}
