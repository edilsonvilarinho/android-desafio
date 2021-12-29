package br.com.edilsonvilarinho.androiddesafio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter(private val mUsuarios: List<Usuario>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView.findViewById<TextView>(R.id.username)
        val name = itemView.findViewById<TextView>(R.id.name)
        val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)
        val picture = itemView.findViewById<CircleImageView>(R.id.picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.list_item_user, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario: Usuario = mUsuarios[position]
        val username = holder.username
        username.text = usuario.username
        val name = holder.name
        name.text = usuario.name
        val progressBar = holder.progressBar
        progressBar.visibility = View.VISIBLE
        val picture = holder.picture
        Picasso.get()
            .load(usuario.img)
            .error(R.drawable.ic_round_account_circle)
            .into(picture, object : Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }
                override fun onError(e: Exception?) {
                    progressBar.visibility = View.GONE
                }
            })
    }

    override fun getItemCount(): Int {
        return mUsuarios.size
    }

}