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

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isCompact = maxWidth < 412.dp
        val isMedium = maxWidth in 412.dp..900.dp
        val isExpanded = maxWidth > 900.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = if (isCompact) 16.dp else 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopBanner(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                FormTextField(
                    value = viewModel.fullName.value,
                    onValueChange = { viewModel.fullName.value = it },
                    label = "Full name",
                    placeholder = "Ej: Marcel Feliu",
                    modifier = Modifier.fillMaxWidth()
                )

                FormTextField(
                    value = viewModel.birthDate.value,
                    onValueChange = { viewModel.birthDate.value = it },
                    label = "Birth Date",
                    placeholder = "DD/MM/AAAA",
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.fillMaxWidth()
                )

                if (isMedium || isExpanded) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        FormTextField(
                            value = viewModel.email.value,
                            onValueChange = { viewModel.email.value = it },
                            label = "Email",
                            placeholder = "example@email.com",
                            keyboardType = KeyboardType.Email,
                            modifier = Modifier.weight(1f)
                        )

                        FormTextField(
                            value = viewModel.phone.value,
                            onValueChange = { viewModel.phone.value = it },
                            label = "Phone",
                            placeholder = "123456789",
                            keyboardType = KeyboardType.Phone,
                            modifier = Modifier.weight(1f)
                        )
                    }
                } else {
                    FormTextField(
                        value = viewModel.email.value,
                        onValueChange = { viewModel.email.value = it },
                        label = "Email",
                        placeholder = "example@email.com",
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier.fillMaxWidth()
                    )

                    FormTextField(
                        value = viewModel.phone.value,
                        onValueChange = { viewModel.phone.value = it },
                        label = "Phone",
                        placeholder = "123456789",
                        keyboardType = KeyboardType.Phone,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                FormTextField(
                    value = viewModel.username.value,
                    onValueChange = { viewModel.username.value = it },
                    label = "Username",
                    placeholder = "marcelfs",
                    modifier = Modifier.fillMaxWidth()
                )

                if (isExpanded) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        FormTextField(
                            value = viewModel.password.value,
                            onValueChange = { viewModel.password.value = it },
                            label = "Password",
                            isPassword = true,
                            modifier = Modifier.weight(1f)
                        )

                        FormTextField(
                            value = viewModel.confirmPassword.value,
                            onValueChange = { viewModel.confirmPassword.value = it },
                            label = "Confirm Password",
                            isPassword = true,
                            modifier = Modifier.weight(1f)
                        )
                    }
                } else {
                    FormTextField(
                        value = viewModel.password.value,
                        onValueChange = { viewModel.password.value = it },
                        label = "Password",
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    FormTextField(
                        value = viewModel.confirmPassword.value,
                        onValueChange = { viewModel.confirmPassword.value = it },
                        label = "Confirm Password",
                        isPassword = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

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
                        .fillMaxWidth(if (isCompact) 0.9f else 0.6f)
                        .height(48.dp)
                ) {
                    Text("Register")
                }

                if (viewModel.errorMessage.value.isNotEmpty()) {
                    Text(
                        text = viewModel.errorMessage.value,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }

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
