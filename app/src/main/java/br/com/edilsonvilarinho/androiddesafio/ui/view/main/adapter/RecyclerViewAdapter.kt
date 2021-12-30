package br.com.edilsonvilarinho.androiddesafio.ui.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.edilsonvilarinho.androiddesafio.R
import br.com.edilsonvilarinho.androiddesafio.data.model.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var mUsers = emptyList<User>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

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
        val user: User = mUsers[position]
        val username = holder.username
        username.text = user.username
        val name = holder.name
        name.text = user.name
        val progressBar = holder.progressBar
        progressBar.visibility = View.VISIBLE
        val picture = holder.picture
        Picasso.get()
            .load(user.img)
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
        return mUsers.size
    }

}