package com.example.bookarc.composables

import android.R.id.primary
import android.R.style
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import com.example.bookarc.R
import com.example.bookarc.bookarcmodel.Item
import com.example.bookarc.ui.theme.Shapes
import com.example.bookarc.ui.theme.lightblue
import com.example.bookarc.ui.theme.spacegrotesk
import com.example.bookarc.ui.theme.primary
import java.sql.Types.NULL


@OptIn(ExperimentalCoilApi::class)
@Composable
fun Itemview(item: Item) {
    Card(modifier = Modifier
        .padding(24.dp)
        .height(200.dp)
        .fillMaxWidth()
        .background(MaterialTheme.colors.background),
        shape = Shapes.large,
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 1.dp) {

        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
            var painter:Painter
            if(item.volumeInfo.imageLinks!=null){
                painter=rememberImagePainter(data=item.volumeInfo.imageLinks.smallThumbnail,
                    builder={
                        placeholder(R.drawable.ic_baseline_broken_image_24)
                        error(R.drawable.ic_baseline_broken_image_24)
                        crossfade(1000)
                    })
            }
            else{
                painter=painterResource(id = R.drawable.ic_baseline_broken_image_24)
            }

            Image(painter = painter, contentDescription = "bookimage",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .fillMaxSize())

            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.5f), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start) {
                var author="Unknown"
                if(item.volumeInfo.authors!=null)
                    author=item.volumeInfo.authors[0]
                    Text(text = "by ${author}",
                        fontFamily = spacegrotesk,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.primaryVariant)
                Text(text = "${item.volumeInfo.title}",
                    color = MaterialTheme.colors.primaryVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = spacegrotesk,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 0.dp, end = 24.dp, top = 12.dp)
                )
                Row(modifier = Modifier.padding(start = 0.dp, end = 24.dp, top = 12.dp), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start) {
                    Image(painter = painterResource(id = R.drawable.star),
                        contentDescription = "star",
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp))
                    Text(text = "${item.volumeInfo.averageRating.toString()}",
                        fontFamily = FontFamily.Serif,
                        fontSize = 16.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 10.dp))
                }
                Box(
                    modifier = Modifier
                        .padding(top = 12.dp, end = 12.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(lightblue.copy(.10F))
                        .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    var category=""
                    category = if(item.volumeInfo.categories.isNullOrEmpty())
                        "Notfound"
                    else
                        item.volumeInfo.categories[0]
                            Text(text = category,color = MaterialTheme.colors.primary,
                                fontFamily = spacegrotesk,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis)
                }

            }
        }
        
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun PreItemview()
//{
//    Itemview()
//}
//
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun PreItemvieww()
//{
//    Itemview()
//}