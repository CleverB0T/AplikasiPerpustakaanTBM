package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentAddAdminBinding
import com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel.AddAdminViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAdminFragment : Fragment() {

    private lateinit var bindingFragment: FragmentAddAdminBinding

    private val viewModel: AddAdminViewModel by viewModels()

    private val REQUEST_CODE_PERMISSIONS = 10
    private val REQUIRED_PERMISSIONS =
        arrayOf(Manifest.permission.CAMERA)

    private var resultGallery = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val stream = requireContext().contentResolver.openInputStream(it)
        val bitmap = BitmapFactory.decodeStream(stream)

        bindingFragment.backgroundFoto.load(bitmap) {
            crossfade(true)
            crossfade(1000)
            transformations(CircleCropTransformation())
            viewModel.imageAdmin.value = bitmap
        }
    }

    private var resultImageCapture =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val bitmap = data?.extras?.get("data") as Bitmap
                //we are using coroutine image loader (coil)
                bindingFragment.backgroundFoto.load(bitmap) {
                    crossfade(true)
                    crossfade(1000)
                    transformations(CircleCropTransformation())

                    viewModel.imageAdmin.value = bitmap
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_admin, container, false)

        bindingFragment.myViewModel = viewModel
        bindingFragment.lifecycleOwner = this

        viewModel.message.observe(requireActivity(), Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        })
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFragment.buttonBackAddAdmin.setOnClickListener {
            it.findNavController().navigate(R.id.action_addAdminFragment_to_userFragment)
        }
        bindingFragment.buttonAddCameraAdmin.setOnClickListener {
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
