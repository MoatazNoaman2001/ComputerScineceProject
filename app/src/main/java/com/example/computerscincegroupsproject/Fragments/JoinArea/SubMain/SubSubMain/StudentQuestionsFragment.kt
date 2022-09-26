package com.example.computerscincegroupsproject.Fragments.JoinArea.SubMain.SubSubMain

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.computerscincegroupsproject.Adapter.DashBoardPostsAdapter
import com.example.computerscincegroupsproject.R
import com.example.computerscincegroupsproject.databinding.FragmentStudentQuestionsBinding
import com.example.computerscincegroupsproject.models.Post
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val GROUP_ID = "gid"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentQuestionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var groupId: String? = null
    private var binding : FragmentStudentQuestionsBinding ? = null
    private var bottomNavigationView:BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            groupId = it.getString(GROUP_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStudentQuestionsBinding.inflate(inflater , container , false)
        bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.PostsRecycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                try {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        Log.d("TAG", "onScrollStateChanged: " + RecyclerView.SCROLL_STATE_IDLE)
                        Handler().postDelayed({
                            val animation = AnimationUtils.loadAnimation(
                                requireContext(), R.anim.alpha_down
                            )
                            Log.d("TAG", "onScrollStateChanged: animation on apply")
                            bottomNavigationView?.startAnimation(animation)
                        }, 5000)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param groupId Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StudentQuestionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(groupId: String) =
            StudentQuestionsFragment().apply {
                arguments = Bundle().apply {
                    putString(GROUP_ID, groupId)
                }
            }
    }
}