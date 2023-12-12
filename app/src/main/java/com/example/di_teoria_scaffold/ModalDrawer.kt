package com.example.di_teoria_scaffold

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawer(drawerState: DrawerState, scaffold: @Composable () -> Unit) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet() {
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item 01") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item 02") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item 03") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    })
            }
        }) {
        scaffold()
    }

}