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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentAddAdminBinding


class AddAdminFragment : Fragment() {

    private lateinit var bindingFragment: FragmentAddAdminBinding
    private val CAMERA_REQUEST_CODE = 1
    private val GALLERY_REQUEST_CODE = 2
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                when (result.resultCode) {

                    CAMERA_REQUEST_CODE -> {
                        val bitmap = data?.extras?.get("data") as Bitmap
                        //we are using coroutine image loader (coil)
                        bindingFragment.backgroundFoto.load(bitmap) {
                            crossfade(true)
                            crossfade(1000)
                            transformations(CircleCropTransformation())
                        }
                    }

                    GALLERY_REQUEST_CODE -> {
                        bindingFragment.backgroundFoto.load(data?.data) {
                            crossfade(true)
                            crossfade(1000)
                            transformations(CircleCropTransformation())
                        }
                    }
                }
            }
        }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            arrayOf(Manifest.permission.CAMERA)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentAddAdminBinding.inflate(inflater, container, false)
        bindingFragment.buttonBackAddAdmin.setOnClickListener {
            it.findNavController().navigate(R.id.action_addAdminFragment_to_userFragment)
        }

        bindingFragment.buttonAddCameraAdmin.setOnClickListener {
            val pictureDialog = AlertDialog.Builder(requireContext())
            pictureDialog.setTitle("Select Action")
            val pictureDialogItem =
                arrayOf("Select photo from Gallery", "Capture photo from Camera")
            // Request Permissions
            if (allPermissionsGranted()) {
                pictureDialog.setItems(pictureDialogItem) { _, which ->
                    when (which) {
                        0 -> gallery()
                        1 -> camera()
                    }
                }
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
                )
            }
            pictureDialog.show()
        }
        return bindingFragment.root
    }


    private fun gallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        resultLauncher.launch(intent)

    }

    private fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(intent)
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ActivityCompat.checkSelfPermission(
            requireContext(),
            it
        ) == PackageManager.PERMISSION_GRANTED
    }
}
