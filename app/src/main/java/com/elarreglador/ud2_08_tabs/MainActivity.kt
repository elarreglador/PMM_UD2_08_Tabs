package com.elarreglador.ud2_08_tabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elarreglador.ud2_08_tabs.tabs.Tab1Screen
import com.elarreglador.ud2_08_tabs.tabs.Tab2Screen
import com.elarreglador.ud2_08_tabs.ui.theme.UD2_08_TabsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UD2_08_TabsTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var selectedTab by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TabRow(
                selectedTabIndex = selectedTab,
                Modifier.shadow(10.dp),
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black,
                    modifier = Modifier
                        .background(if (selectedTab == 0) MaterialTheme.colorScheme.secondary else Color.Transparent)
                        .padding(30.dp)
                ) {
                    Text(text = "Pestaña 1")
                }
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black,
                    modifier = Modifier
                        .background(if (selectedTab == 1) MaterialTheme.colorScheme.secondary else Color.Transparent)
                        .padding(30.dp)
                ) {
                    Text(text = "Pestaña 2")
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> Tab1Screen()
                1 -> Tab2Screen()
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    UD2_08_TabsTheme {
        MyApp()
    }
}
