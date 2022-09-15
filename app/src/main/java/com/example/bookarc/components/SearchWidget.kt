package com.example.bookarc.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.bookarc.ui.theme.Shapes
import com.example.bookarc.ui.theme.background
import com.example.bookarc.ui.theme.spacegrotesk


@Composable
fun SearchWidget(resultt: RetrofitViewModel) {
    var query by remember {mutableStateOf("")}
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        contentAlignment = Alignment.Center){
        OutlinedTextField(modifier = Modifier.fillMaxWidth().padding(start = 12.dp,end=12.dp),value = query,
            onValueChange = {
            query=it
        },
            textStyle = TextStyle(color = MaterialTheme.colors.primaryVariant, fontSize = 20.sp, fontFamily = spacegrotesk,
            fontWeight = FontWeight.Normal),
            placeholder = { Text("Search", color = Color.LightGray,fontFamily = spacegrotesk, fontSize = 16.sp,
                fontWeight = FontWeight.Normal) },
            maxLines = 1,
            leadingIcon={
                IconButton(onClick={/*TODO*/}){
                    Icon(imageVector=Icons.Filled.Search,contentDescription="email", tint = Color.LightGray, modifier = Modifier.padding(start = 12.dp).size(28.dp))
                }
            },
            shape = Shapes.large,

            keyboardOptions= KeyboardOptions(
                keyboardType= KeyboardType.Text,
                imeAction= ImeAction.Search
            ),
            keyboardActions= KeyboardActions(
                onSearch={
                    if(query.isNullOrEmpty())
                        resultt.gettrendingimage()
                    else
                    resultt.getsearchedimage(query)
                }
            )
        )
        
    }
    
}