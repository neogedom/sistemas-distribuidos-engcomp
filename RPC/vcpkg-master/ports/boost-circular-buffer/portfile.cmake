# Automatically generated by boost-vcpkg-helpers/generate-ports.ps1

vcpkg_from_github(
    OUT_SOURCE_PATH SOURCE_PATH
    REPO boostorg/circular_buffer
    REF boost-1.73.0
    SHA512 602ab96a2b5189cc37a3cac85fc663fec497674f19ead202170ebe1fc416587b50d8deff5ad274579c75e2ef30f0c832366b3f9bf54733ea659247923cf7d8ad
    HEAD_REF master
)

include(${CURRENT_INSTALLED_DIR}/share/boost-vcpkg-helpers/boost-modular-headers.cmake)
boost_modular_headers(SOURCE_PATH ${SOURCE_PATH})