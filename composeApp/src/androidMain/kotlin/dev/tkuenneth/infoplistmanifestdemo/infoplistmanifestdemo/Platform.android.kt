package dev.tkuenneth.infoplistmanifestdemo.infoplistmanifestdemo

actual fun checkCameraPermission(): CameraPermission = CameraPermission.Unknown

actual fun requestCameraPermission(callback: (CameraPermission) -> Unit) {
}
