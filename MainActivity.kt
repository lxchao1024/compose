package com.example.lifecycle.compose

import android.os.Bundle
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lifecycle.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {
                val scrollBehavior =
                    TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    bottomBar = { BottomBar() },
                    topBar = { TitleAppBar() }) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(0.dp, innerPadding.calculateTopPadding(), 0.dp, 0.dp)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleAppBar() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = {
                Log.e("MainActivity", "IconButton Back Click")
            }) {
                Image(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Create"
                )
            }
        },
        title = {
            Text(
                text = "hello world",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { Log.e("MainActivity", "More Button Click") }) {
                Image(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "MoreVert"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun BottomBar() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var select by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Column {
        Text(text = "hello $name", modifier = modifier.weight(1f))
        Row(modifier = Modifier.background(Color.LightGray).then(Modifier.fillMaxWidth()), horizontalArrangement = Arrangement.Center) {
            //实心按钮
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonColors(Color.Black, Color.White, Color.White, Color.White),
                modifier = Modifier.padding(10.dp).weight(1f),
            ) {
                Text(text = "Filled")
            }
            //填充色调按钮 默认情况下，系统会使用色调颜色进行填充。
            FilledTonalButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp).weight(1f),) {
                Text(text = "FilledTonal")
            }
            //轮廓按钮
            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp).weight(1f),) {
                Text(text = "Outlined", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            //凸起按钮
            ElevatedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp).weight(1f),) {
                Text(text = "Elevated")
            }
            //文本按钮
            TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp).weight(1f),) {
                Text("Text")
            }
        }
        Text(text = "悬浮操作按钮", modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(10.dp))
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(10.dp))
            SmallFloatingActionButton(
                onClick = { /*TODO*/ },
                contentColor = Color.Red,
                containerColor = Color.Black
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(10.dp))
            LargeFloatingActionButton(onClick = { /*TODO*/ }, shape = CircleShape) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(10.dp))
            ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = null)
                Text("Extended")
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
        Row(modifier = Modifier.padding(10.dp)) {
            Card(modifier = Modifier.size(100.dp, 100.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .then(Modifier.background(Color.Black)), contentAlignment = Alignment.Center
                ) {
                    Text(text = "Card", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.size(width = 140.dp, height = 100.dp)
            ) {
                Text(
                    text = "Elevated",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                border = BorderStroke(10.dp, Color.Black),
                modifier = Modifier.size(width = 240.dp, height = 100.dp)
            ) {
                Text(
                    text = "Outlined",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
        Text(text = "标签", modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
        Row {
            Spacer(modifier = Modifier.width(10.dp))
            //辅助条状标签
            AssistChip(
                onClick = {  },
                label = { Text("Assist") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = null
                    )
                })
            Spacer(modifier = Modifier.width(10.dp))
            //过滤条件
            FilterChip(
                onClick = { select = !select },
                label = { Text("Filter", color = if (select) Color.Black else Color.Gray) },
                selected = select,
                leadingIcon = if (select) {
                    { Icon(Icons.Filled.Done, contentDescription = null) }
                } else {
                    null
                }
            )
        }
        Text(text = "进度条", modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(10.dp))
            LinearProgressIndicator(progress = { 10f })
            Spacer(modifier = Modifier.width(10.dp))
            CircularProgressIndicator(modifier = Modifier.size(64.dp), color = Color.Black, trackColor = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
        }
        Button(onClick = { showBottomSheet = !showBottomSheet }) {
            Text(text = "ModalBottomSheet")
        }
    }

    if (select) {
        ShowSystemDialog { select = !select }
    }
    
    if (showBottomSheet) {
        ShowBottomSheetView { showBottomSheet = false }
    }
}


@Composable
fun ShowSystemDialog(onDismissRequest: () -> Unit) {
    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = { onDismissRequest() },
        confirmButton = { TextButton(onClick = { onDismissRequest() }) {
            Text(text = "确定")
        } },
        icon = { Icon(Icons.Filled.Notifications, contentDescription = null) },
        title = { Text("标题") },
        text = { Text("内容") },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text("取消")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowBottomSheetView(onDismissRequest: () -> Unit) {
    val bottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    ModalBottomSheet(onDismissRequest = { onDismissRequest() }, sheetState = bottomSheetState) {
        LazyColumn {
            item {
                Text(text = "ModalBottomSheet", modifier = Modifier.height(200.dp))
                Button(onClick = {
                    scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                        if (!bottomSheetState.isVisible) onDismissRequest()
                    }
                }) {
                    Text(text = "ModalBottomSheet")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}