package dev.tkuenneth.infoplistmanifestdemo.infoplistmanifestdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import infoplistmanifestdemo.composeapp.generated.resources.Res
import infoplistmanifestdemo.composeapp.generated.resources.open_settings
import infoplistmanifestdemo.composeapp.generated.resources.request_permission
import infoplistmanifestdemo.composeapp.generated.resources.take_picture
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            var cameraPermission by remember {
                mutableStateOf(checkCameraPermission())
            }
            Button(onClick = {
                when (cameraPermission) {
                    CameraPermission.Unknown -> requestCameraPermission {
                        cameraPermission = it
                    }

                    else -> {}
                }
            }) {
                Text(
                    stringResource(
                        when (cameraPermission) {
                            CameraPermission.Unknown -> Res.string.request_permission
                            CameraPermission.Granted -> Res.string.take_picture
                            CameraPermission.Denied -> Res.string.open_settings
                        }
                    )
                )
            }
        }
    }
}
