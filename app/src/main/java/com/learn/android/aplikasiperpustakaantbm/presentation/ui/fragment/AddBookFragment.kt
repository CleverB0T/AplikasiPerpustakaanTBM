package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import coil.load
import coil.transform.RoundedCornersTransformation
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentAddBookBinding
import com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBookFragment : Fragment() {

    private lateinit var bindingFragment: FragmentAddBookBinding
    private val viewModel: BookViewModel by viewModels()

    private val REQUEST_CODE_PERMISSIONS = 10
    private val REQUIRED_PERMISSIONS =
        arrayOf(Manifest.permission.CAMERA)

    private var resultGallery = registerForActivityResult(ActivityResultContracts.GetContent()) {
        bindingFragment.buttonAddBook.load(it) {
            crossfade(true)
            crossfade(1000)
            transformations(RoundedCornersTransformation())
        }
    }

    private var resultImageCapture =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val bitmap = data?.extras?.get("data") as Bitmap
                //we are using coroutine image loader (coil)
                bindingFragment.buttonAddBook.load(bitmap) {
                    crossfade(true)
                    crossfade(1000)
                    transformations(RoundedCornersTransformation())
                }

            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val listCategory = resources.getStringArray(R.array.category)
        val listGenre = resources.getStringArray(R.array.genre)
        val adapterCategory =
            ArrayAdapter(requireContext(), R.layout.list_items_category, listCategory)
        val adapterGenre = ArrayAdapter(requireContext(), R.layout.list_items_category, listGenre)
        bindingFragment = FragmentAddBookBinding.inflate(inflater, container, false)

        bindingFragment.inputTextCategory.setAdapter(adapterCategory)
        bindingFragment.inputTextGenre.setAdapter(adapterGenre)


        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFragment.buttonBackAddBook.setOnClickListener {
            it.findNavController().navigate(R.id.action_addBookFragment_to_homeFragment)
        }

        bindingFragment.buttonAddBook.setOnClickListener {
            if (allPermissionsGranted()) {
                val pictureDialog = AlertDialog.Builder(requireContext())
                pictureDialog.setTitle("Select Action")
                val pictureDialogItem =
                    arrayOf("Select photo from Gallery", "Capture photo from Camera")
                // Request Permissions

                pictureDialog.setItems(pictureDialogItem) { _, which ->
                    when (which) {
                        0 -> gallery()
                        1 -> camera()
                    }
                }
                pictureDialog.show()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
                )
            }
        }
    }

    private fun gallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        resultGallery.launch("image/*")

    }

    private fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultImageCapture.launch(intent)
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ActivityCompat.checkSelfPermission(
            requireContext(),
            it
        ) == PackageManager.PERMISSION_GRANTED
    }
}