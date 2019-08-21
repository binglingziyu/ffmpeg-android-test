cmake_minimum_required(VERSION 3.4.1)

add_library(
        native-lib
        SHARED
        native-lib.cpp)

find_library(
        log-lib
        log)

find_library(
        android-lib
        android )

# 设置ffmpeg库所在路径的目录
set(distribution_DIR ${CMAKE_SOURCE_DIR}/jniLibs/ffmpeg/${ANDROID_ABI})

set(FFMPEG_INCLUDE_DIR jniLibs/ffmpeg/${ANDROID_ABI}/include)

message(${CMAKE_SOURCE_DIR})
message(${CMAKE_SOURCE_DIR}/jniLibs/ffmpeg/${ANDROID_ABI}/include)


# 添加ffmpeg头文件路径
include_directories(
        ${FFMPEG_INCLUDE_DIR}
)

add_library(
        avutil
        SHARED
        IMPORTED)
set_target_properties(
        avutil
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavutil.so)

add_library(
        avcodec
        SHARED
        IMPORTED)
set_target_properties(
        avcodec
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavcodec.so)

add_library(
        swresample
        SHARED
        IMPORTED)
set_target_properties(
        swresample
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libswresample.so)

add_library(
        avfilter
        SHARED
        IMPORTED)
set_target_properties(
        avfilter
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavfilter.so)

add_library(
        avformat
        SHARED
        IMPORTED)
set_target_properties(
        avformat
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libavformat.so)

add_library(
        swscale
        SHARED
        IMPORTED)
set_target_properties(
        swscale
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libswscale.so)

target_link_libraries(
        native-lib
        avcodec
        avfilter
        avformat
        avutil
        swresample
        swscale
        ${log-lib}
        ${android-lib} )