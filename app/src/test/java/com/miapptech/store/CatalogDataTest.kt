package com.miapptech.store

import org.junit.Assert.assertTrue
import org.junit.Test

class CatalogDataTest {

    @Test
    fun `el precio de los productos incluye moneda`() {
        val sample = listOf(
            Product("SSD", "Almacenamiento", "USD 50"),
            Product("Mouse", "Periféricos", "USD 20")
        )

        assertTrue(sample.all { it.price.startsWith("USD") })
    }
}
