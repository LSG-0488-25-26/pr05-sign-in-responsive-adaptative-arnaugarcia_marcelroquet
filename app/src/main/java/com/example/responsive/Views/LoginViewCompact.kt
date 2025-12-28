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
fun LoginCompact(navController: NavController, viewModel: AppModel) {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TopBanner(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

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
                        value = viewModel.password.value,
                        onValueChange = { viewModel.password.value = it },
                        label = "Password",
                        isPassword = true,
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
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    label = "Password",
                    isPassword = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val error = viewModel.validateLogin()
                    if (error.isEmpty()) {
                        navController.navigate("MenuScreenView")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(if (isCompact) 0.9f else 0.6f)
                    .height(48.dp)
            ) {
                Text("Log In")
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
                onClick = { navController.navigate("RegisterViewCompact") },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Register")
            }
        }
    }
}
