package com.example.redstrim
import androidx.compose.ui.graphics.Brush
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
// import androidx.compose.foundation.shape.RoundedCornerShape // Şu an kullanılmıyor, kaldırılabilir
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
// import androidx.compose.ui.text.font.FontFamily // Şu an kullanılmıyor
import com.example.redstrim.ui.theme.RedStrimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedStrimTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    WelcomeScreen()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    Box( // 🔲 1. Ana kapsayıcı
        modifier = Modifier.fillMaxSize()
    ) {
        // 🖼️ 2. Arka plan görseli
        Image(
            painter = painterResource(id = R.drawable.redstrim_background), // KAYNAK ADINI KONTROL ET!
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 🟥 3. Üst Kırmızı Şerit ve Uygulama Adı
        Box(
            modifier = Modifier
                .fillMaxWidth() // Tüm genişliği kapla
                .height(100.dp)  // Şeridin yüksekliğini ayarla (örneğin 56.dp veya 64.dp)
                .background(
                    brush = Brush.verticalGradient( // Gradient bir kırmızı gölge için
                        colors = listOf(
                            Color(0xFFB71C1C).copy(alpha = 0.8f), // Üstte daha opak kırmızımsı
                            Color.Transparent // Alta doğru şeffaflaşır
                        ),
                        // Eğer düz bir kırmızı şerit istersen:
                        // color = Color(0xFFB71C1C) // Veya istediğin bir kırmızı tonu
                    )
                )
                .align(Alignment.TopCenter), // Ana Box'ın en üstüne hizala
            contentAlignment = Alignment.CenterStart // İçindeki Text'i sola ve dikeyde ortaya hizala
        ) {
            Text(
                text = "RedStrim",
                fontSize = 24.sp, // Boyutu şeride göre ayarlanabilir
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp, top=40.dp) // Kırmızı şeridin sol kenarından boşluk
            )
        }

        Text(
            text = "Lets Start",
            fontSize = 24.sp, // Boyutu şeride göre ayarlanabilir
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 20.dp) // Kırmızı şeridin sol kenarından boşluk
        )

        // ⬛ (İsteğe Bağlı) Alt Karartma Efekti (Butonların arkası için)
        // Bu Box'ı, Üst Kırmızı Şerit Box'ından SONRA, ama Butonları içeren Column'dan ÖNCE tanımla.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f) // Ekranın alt %40'ını kaplasın
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f),
                            Color.Black
                        )
                    )
                )
        )

        // 📱 İçerik Sütunu: Butonlar (ve belki diğer metinler)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp), // Dikey padding önemli
            // verticalArrangement = Arrangement.Top, // Bunu değiştiriyoruz
            verticalArrangement = Arrangement.Bottom, // Butonları en alta yaslamak için
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // "Hazırsan başlayalım" gibi bir metin istersen buraya, butonlardan önce ekleyebilirsin
            // Text(
            // text = "Haziness\nbaşlayalım...",
            // fontSize = 20.sp,
            // color = Color.White, // Arka plan karartmasına göre renk seç
            // textAlign = TextAlign.Center,
            // modifier = Modifier.padding(bottom = 32.dp)
            // )

            // Spacer(modifier = Modifier.height(120.dp)) // Bu artık çok fazla olabilir veya gereksiz.
            // Column'u Arrangement.Bottom'a aldık.
            // İhtiyaç olursa daha küçük bir Spacer veya padding kullanılabilir.

            // Spacer(modifier = Modifier.weight(1f)) // Arrangement.Bottom kullandığımız için bu da gereksiz.

            // Oturum Aç Butonu
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Oturum Aç", color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Google ile Oturum Aç Butonu
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Google ile Oturum Aç", color = Color.White)
            }
        }
    }
}