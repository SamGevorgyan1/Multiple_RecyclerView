package com.multiplerecyclerview.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.multiplerecyclerview.R
import com.multiplerecyclerview.adapter.PostAdapter
import com.multiplerecyclerview.model.FakeData
import com.multiplerecyclerview.model.WebViewPost

class PostActivity : AppCompatActivity(), (Any) -> Unit {

   private val postAdapter = PostAdapter(this)
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rec)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
            adapter = postAdapter

        }
      postAdapter.updateData(FakeData.getData())
    }

    override fun invoke(item: Any) {
        item as WebViewPost
        intentWebView(item)
    }
    private fun intentWebView(post:WebViewPost){
        val intent= Intent(this@PostActivity, WebViewActivity::class.java)
        intent.putExtra("web",post.webViewUrl)
        startActivity(intent)
    }


}