package edu.farmingdale.bcs371_w7_demo_nav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import edu.farmingdale.bcs371_w7_demo_nav.ui.theme.BCS371_W7_Demo_NavTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BCS371_W7_Demo_NavTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicOperations(
                        name = "Activity 1",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicOperations(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var chcked by remember { mutableStateOf(false) }


    Column {
        Spacer(modifier = Modifier.padding(50.dp))
        Button( onClick = {
            val newInt = Intent(Intent.ACTION_VIEW)
            newInt.setData(Uri.parse("geo:0,0?q=Farmingdale State College, NY"))
            context.startActivity(newInt)
        },
            enabled = chcked,
            modifier= Modifier.padding(start = 40.dp, end = 40.dp)) {
            Icon( imageVector = Icons.Default.LocationOn, contentDescription = "Location")
            Text("Show me Farmingdale", modifier = Modifier.padding(start=10.dp))
        }
        HorizontalDivider(thickness = DividerDefaults.Thickness)

        Button( onClick = {
            val newInt = Intent(Intent.ACTION_VIEW)
            // ToDo 1: create implicit intent to open a web page or call a phone number
            //done
            newInt.setData(Uri.parse("tel:6319236869"))
            context.startActivity(newInt)
        },
            enabled = chcked,
            modifier= Modifier.padding(start = 40.dp, end = 40.dp)) {
            Icon( imageVector = Icons.Default.Phone, contentDescription = "Phone")
            Text("Call Me", modifier = Modifier.padding(start=10.dp))
        }

        HorizontalDivider(thickness = DividerDefaults.Thickness)

        Button( onClick = {
            // ToDo 2: create explicit intent to open a new activity
            //done
            context.startActivity(Intent(context, MainActivity::class.java))



        },
            enabled = chcked,
            modifier= Modifier.padding(start = 40.dp, end = 40.dp)) {
            Icon( imageVector = Icons.Default.Info, contentDescription = "Phone")
            Text("Go To activity 2", modifier = Modifier.padding(start=10.dp))
        }

        // ToDo 3: Change the spacing between the icons and text to be 10dp
        //done

        // ToDo 4: Add a horizontal divider between the buttons
        //done
        HorizontalDivider(thickness = DividerDefaults.Thickness)

        // ToDo 5: This switch is not working fix it
        //done
        Switch(
            checked = chcked,
            onCheckedChange = {chcked = it},
            modifier = Modifier.padding(10.dp),
        )
        // ToDo 6: when the switch is off, disable the buttons
        //done
    }


}

@Preview(showBackground = true)
@Composable
fun BasicOperationsPreview() {
    BCS371_W7_Demo_NavTheme {
        BasicOperations("Android")
    }
}