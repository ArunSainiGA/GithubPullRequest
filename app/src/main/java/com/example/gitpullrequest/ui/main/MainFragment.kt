package com.example.gitpullrequest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gitpullrequest.databinding.MainFragmentBinding
import com.example.gitpullrequest.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding
    private val adapter = PullRequestAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return MainFragmentBinding.inflate(inflater).let { mainFragmentBinding ->
            binding = mainFragmentBinding
            mainFragmentBinding.adapter = adapter
            mainFragmentBinding.viewModel = viewModel
            mainFragmentBinding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            // Pull Request
            observe(pullRequests) {
                adapter.submitList(it)
            }

            // Progress
            observe(loading) {
                when(it) {
                    true -> binding.progressBar.visibility = View.VISIBLE
                    else -> binding.progressBar.visibility = View.GONE
                }
            }

            // Error
            observe(error) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.fetchPullRequest()
    }

}