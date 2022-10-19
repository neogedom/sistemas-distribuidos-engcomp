# Automatically generated by boost-vcpkg-helpers/generate-ports.ps1

vcpkg_from_github(
    OUT_SOURCE_PATH SOURCE_PATH
    REPO boostorg/parameter
    REF boost-1.73.0
    SHA512 63da1ec9dae999dac3542344a67b58e40928c453f87d7cd71fda858eeb2df48ff0056fe3eee550dff9912602d0595e0c90939dc2fad7851c90285abb72f57087
    HEAD_REF master
)

include(${CURRENT_INSTALLED_DIR}/share/boost-vcpkg-helpers/boost-modular-headers.cmake)
boost_modular_headers(SOURCE_PATH ${SOURCE_PATH})