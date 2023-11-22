package nur.xan.neocafe.clientneocafe.uiClient.home.category.categoryInfo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import nur.xan.neocafe.clientneocafe.databinding.FragmentCategoryInfoBinding
import nur.xan.neocafe.clientneocafe.interfaces.IClickListnearCategoryInfo
import nur.xan.neocafe.clientneocafe.uiClient.home.category.PagingAdapterCategory
import nur.xan.neocafe.clientneocafe.viewModels.categoryVM.CategoryVM


class CategoryInfoFragment : Fragment() {

    private var _binding: FragmentCategoryInfoBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<CategoryVM>()
    val args: CategoryInfoFragmentArgs by navArgs()

    lateinit var recyclerViewCategory: RecyclerView
    private lateinit var adapterCategory: PagingAdapterCategory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCategoryPagingLiveData().observe(viewLifecycleOwner) { pagingData ->
            adapterCategory.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }



        recyclerViewCategory = binding.rvCategory
        adapterCategory = PagingAdapterCategory(object : IClickListnearCategoryInfo {
            override fun clickListener(baseID: Int, name: String) {
               binding.textTitle.text = name
            }
        })
        recyclerViewCategory.adapter = adapterCategory
        recyclerViewCategory.setHasFixedSize(true)

        adapterCategory.selectItem(args.categoryIntArgs[0].toInt())
        binding.textTitle.text = args.categoryIntArgs[1]



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}