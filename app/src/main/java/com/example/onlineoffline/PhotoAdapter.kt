package com.example.onlineoffline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhotoAdapter(private val photos: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idTv: TextView = itemView.findViewById(R.id.id_tv)
        private val titleTv: TextView = itemView.findViewById(R.id.title_tv)
        private val descriptionTv: TextView = itemView.findViewById(R.id.description_tv)
        private val avatarIv: ImageView = itemView.findViewById(R.id.thumbnail_iv)
        fun bind(photo: Photo) {
            idTv.text = photo.id.toString()
            titleTv.text = photo.title
            descriptionTv.text = photo.title
            Picasso.get().load(photo.thumbnailUrl).into(avatarIv)
        }
    }
}