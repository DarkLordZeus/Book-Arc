package com.example.bookarc.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import com.example.bookarc.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.bookarc.ui.theme.background
import com.example.bookarc.ui.theme.primary
import com.example.bookarc.ui.theme.spacegrotesk
import com.example.bookarc.ui.theme.text
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun DetailScreen(navController: NavController,titlee:String?,
                 author:String?,
                 rating:Float?,
                 category:String?,
                 decription:String?) {

    // Transparent white bg
    val rating=rating.toString()
    val title=titlee
    val authors=author
    val thumbnailUrl="http://books.google.com/books/content?id=t4acDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
    val categories=category
    val description=decription

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 20.dp, end = 16.dp, top = 40.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color.Transparent),
            contentAlignment = Alignment.Center
        ) {

            // white box layout

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(MaterialTheme.colors.onSurface),
            )

            // Content
            BookImageContentView(rating,title, authors, thumbnailUrl, categories)





        }
        Box(Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 24.dp)
            .clip(RoundedCornerShape(32.dp))
            .height(300.dp)
            .background(MaterialTheme.colors.onSurface)) {
            Column {
                Text(text = "Description",
                    modifier = Modifier.padding(start=24.dp,top=16.dp),
                    fontFamily = spacegrotesk,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primaryVariant)
                Box(modifier = Modifier
                    .padding(bottom = 16.dp)
                    .verticalScroll(rememberScrollState())
                    .background(Color.Transparent)) {
                    Text(text = description.toString(),
                        modifier = Modifier.padding(start=24.dp,top=16.dp, end = 24.dp, bottom = 16.dp),
                        fontFamily = spacegrotesk,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }

            }
            

        }
        VisitView()
    }
}

@Composable
fun BookImageContentView(
    rating:String,
    title: String?,
    authors: String?,
    thumbnailUrl: String?,
    categories: String?
) {
    // content
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        // image
        Image(
            painter = rememberImagePainter(
                data = thumbnailUrl
            ),
            contentDescription = title,
            modifier = Modifier.height(200.dp).width(120.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onSurface)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title.toString(),
                fontFamily = spacegrotesk,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primaryVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 16.dp,end=16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.star), contentDescription = "star",
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp))
                Text(text = rating,
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 10.dp))
                Text(
                    text = "by "+authors,
                    fontFamily = spacegrotesk,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primaryVariant.copy(0.7F),
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow {
                ChipView(category = categories.toString())

            }
        }
    }
}
@Composable
fun VisitView() {
    Box(
        modifier = Modifier.padding(20.dp).fillMaxWidth().height(40.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(primary)
            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Visit Book", fontFamily = spacegrotesk, fontWeight = FontWeight.Normal, color = Color.White, fontSize = 16.sp)
    }
}
@Composable
fun ChipView(category: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .background(primary.copy(.10F))
            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = category, style = typography.caption, color = primary, fontSize = 12.sp)
    }
}

