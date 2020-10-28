package com.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.newsletter.MainActivity
import com.mbds.newsletter.R
import com.mbds.newsletter.changeFragment
import com.mbds.newsletter.databinding.CategoriesListBinding
import com.mbds.newsletter.fragments.ArticlesFragment
import com.mbds.newsletter.model.Category

class CategoryAdapter(private val dataset: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {

        lateinit var binding: CategoriesListBinding

        fun bind(item: Category) {
            binding.categoryName.text = item.name

            Glide
                .with(root)
                .load(item.image)
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .into(binding.categoryImage);

            binding.category.setOnClickListener {
                (root?.context as? MainActivity)?.changeFragment(
                        ArticlesFragment.newInstance(item)
                )
            };


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.categories_list, parent, false)
        val viewHolder = ViewHolder(rootView)
        viewHolder.binding = CategoriesListBinding.bind(rootView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            dataset[position]
        )
    }

    override fun getItemCount(): Int = dataset.size
}