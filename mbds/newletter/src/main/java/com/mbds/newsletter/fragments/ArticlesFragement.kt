package com.mbds.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.newsletter.R
import com.mbds.newsletter.adapters.ArticleAdapter
import com.mbds.newsletter.databinding.FragmentArticlesBinding
import com.mbds.newsletter.model.Article
import com.mbds.newsletter.repositories.Articlepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ArticlesFragement() : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private val articleAdapter = ArticleAdapter(mutableListOf())
    private val repository = Articlepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            getData()
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.article_recycler_view)
        val adapterRecycler = articleAdapter
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapterRecycler

    }

   private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            val articles = result?.articles
            if(articles != null) {
                    setData(articles)
            }

        }
    }


    private suspend fun setData( articles : Array<Article>) {
        withContext(Dispatchers.Main) {
            articleAdapter.dataset.addAll(articles)
            articleAdapter.notifyDataSetChanged()
        }
    }


    /*companion object {
        fun newInstance(category: Category): ProductsFragement {
            return ProductsFragement().apply {
                this.category = category
            }
        }
    }*/
}