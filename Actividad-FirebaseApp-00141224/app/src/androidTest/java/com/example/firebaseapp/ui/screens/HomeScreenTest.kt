package com.example.firebaseapp.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * Tests de UI para la pantalla Home (HomeScreen).
 *
 * Utilizan createComposeRule para renderizar el composable de forma
 * aislada sin necesidad de lanzar la Activity completa. Se prueba
 * que HomeScreen muestre correctamente los datos del usuario
 * autenticado y que el botón de cerrar sesión funcione adecuadamente.
 */
class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_displaysEmailAndWelcomeMessage() {
        val testEmail = "usuario@test.com"

        composeTestRule.setContent {
            HomeScreen(
                userEmail = testEmail,
                onLogout = {}
            )
        }
        composeTestRule.onNodeWithText("Bienvenido").assertIsDisplayed()
        composeTestRule.onNodeWithText(testEmail).assertIsDisplayed()
        composeTestRule.onNodeWithText("Has iniciado sesion correctamente").assertIsDisplayed()
    }

    @Test
    fun homeScreen_logoutButtonClick_callsOnLogoutCallback() {
        var logoutCalled = false

        composeTestRule.setContent {
            HomeScreen(
                userEmail = "test@test.com",
                onLogout = { logoutCalled = true }
            )
        }
        composeTestRule.onNodeWithText("Cerrar Sesion").performClick()
        assert(logoutCalled)
    }
}