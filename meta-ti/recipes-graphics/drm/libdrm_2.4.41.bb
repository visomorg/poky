require recipes-graphics/drm/libdrm.inc

FILESEXTRAPATHS_append := ":${COREBASE}/meta/recipes-graphics/drm/libdrm"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += "--enable-omap-experimental-api --enable-kms"

SRC_URI = "git://git.ti.com/glsdk/libdrm.git;protocol=git"
SRCREV = "3cb5405084111193cedb8796d259b56560b088f0"

SRC_URI += "file://installtests-ti.patch \
           "

PR = "${INC_PR}.2"

S = "${WORKDIR}/git"
