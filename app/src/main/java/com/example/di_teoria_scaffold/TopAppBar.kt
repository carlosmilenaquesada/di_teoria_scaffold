package com.example.di_teoria_scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopApp() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val coroutineScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalDrawer(drawerState = drawerState) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            topBar = {
                TopAppBar01(onClickIcon = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("$it")
                    }
                }, onClickDrawer = { scope.launch { drawerState.open() } })
            },
            bottomBar = { NavigationBar01() },
            floatingActionButton = { FloatingActionButton01() },
            floatingActionButtonPosition = FabPosition.End
        ) { contentPadding ->
            Box(
                modifier = Modifier
                    .padding(contentPadding)
                    .height(50.dp)
                    .background(Color.Cyan)
            ) {

            }
        }
    }
}

@Composable
fun NavigationBar01() {
    var index by remember {
        mutableStateOf(1)
    }
    NavigationBar(
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        NavigationBarItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Account Circle"
            )
        },
            label = { Text(text = "Account") })
        NavigationBarItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share"
            )
        },
            label = { Text(text = "Share") })
        NavigationBarItem(selected = index == 3, onClick = { index = 3 }, icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star"
            )
        },
            label = { Text(text = "Star") })

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar01(
    onClickIcon: (String) -> Unit,
    onClickDrawer: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "TopAppBar", color = Color.White)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Email") }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
            }
            IconButton(onClick = { onClickIcon("Close") }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
            }
        }

    )

}


















