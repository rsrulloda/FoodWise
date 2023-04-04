package com.example.foodwise.ui.screens

import android.graphics.Bitmap
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class CameraScreen {
    @Composable
    fun Display() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.PhotoCamera,
                contentDescription = "Camera",
                tint = Color.Gray,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Camera",
                color = Color.Gray,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    // Below is the camera code


    // Below is the text recognition code

    // Get the text recognition client
    private fun getTextRecognizer(): TextRecognizer {
        return TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    }

    // Get the image
    fun getImage(rotationDegrees: Int, bitmap : Bitmap) : InputImage{
        // Prepare the input image from a bitmap
        return InputImage.fromBitmap(bitmap, rotationDegrees)
    }

    // Recognize the text from the image
    private fun recognizeText(image: InputImage) {

        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        val result = recognizer.process(image)
            .addOnSuccessListener { visionText ->
                // Task completed successfully
                // Read the text blocks from the image and process the information
                readTextBlock(visionText)
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                // ...
            }
    }

    // Read the text blocks from the image
    private fun readTextBlock(result: Text) {
        val resultText = result.text
        for (block in result.textBlocks) {
            val blockText = block.text
            val blockCornerPoints = block.cornerPoints
            val blockFrame = block.boundingBox
            for (line in block.lines) {
                val lineText = line.text
                val lineCornerPoints = line.cornerPoints
                val lineFrame = line.boundingBox
                for (element in line.elements) {
                    val elementText = element.text
                    val elementCornerPoints = element.cornerPoints
                    val elementFrame = element.boundingBox
                }
            }
        }

    }


//    @Preview(showBackground = true)
//    @Composable
//    fun CameraScreenPreview() {
//        Display()
//    }
}

