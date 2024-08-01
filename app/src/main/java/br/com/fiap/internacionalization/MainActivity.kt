package br.com.fiap.internacionalization

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.internacionalization.ui.theme.InternacionalizationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InternacionalizationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    val maxSize = 8

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                        .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 35.sp,
                    color = Color(0xFF2196F3),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.subtitle),
                    fontSize = 15.sp
                )
                Spacer(
                    modifier = Modifier
                                .height(15.dp)
                )
                OutlinedTextField(
                    value = "$email",
                    modifier = Modifier
                                .fillMaxWidth(),
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    isError = emailError
                )
                if (emailError) {
                    Text(
                        text = "O email é obrigatório!",
                        fontSize = 14.sp,
                        color = Color.Red,
                        modifier = Modifier
                                    .fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
                OutlinedTextField(
                    value = "$password",
                    modifier = Modifier
                                .fillMaxWidth(),
                    onValueChange = {
                        if (it.length <= 8) {
                            password = it
                        }
                    },
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
                Spacer(
                    modifier = Modifier
                                .height(15.dp)
                )
                Button(
                    onClick = {
                        if (email.isEmpty()) {
                            emailError = true;
                        } else {
                            emailError = false;
                        }
                    },
                    modifier = Modifier
                                .fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.enter))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    InternacionalizationTheme {
        Greeting()
    }
}