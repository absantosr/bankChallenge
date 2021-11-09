package com.santos.bankchallengue.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.santos.bankchallengue.R
import com.santos.bankchallengue.data.model.TaskEntity
import com.santos.bankchallengue.databinding.FragmentTaskBinding
import com.santos.bankchallengue.presentation.util.getViewModel

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private lateinit var viewModel: TaskViewModel

    private var userId: String = ""
    private val args: TaskFragmentArgs by navArgs()

    private val taskAdapter by lazy {
        TaskAdapter(::onTaskSelected)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userId = args.userId
        viewModel = getViewModel {
            TaskViewModel()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTask(userId)
        configureRecyclerView()

        viewModel.tasksLiveData.observe(viewLifecycleOwner, Observer {
            renderGetTasks(it)
        })
    }

    private fun renderGetTasks(tasks: List<TaskEntity>) {
        taskAdapter.items = tasks
    }

    private fun configureRecyclerView() {
        binding.rvTask.run {
            setHasFixedSize(true)
            adapter = taskAdapter
        }
    }

    private fun onTaskSelected(task: TaskEntity) {

    }
}