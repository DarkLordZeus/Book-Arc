package com.example.bookarc.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookarc.R
import com.example.bookarc.Screen
import com.example.bookarc.ui.theme.spacegrotesk

@Composable
fun TopBar(title: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 32.dp, end = 20.dp),horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        //Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "text_back_button", modifier = Modifier.clickable(onClick = action.upPress))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, fontFamily = spacegrotesk, fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = MaterialTheme.colors.primaryVariant,
        )

    }
}