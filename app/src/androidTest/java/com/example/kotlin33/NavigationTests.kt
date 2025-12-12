package com.example.kotlin33

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test


class NavigationTests {
    @JvmField
    @Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testNavigation_worksCorrectly() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Buy milk").assertIsDisplayed()
        composeTestRule.onNodeWithText("Buy milk").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("2 liters, skimmed").assertIsDisplayed()
        composeTestRule.onNodeWithTag("back_button", useUnmergedTree = true).performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Buy milk").assertIsDisplayed()
        //composeTestRule.onNodeWithText("а3 к23к2к32к2к").assertIsDisplayed()
    }

    @Test
    fun testCheckBox() {
        composeTestRule.waitForIdle()
        composeTestRule.onAllNodesWithTag("card_checkbox")[0].assertIsDisplayed()
        composeTestRule.onAllNodesWithTag("card_checkbox")[0].assertIsOff()
        composeTestRule.onAllNodesWithTag("card_checkbox")[0].performClick()
        composeTestRule.onAllNodesWithTag("card_checkbox")[0].assertIsOn()
        composeTestRule.onAllNodesWithTag("card_checkbox")[0].performClick()
        composeTestRule.onAllNodesWithTag("card_checkbox")[0].assertIsOff()
        //composeTestRule.onAllNodesWithTag("card_checkbox")[0].assertIsOn()
        //card_checkbox
    }

    @Test
    fun testAllTaskShow(){
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Buy milk").assertIsDisplayed()
        composeTestRule.onNodeWithText("Call mom").assertIsDisplayed()
        composeTestRule.onNodeWithText("Do Android homework").assertIsDisplayed()
        composeTestRule.onNodeWithText("Walk the dog").assertIsDisplayed()
        composeTestRule.onNodeWithText("Read a book").assertIsDisplayed()
        composeTestRule.onNodeWithText("Pay bills").assertIsDisplayed()
        composeTestRule.onNodeWithText("Grocery shopping").assertIsDisplayed()
        //composeTestRule.onNodeWithText("а3 к23к2к32к2к").assertDoesNotExist()
    }

}



//[
//{
//    "id": 1,
//    "title": "Buy milk",
//    "description": "2 liters, skimmed",
//    "isCompleted": false
//},
//{
//    "id": 2,
//    "title": "Call mom",
//    "description": "Ask about the weekend",
//    "isCompleted": true
//},
//{
//    "id": 3,
//    "title": "Do Android homework",
//    "description": "Clean Architecture + Compose",
//    "isCompleted": false
//},
//{
//    "id": 4,
//    "title": "Walk the dog",
//    "description": "30 minutes in the park",
//    "isCompleted": false
//},
//{
//    "id": 5,
//    "title": "Read a book",
//    "description": "Finish 'Clean Code'",
//    "isCompleted": true
//},
//{
//    "id": 6,
//    "title": "Pay bills",
//    "description": "Electricity and internet",
//    "isCompleted": false
//},
//{
//    "id": 7,
//    "title": "Grocery shopping",
//    "description": "Fruits, vegetables, bread",
//    "isCompleted": false
//}
//]