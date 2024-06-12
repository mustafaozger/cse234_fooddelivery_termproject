package com.example.fooddeliveryproject.View.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fooddeliveryproject.View.SpecialWidgets.CarouselCardOrigin
import com.example.fooddeliveryproject.View.SpecialWidgets.CategoryCard
import com.example.fooddeliveryproject.View.SpecialWidgets.Header
import com.example.fooddeliveryproject.View.SpecialWidgets.Favs
import com.example.fooddeliveryproject.View.SpecialWidgets.Restorants
import com.example.fooddeliveryproject.View.SpecialWidgets.SearchBar
import com.example.fooddeliveryproject.ViewModel.AddressPageViewModel

@Composable
fun MainPage(navHostController: NavHostController=rememberNavController(),addressPageViewModel: AddressPageViewModel= viewModel()) {
    Scaffold(
        topBar = {
            Header(navController = navHostController,addressPageViewModel.addressTitle,addressPageViewModel.addressDesc)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            item {
                SearchBar()
            }
            item {
                CarouselCardOrigin()
            }
            item {
                CategoryCard(navHostController)
                Spacer(modifier = Modifier.size(8.dp))
            }
            item {
                Favs()
            }
            item {
                Restorants()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MainPage()
}
