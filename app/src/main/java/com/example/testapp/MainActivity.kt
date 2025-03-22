package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = getString(R.string.app_name),
                        modifier = Modifier.padding(innerPadding)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Counter()
                        Counter()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello H",
        modifier = modifier
    )
}

@Composable
fun Counter(){
    var counterValue = remember {
        mutableIntStateOf(0)
    }
    Card {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(value = counterValue.intValue.toString(), onValueChange = {counterValue.intValue = 0})
            Row {
                Button(onClick = {counterValue.intValue = (counterValue.intValue+1)}) {
                    Text(text = "Увеличить")
                }
                Button(onClick = {counterValue.intValue = (counterValue.intValue-1)}) {
                    Text(text = "Уменьшить")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAppTheme {
        Greeting("Android")
    }
}