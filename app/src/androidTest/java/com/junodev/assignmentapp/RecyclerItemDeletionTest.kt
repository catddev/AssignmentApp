package com.junodev.assignmentapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.junodev.assignmentapp.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecyclerItemDeletionTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun shouldDeleteTile() {
        run {
            step("Deleting last item") {
                activityTestRule.launchActivity(null)
                MainScreen {
                    flakySafely {
                        recycler {
                            scrollToEnd()
                            val size = getSize()

                            lastChild<MainScreen.Item> {
                                deleteButton.click()
                            }
                            assert(getSize() == size - 1)
                        }
                    }
                }
            }
        }
    }
}