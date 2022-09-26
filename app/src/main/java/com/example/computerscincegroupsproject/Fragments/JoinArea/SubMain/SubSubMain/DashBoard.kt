package com.example.computerscincegroupsproject.Fragments.JoinArea.SubMain.SubSubMain

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.computerscincegroupsproject.Adapter.DashBoardPostsAdapter
import com.example.computerscincegroupsproject.R
import com.example.computerscincegroupsproject.databinding.FragmentDashBoardBinding
import com.example.computerscincegroupsproject.models.Post
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class DashBoard : Fragment() {
    private var groupId:String? = null
    private var binding: FragmentDashBoardBinding? = null
    private var bottomNavigationView:BottomNavigationView? = null


    companion object{
        @JvmStatic
        fun newInstance(groupId: String) : DashBoard =
            DashBoard().apply {
                val bundle = Bundle()
                bundle.putString("gid" , groupId)
                arguments = bundle
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            groupId = it.getString("gid")
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.PostsRecycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                try {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        Log.d("TAG", "onScrollStateChanged: " + RecyclerView.SCROLL_STATE_IDLE)
                        bottomNavigationView?.apply {
                            postDelayed({
                                if(this@DashBoard.isVisible) {
                                    val animation = AnimationUtils.loadAnimation(
                                        requireContext(), R.anim.alpha_down
                                    )
                                    Log.d("TAG", "onScrollStateChanged: animation on apply")
                                    this.startAnimation(animation)
                                }
                            } , 5000)
                        }
                    } else if (newState == RecyclerView.SCROLL_AXIS_VERTICAL) {
                        Log.d("TAG", "onScrollStateChanged: " + RecyclerView.SCROLL_AXIS_VERTICAL)
                        val animation = AnimationUtils.loadAnimation(
                            requireContext(), R.anim.alpha_up
                        )
                        bottomNavigationView?.startAnimation(animation)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        val adapter = DashBoardPostsAdapter()
        binding!!.PostsRecycleView.adapter = adapter


        adapter.submitList(object : ArrayList<Post?>() {
            init {
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
                add(
                    Post(
                        UUID.randomUUID().toString(), Calendar.getInstance().time,
                        "hany", "0103456432", "ajsgdfjhvasbc", "jsgdfhkajhsdbvcnasdhf;klBKSD CN"
                    )
                )
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashBoardBinding.inflate(layoutInflater , container ,false)
        bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView)
        return binding!!.root
    }



}