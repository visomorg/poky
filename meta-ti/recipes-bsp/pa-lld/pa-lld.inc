LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/ti/drv/pa/COPYING.txt;md5=e8f6789acdcda76d02ed9203fc2e603d"

COMPATIBLE_MACHINE = "keystone"

BRANCH = "master"
SRC_URI = "git://git.ti.com/keystone-rtos/pa-lld.git;destsuffix=git/ti/drv/pa;protocol=git;branch=${BRANCH}"

# Below Commit ID corresponds to "DEV.PA_LLD.03.00.01.04"
SRCREV = "92de8879be3712af684bd031ca0ed291c05d6050"
PV = "03.00.01.04"
PR = "r1"

BASEDIR = "${WORKDIR}/git"
S = "${BASEDIR}/ti/drv/pa"
