package dev.tkuenneth.infoplistmanifestdemo.infoplistmanifestdemo

import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusDenied
import platform.AVFoundation.AVAuthorizationStatusRestricted
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType

actual fun checkCameraPermission(): CameraPermission {
    return when (AVCaptureDevice.authorizationStatusForMediaType(AVMediaTypeVideo)) {
        AVAuthorizationStatusAuthorized -> CameraPermission.Granted
        AVAuthorizationStatusRestricted, AVAuthorizationStatusDenied -> CameraPermission.Denied
        else -> CameraPermission.Unknown
    }
}

actual fun requestCameraPermission(callback: (CameraPermission) -> Unit) {
    AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) { granted ->
        callback(if (granted) CameraPermission.Granted else CameraPermission.Denied)
    }
}
