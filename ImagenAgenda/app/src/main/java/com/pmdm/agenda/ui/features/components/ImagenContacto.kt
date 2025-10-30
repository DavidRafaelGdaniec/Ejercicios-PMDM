package com.pmdm.agenda.ui.features.components
import android.graphics.BitmapFactory
import com.pmdm.agenda.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pmdm.agenda.ui.theme.agendaTheme

class ImagenContacto
{
    lateinit var  painterFoto : Painter
    @Composable
    fun ImagenContacto(
        modifier: Modifier = Modifier,
        foto : ImageBitmap?,
        anchoBorde : Dp = 4.dp
    )
    {
        if (foto != null)
        {
            painterFoto = BitmapPainter(foto)
        }
        else {painterFoto = painterResource(id = R.drawable.face_2_24px)}
        Image(modifier = Modifier.clip(CircleShape).aspectRatio(ratio = 1f).background(MaterialTheme.colorScheme.surface)
            .border(width = anchoBorde, color = MaterialTheme.colorScheme.inversePrimary, shape = CircleShape),
            painter = painterFoto!!, contentScale = ContentScale.Crop, contentDescription = "Imagen contacto"
        )
    }

    @Preview
    @Composable
    fun ImagenContactoPreviewSinFoto()
    {
        agendaTheme{
            Box(Modifier.width(300.dp).height(200.dp).background(MaterialTheme.colorScheme.primary))
            {
                ImagenContacto(Modifier.fillMaxHeight(), null)
            }
        }
    }
    @Preview
    @Composable
    fun ImagenContactoPreviewConFotoyFondo()
    {
        agendaTheme {
            Box(Modifier.width(300.dp).height(200.dp).background(MaterialTheme.colorScheme.primary))
            {
                if(isSystemInDarkTheme())
                {   val bitmap = ImageBitmap.imageResource(R.drawable.foto_prueba)
                    Image(
                        modifier = Modifier.matchParentSize(),
                        painter = painterResource(R.drawable.bg_dark), contentScale = ContentScale.FillBounds,
                        contentDescription = "fondo"
                    )
                    ImagenContacto(Modifier.fillMaxHeight(), bitmap)

                }
                else
                {
                    val bitmap = ImageBitmap.imageResource(R.drawable.foto_prueba)
                    Image(
                        modifier = Modifier.matchParentSize(),
                        painter = painterResource(R.drawable.bg_light), contentScale = ContentScale.FillBounds,
                        contentDescription = "fondo"
                    )
                    ImagenContacto(Modifier.fillMaxHeight(), bitmap)
                }
            }
        }
    }
}