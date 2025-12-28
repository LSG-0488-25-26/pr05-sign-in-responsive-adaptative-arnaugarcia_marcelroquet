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

    BoxWithConstraints {
        if (maxWidth < 412.dp) { // Si la pantalla del disp té menys de 412 px d’ample
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TopBanner(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    //  Nom
                    FormTextField(
                        value = viewModel.fullName.value,
                        onValueChange = { viewModel.fullName.value = it },
                        label = "Full name",
                        placeholder = "Ej: Marcel Roquet",
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Aniversari
                    FormTextField(
                        value = viewModel.birthDate.value,
                        onValueChange = { viewModel.birthDate.value = it },
                        label = "Birth Date",
                        placeholder = "DD/MM/AAAA",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Email
                    FormTextField(
                        value = viewModel.email.value,
                        onValueChange = { viewModel.email.value = it },
                        label = "Email",
                        placeholder = "example@email.com",
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Tel
                    FormTextField(
                        value = viewModel.phone.value,
                        onValueChange = { viewModel.phone.value = it },
                        label = "Phone",
                        placeholder = "123456789",
                        keyboardType = KeyboardType.Phone,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Username
                    FormTextField(
                        value = viewModel.username.value,
                        onValueChange = { viewModel.username.value = it },
                        label = "Username",
                        placeholder = "marcelfs",
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Password
                    FormTextField(
                        value = viewModel.password.value,
                        onValueChange = { viewModel.password.value = it },
                        label = "Password",
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Confirm Password
                    FormTextField(
                        value = viewModel.confirmPassword.value,
                        onValueChange = { viewModel.confirmPassword.value = it },
                        label = "Confirm Password",
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    // termins per acceptar
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = viewModel.acceptTerms.value,
                            onCheckedChange = { viewModel.acceptTerms.value = it },
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "I accept the terms and conditions",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            val error = viewModel.validateRegister()
                            if (error.isEmpty()) {
                                navController.navigate("ConfirmationView")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(48.dp)
                    ) {
                        Text("Register")
                    }
                    // si falten camps surt el primer que falta
                    if (viewModel.errorMessage.value.isNotEmpty()) {
                        Text(
                            text = viewModel.errorMessage.value,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    // enllaç al logIn
                    TextButton(
                        onClick = { navController.navigate("LoginViewCompact") },
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text("Log in")
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TopBanner(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    //  Nom
                    FormTextField(
                        value = viewModel.fullName.value,
                        onValueChange = { viewModel.fullName.value = it },
                        label = "Full name",
                        placeholder = "Ej: Marcel Feliu",
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Aniversari
                    FormTextField(
                        value = viewModel.birthDate.value,
                        onValueChange = { viewModel.birthDate.value = it },
                        label = "Birth Date",
                        placeholder = "DD/MM/AAAA",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Email
                    FormTextField(
                        value = viewModel.email.value,
                        onValueChange = { viewModel.email.value = it },
                        label = "Email",
                        placeholder = "example@email.com",
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Tel
                    FormTextField(
                        value = viewModel.phone.value,
                        onValueChange = { viewModel.phone.value = it },
                        label = "Phone",
                        placeholder = "123456789",
                        keyboardType = KeyboardType.Phone,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Username
                    FormTextField(
                        value = viewModel.username.value,
                        onValueChange = { viewModel.username.value = it },
                        label = "Username",
                        placeholder = "marcelfs",
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Password
                    FormTextField(
                        value = viewModel.password.value,
                        onValueChange = { viewModel.password.value = it },
                        label = "Password",
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Confirm Password
                    FormTextField(
                        value = viewModel.confirmPassword.value,
                        onValueChange = { viewModel.confirmPassword.value = it },
                        label = "Confirm Password",
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    // termins per acceptar
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = viewModel.acceptTerms.value,
                            onCheckedChange = { viewModel.acceptTerms.value = it },
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "I accept the terms and conditions",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            val error = viewModel.validateRegister()
                            if (error.isEmpty()) {
                                navController.navigate("ConfirmationView")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(48.dp)
                    ) {
                        Text("Register")
                    }
                    // si falten camps surt el primer que falta
                    if (viewModel.errorMessage.value.isNotEmpty()) {
                        Text(
                            text = viewModel.errorMessage.value,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    // enllaç al logIn
                    TextButton(
                        onClick = { navController.navigate("LoginViewCompact") },
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text("Log in")
                    }
                }
            }
        }
    }


}