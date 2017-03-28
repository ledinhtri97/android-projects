#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_io_github_ledinhtri97_choosefood_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Choose your favourite food !";
    return env->NewStringUTF(hello.c_str());
}
