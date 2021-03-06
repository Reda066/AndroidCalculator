package com.mbds.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.newsletter.R
import com.mbds.newsletter.adapters.CategoryAdapter
import com.mbds.newsletter.model.Category

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val categories = listOf(
            Category(name = "Politique", image = "https://images.pexels.com/photos/4666/berlin-eu-european-union-federal-chancellery.jpg?auto=compress&cs=tinysrgb&dpr=3&h=300&w=500"),
            Category(name = "Economie", image = "https://images.pexels.com/photos/45708/pexels-photo-45708.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=300&w=500"),
            Category(name = "Pandémie", image = "https://images.pexels.com/photos/3970330/pexels-photo-3970330.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=300&w=500"),
            Category(name = "Sport", image = "https://images.pexels.com/photos/863988/pexels-photo-863988.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=300&w=500"),
        )
        val adapterRecycler = CategoryAdapter(categories)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapterRecycler
    }

}