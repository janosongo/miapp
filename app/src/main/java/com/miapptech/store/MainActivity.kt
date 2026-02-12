package com.miapptech.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                StoreApp()
            }
        }
    }
}

data class Service(
    val title: String,
    val description: String,
    val priceFrom: String
)

data class Product(
    val name: String,
    val category: String,
    val price: String
)

private val services = listOf(
    Service("Desarrollo de Apps", "Aplicaciones Android y multiplataforma a medida.", "USD 350"),
    Service("Páginas Web", "Landing pages, tiendas online y paneles administrativos.", "USD 180"),
    Service("Automatización", "Bots, integraciones con APIs y procesos de negocio.", "USD 220")
)

private val products = listOf(
    Product("Procesador Ryzen 7 7800X3D", "Componentes", "USD 420"),
    Product("Tarjeta gráfica RTX 4070 Super", "Componentes", "USD 690"),
    Product("Teclado mecánico RGB", "Periféricos", "USD 65"),
    Product("Mouse gamer 26K DPI", "Periféricos", "USD 49"),
    Product("SSD NVMe 1TB", "Almacenamiento", "USD 78")
)

@Composable
fun StoreApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("MiApp Tech") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                IntroSection()
            }

            item {
                SectionTitle("Servicios de programación")
            }

            items(services) { service ->
                ServiceCard(service)
            }

            item {
                SectionTitle("Catálogo de tecnología")
            }

            items(products) { product ->
                ProductCard(product)
            }

            item {
                ContactSection()
            }
        }
    }
}

@Composable
private fun IntroSection() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Soluciones tecnológicas para tu negocio",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Publica tus requerimientos, cotiza servicios y compra hardware en un solo lugar.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = 8.dp)
    )
}

@Composable
private fun ServiceCard(service: Service) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(service.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(service.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Desde ${service.priceFrom}", fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
private fun ProductCard(product: Product) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text(product.category, style = MaterialTheme.typography.bodySmall)
            }
            Text(product.price, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
private fun ContactSection() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text("Contacto", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text("WhatsApp: +34 600 000 000")
            Text("Email: ventas@miapptech.dev")
            Text("Horario: Lun - Sáb / 9:00 a 19:00")
        }
    }
}
