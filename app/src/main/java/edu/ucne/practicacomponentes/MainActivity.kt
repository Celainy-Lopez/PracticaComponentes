package edu.ucne.practicacomponentes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import edu.ucne.practicacomponentes.ui.theme.PracticaComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        ConstraintLayout {
            val (button, text) = createRefs()

            Button(
                onClick = { },
                modifier = Modifier.constrainAs(button) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
            ) { }
        }

        Column(Modifier.padding(8.dp)) {
            Text(text = "Celainy Lopez")
            Text(text = "Celainy Lopez", color = Color.Green)
            Text(text = "Celainy Lopez", fontWeight = FontWeight.ExtraBold)
            Text(text = "Celainy Lopez", fontWeight = FontWeight.Light)
            Text(text = "Celainy Lopez", style = TextStyle(fontFamily = FontFamily.Cursive))

            Text(
                text = "Celainy Lopez",
                textDecoration = TextDecoration.Underline
            )


            Text(
                text = "Celainy Lopez",
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        }
    }
}

@Composable
fun MyButton() {
    Button(
        onClick = {}
    ) {
        Text(text = "My Button")
    }

    TextButton(
        onClick = {}
    ) {
        Text(text = "Cancelar")
    }

    OutlinedButton(
        onClick = {}
    ) {
        Text(text = "Añadir")
    }

    IconButton(
        onClick = {}
    ) {
        Icon(
            Icons.Filled.Share,
            contentDescription = "Compartir"
        )
    }
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        placeholder = { Text("Ingrese") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {}
        ),
        modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        placeholder = { Text("Ingrese") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {}
        ),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.unclebob),
        contentDescription = "Uncle bob",
        modifier = Modifier
            .clip(CircleShape)
    )
}


@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Default.ThumbUp,
        contentDescription = "MyIcon",
        modifier = modifier.clip(CircleShape)
    )
    Column {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(4.dp))
        LinearProgressIndicator()
    }
}


@Composable
fun MyCheckBox() {
    var acepto by remember {
        mutableStateOf(false)
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = acepto,
            onCheckedChange = { acepto = !acepto }
        )
        Text(text = "Acepto el reto Jetpack Compose")
    }

}

@Composable
fun MySwitch() {
    var acepto by remember {
        mutableStateOf(false)
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = acepto,
            onCheckedChange = { acepto = !acepto }
        )
        Text(text = "Reto Jetpack Compose aceptado")
    }
}


@Composable
fun MyRadioButtons() {
    val opciones = listOf("Todos", "Hombres", "Mujeres")
    var seleccionado by remember { mutableStateOf("") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        opciones.forEach { item ->
            RadioButton(
                selected = item == seleccionado,
                onClick = { seleccionado = item }
            )
            Text(text = "item")
        }
    }
}

@Composable
fun MyComboBox() {
    val ciudades = listOf("SFM", "Nagua", "Castillo")
    var ciudadSeleccionada by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        OutlinedTextField(
            label = { Text(text = "Ciudad") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Desplegar opciones"
                )
            },
            value = ciudadSeleccionada,
            onValueChange = { ciudadSeleccionada = it },
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expandido = true
                    Log.e("tag", "expandio")

                }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            ciudades.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        expandido = false
                        ciudadSeleccionada = item
                    },
                    text = { Text(text = item) },
                )
            }
        }
    }
}

@Composable
fun MyCard() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp))
        {
            MyCheckBox()
            Spacer(modifier = Modifier.height(8.dp))
            MySwitch()

        }
    }
}

@Composable
fun MyDialog() {
    var dialogoVisible by remember { mutableStateOf(true) }

    if (dialogoVisible) {
        AlertDialog(
            onDismissRequest = { dialogoVisible = false },
            title = { Text("Titulo de dialogo") },
            text = {
                Text("¿Seguro que desea salir de la aplicación?")
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogoVisible = false
                }) { Text(text = "Aceptar") }
            },

            dismissButton = {
                TextButton(onClick = {
                    dialogoVisible = false
                }) { Text(text = "Cancelar") }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticaComponentesTheme {
        Greeting("Android")
    }
}