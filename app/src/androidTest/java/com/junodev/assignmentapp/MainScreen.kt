package com.junodev.assignmentapp

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.junodev.assignmentapp.ui.tiles.view.TilesFragment
import com.kaspersky.kaspresso.screens.KScreen
import org.hamcrest.Matcher

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_tiles

    override val viewClass: Class<*>
        get() = TilesFragment::class.java

    val recycler = KRecyclerView(
        builder = { withId(R.id.tiles_recycler_view) },
        itemTypeBuilder = { itemType(::Item) }
    )

    internal class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val deleteButton = KButton(parent) { withId(R.id.delete_tile_button) }
    }
}