package com.example.responsive.Views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.responsive.components.FormTextField
import com.example.responsive.components.TopBanner
import com.example.responsive.viewModel.AppModel

@Composable
fun RegisterCompact(
    navController: NavController,
    viewModel: AppModel
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBanner()

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FormTextField(
                value = viewModel.fullName.value,
                onValueChange = { viewModel.fullName.value = it },
                label = "Full name",
                placeholder = "Ej: Marcel Roquet"
            )

            FormTextField(
                value = viewModel.birthDate.value,
                onValueChange = { viewModel.birthDate.value = it },
                label = "Birth Day",
                placeholder = "DD/MM/AAAA",
                keyboardType = KeyboardType.Number
            )

            FormTextField(
                value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it },
                label = "Email",
                placeholder = "example@email.com",
                keyboardType = KeyboardType.Email
            )

            FormTextField(
                value = viewModel.phone.value,
                onValueChange = { viewModel.phone.value = it },
                label = "Tel",
                placeholder = "123456789",
                keyboardType = KeyboardType.Phone
            )

            FormTextField(
                value = viewModel.username.value,
                onValueChange = { viewModel.username.value = it },
                label = "UserName",
                placeholder = "juanperez"
            )

            // Password
            FormTextField(
                value = viewModel.password.value,
                onValueChange = { viewModel.password.value = it },
                label = "Password",
                isPassword = true
            )

            // Confirmar password
            FormTextField(
                value = viewModel.confirmPassword.value,
                onValueChange = { viewModel.confirmPassword.value = it },
                label = "confirm password",
                isPassword = true
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = viewModel.acceptTerms.value,
                    onCheckedChange = { viewModel.acceptTerms.value = it }
                )
                Text(
                    text = "I accept the terms and conditions",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {

                    val error = viewModel.validateRegister()
                    if (error.isEmpty()) {
                        navController.navigate("ConfirmationView")
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Registrarse")
            }

            if (viewModel.errorMessage.value.isNotEmpty()) {
                Text(
                    text = viewModel.errorMessage.value,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }


            TextButton(onClick = {
                navController.navigate("LoginViewCompact")
            }) {
                Text("LogIn")
            }
        }
    }
}