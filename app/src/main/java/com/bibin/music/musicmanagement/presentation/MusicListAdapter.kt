package com.bibin.music.musicmanagement.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bibin.music.base.presentation.getImageUrlBasedOnSize
import com.bibin.music.databinding.ListItemMusicBinding
import com.bibin.music.musicmanagement.presentation.entity.Album
import com.bumptech.glide.Glide


internal class MusicListAdapter(
    private var list: List<Album>,
    private val listItemClickCallback: ListItemClickCallback
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MusicItemViewHolder(
            ListItemMusicBinding.inflate(inflater, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as MusicItemViewHolder
        viewHolder.bind(list[position])
        viewHolder.cardView.setOnClickListener {
            listItemClickCallback.onItemClick(list[position])
        }
    }

    class MusicItemViewHolder(private val binding: ListItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val cardView = binding.cardView
        fun bind(album: Album) {
            binding.album = album
            binding.executePendingBindings()
            Glide.with(binding.imageAlbum.context).load(getImageUrlBasedOnSize(album.image,"small")).into(binding.imageAlbum)
        }


    }

    fun updateList(newList: List<Album>) {
        this.list = newList
        notifyDataSetChanged()
    }


}