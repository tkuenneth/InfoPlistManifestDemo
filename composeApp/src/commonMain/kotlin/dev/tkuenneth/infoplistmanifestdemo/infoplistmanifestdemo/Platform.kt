package dev.tkuenneth.infoplistmanifestdemo.infoplistmanifestdemo

enum class CameraPermission { Unknown, Granted, Denied }

expect fun checkCameraPermission(): CameraPermission

expect fun requestCameraPermission(callback: (CameraPermission) -> Unit)
