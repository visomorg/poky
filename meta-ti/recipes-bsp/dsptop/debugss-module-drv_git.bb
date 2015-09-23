DESCRIPTION = "Debug Sub-System (DebugSS) driver for Keystone and DRA7xx devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=9d4316fe434ba450dca4da25348ca5a3"

# This package builds a kernel module, use kernel PR as base and append a local
MACHINE_KERNEL_PR_append = "b"
PR = "${MACHINE_KERNEL_PR}"
PV_append = "+git${SRCPV}"

S = "${WORKDIR}/git/debugss_module/debugss-mod"

inherit module

PLATFORM = ""
PLATFORM_dra7xx = "DRA7xx_PLATFORM"
PLATFORM_keystone = "KEYSTONE_PLATFORM"

EXTRA_OEMAKE = "'PLATFORM=${PLATFORM}' KVERSION=${KERNEL_VERSION} KERNEL_SRC=${STAGING_KERNEL_DIR}"

COMPATIBLE_MACHINE = "dra7xx|keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

include dsptop.inc
