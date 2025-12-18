package com.example.responsive.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.responsive.viewModel.AppModel

@Composable
fun Register(navController: NavController, viewModel: AppModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable{
                navController.navigate("MenuScreenView")
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Tap to Start")
    }
}