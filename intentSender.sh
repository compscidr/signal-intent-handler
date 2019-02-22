# sends the XHIST intent to the android phone connected to USB
# you should see the result of sending the intent by using adb logcat in another terminal
adb shell am broadcast -a io.rightmesh.intent.XHIST

