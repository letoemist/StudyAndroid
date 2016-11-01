#include<stdio.h>
#include"HelloJni.h"
jstring Java_com_soling_hellojni_MainActivity_getHelloJniString(JNIEnv * env, jobject classz){
	return (*env)->NewStringUTF(env, "Hello Jni!!!");
}
